/*
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    CEA - initial API and implementation
 */

package org.eclipse.sensinact.gateway.nthbnd.http.forward.test.bundle1;

import org.eclipse.sensinact.gateway.common.bundle.AbstractActivator;
import org.eclipse.sensinact.gateway.common.bundle.Mediator;
import org.eclipse.sensinact.gateway.nthbnd.http.forward.ForwardingService;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractActivator<Mediator>
{
	@Override
	public void doStart() throws Exception {
		super.mediator.register(new ForwardingServiceImpl(), ForwardingService.class, null);
	}

	@Override
	public void doStop() throws Exception {
		//do nothing
	}

	@Override
	public Mediator doInstantiate(BundleContext context) {
		return new Mediator(context);
	}
}
