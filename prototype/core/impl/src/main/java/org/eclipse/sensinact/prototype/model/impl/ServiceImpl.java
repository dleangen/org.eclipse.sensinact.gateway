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
package org.eclipse.sensinact.prototype.model.impl;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sensinact.prototype.command.impl.CommandScopedImpl;
import org.eclipse.sensinact.prototype.model.Model;
import org.eclipse.sensinact.prototype.model.Resource;
import org.eclipse.sensinact.prototype.model.ResourceBuilder;
import org.eclipse.sensinact.prototype.model.Service;
import org.eclipse.sensinact.prototype.model.nexus.ModelNexus;

public class ServiceImpl extends CommandScopedImpl implements Service {

    private final Model model;
    private final EReference service;
    private final ModelNexus nexusImpl;

    public ServiceImpl(AtomicBoolean active, Model model, EReference service, ModelNexus nexusImpl) {
        super(active);
        this.model = model;
        this.service = service;
        this.nexusImpl = nexusImpl;
    }

    @Override
    public String getName() {
        checkValid();
        return service.getName();
    }

    @Override
    public boolean isExclusivelyOwned() {
        checkValid();
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean isAutoDelete() {
        checkValid();
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ResourceBuilder<Resource, Object> createResource(String resource) {
        checkValid();
        return new ResourceBuilderImpl<Resource, Object>(active, null, this, resource, nexusImpl);
    }

    @Override
    public Map<String, ? extends Resource> getResources() {
        checkValid();
        return nexusImpl.getResourcesForService(getServiceEClass())
                .collect(Collectors.toMap(f -> f.getName(), f -> new ResourceImpl(active, this, f)));
    }

    @Override
    public Model getModel() {
        checkValid();
        return model;
    }

    EClass getServiceEClass() {
        return service.getEReferenceType();
    }
}
