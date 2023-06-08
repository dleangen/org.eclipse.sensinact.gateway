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
package org.eclipse.sensinact.gateway.northbount.sensorthings.mqtt.mappers;

import java.util.stream.Stream;

import org.eclipse.sensinact.core.command.GatewayThread;
import org.eclipse.sensinact.core.notification.ResourceDataNotification;
import org.eclipse.sensinact.gateway.northbount.sensorthings.mqtt.SensorthingsMapper;
import org.eclipse.sensinact.sensorthings.sensing.dto.HistoricalLocation;
import org.osgi.util.promise.Promise;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HistoricalLocationsMapper extends SensorthingsMapper<HistoricalLocation> {

    public HistoricalLocationsMapper(String topicFilter, ObjectMapper mapper, GatewayThread thread) {
        super(topicFilter, mapper, thread);
    }

    @Override
    public Promise<Stream<HistoricalLocation>> toPayload(ResourceDataNotification notification) {
        if ("admin".equals(notification.service) && "location".equals(notification.resource)) {
            return decorate(getProvider(notification.provider).map(p -> DtoMapper.toHistoricalLocation(jsonMapper, p)));
        }
        return emptyStream();
    }

    @Override
    protected Class<HistoricalLocation> getPayloadType() {
        return HistoricalLocation.class;
    }
}
