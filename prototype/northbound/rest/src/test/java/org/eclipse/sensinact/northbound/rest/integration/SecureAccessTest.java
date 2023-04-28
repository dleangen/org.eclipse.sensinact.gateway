/*********************************************************************
* Copyright (c) 2023 Contributors to the Eclipse Foundation.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*   Kentyou - initial implementation
**********************************************************************/
package org.eclipse.sensinact.northbound.rest.integration;

import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static jakarta.ws.rs.core.HttpHeaders.WWW_AUTHENTICATE;
import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.eclipse.sensinact.northbound.query.api.EResultType;
import org.eclipse.sensinact.northbound.query.dto.result.ResponseGetDTO;
import org.eclipse.sensinact.northbound.query.dto.result.TypedResponse;
import org.eclipse.sensinact.northbound.security.api.Authenticator;
import org.eclipse.sensinact.prototype.PrototypePush;
import org.eclipse.sensinact.prototype.SensiNactSessionManager;
import org.eclipse.sensinact.prototype.generic.dto.GenericDto;
import org.eclipse.sensinact.prototype.security.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opentest4j.AssertionFailedError;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.Configuration;
import org.osgi.test.common.annotation.InjectBundleContext;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.common.annotation.Property;
import org.osgi.test.common.annotation.config.InjectConfiguration;
import org.osgi.test.common.annotation.config.WithConfiguration;
import org.osgi.test.common.service.ServiceAware;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.service.ServiceExtension;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response.Status;

@ExtendWith({ ServiceExtension.class, ConfigurationExtension.class })
public class SecureAccessTest {

    @BeforeEach
    public void await(
            @InjectConfiguration(withConfig = @WithConfiguration(pid = "sensinact.northbound.rest", location = "?", properties = {
                    @Property(key = "allow.anonymous", value = "false"),
                    @Property(key = "fizz", value = "buzz") })) Configuration cm,
            @InjectService(filter = "(fizz=buzz)", cardinality = 0) ServiceAware<Application> a)
            throws InterruptedException {
        a.waitForService(5000);
        for (int i = 0; i < 10; i++) {
            try {
                if (utils.queryStatus("/").statusCode() == 503)
                    return;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Thread.sleep(200);
        }
        throw new AssertionFailedError("REST API did not appear");
    }

    @AfterEach
    public void clear(@InjectConfiguration("sensinact.northbound.rest") Configuration cm) throws Exception {
        cm.delete();
        Thread.sleep(500);
    }

    private static final String PROVIDER = "RestSecureAccessProvider";
    private static final String SERVICE = "service";
    private static final String RESOURCE = "resource";
    private static final Integer VALUE = 42;

    private static final String token = "Open Sesame";

    @InjectService
    SensiNactSessionManager sessionManager;

    @InjectService
    PrototypePush push;

    final TestUtils utils = new TestUtils();

    /**
     * Get the resource value
     */
    @Test
    void resourceGet(@InjectBundleContext BundleContext ctx) throws Exception {
        // Register the resource
        GenericDto dto = utils.makeDto(PROVIDER, SERVICE, RESOURCE, VALUE, Integer.class);
        Instant updateTime = Instant.now().truncatedTo(ChronoUnit.MILLIS);
        push.pushUpdate(dto).getValue();

        String path = String.join("/", "providers", PROVIDER, "services", SERVICE, "resources", RESOURCE, "GET");

        // Check for 503
        HttpResponse<?> response = utils.queryStatus(path);
        assertEquals(Status.SERVICE_UNAVAILABLE.getStatusCode(), response.statusCode());

        ctx.registerService(Authenticator.class, new TokenValidator(token), null);

        response = utils.queryStatus(path);
        assertEquals(UNAUTHORIZED.getStatusCode(), response.statusCode());
        assertEquals("Bearer realm=test", response.headers().firstValue(WWW_AUTHENTICATE).get());

        TypedResponse<?> result = utils.queryJson(path, TypedResponse.class, Map.of(AUTHORIZATION, "Bearer " + token));
        utils.assertResultSuccess(result, EResultType.GET_RESPONSE, PROVIDER, SERVICE, RESOURCE);
        ResponseGetDTO r = utils.convert(result, ResponseGetDTO.class);
        assertEquals(RESOURCE, r.name);
        assertEquals(VALUE, r.value);
        assertEquals(dto.type.getName(), r.type);
        assertFalse(Instant.ofEpochMilli(r.timestamp).isBefore(updateTime), "Timestamp wasn't updated");
    }

    private static class TokenValidator implements Authenticator {

        private final String token;

        public TokenValidator(String token) {
            this.token = token;
        }

        @Override
        public UserInfo authenticate(String user, String credential) {
            return credential.equals(token) ? new TestUserInfo() : null;
        }

        @Override
        public String getRealm() {
            return "test";
        }

        @Override
        public Scheme getScheme() {
            return Scheme.TOKEN;
        }
    }

    private static class TestUserInfo implements UserInfo {

        @Override
        public String getUserId() {
            return "testUser";
        }

        @Override
        public boolean isMemberOfGroup(String group) {
            return false;
        }

        @Override
        public boolean isAnonymous() {
            return false;
        }

        @Override
        public boolean isAuthenticated() {
            return true;
        }

    }
}
