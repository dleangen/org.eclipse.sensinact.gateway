/*********************************************************************
 * Copyright (c) YYYY Contributors to the Eclipse Foundation.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Markus Hochstein
 **********************************************************************/

import Vue, { VNode } from 'vue'

declare global {
  namespace JSX {
    interface Element extends VNode {}
    interface ElementClass extends Vue {}
    interface IntrinsicElements {
      [elem: string]: any
    }
  }
}
