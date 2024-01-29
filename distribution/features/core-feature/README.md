# Feature `core-features`

This is just a temporary place to capture initial notes regarding `core-features`.

The bundle contains the following sesniNact dependencies, listed in alphabetical order:


## Core Top-Level Bundles

These are the bundles that are available in sensiNact Core.

### Bundle `annotation`

This bundle provides a number of Java annotations to facilitate sensiNact development.

### Bundle `api`

This is the core API bundle, and arguably the most important to understand in the entire
Eclipse sensiNact Gateway platform.

    { "id": "org.eclipse.sensinact.gateway.core:api:0.0.2-SNAPSHOT" },

### Bundle `emf-api`

This bundle provides a view of Eclipse EMF.

Honestly, I still don't yet understand why this is even in the Core API. I'm hoping that somebody will enlighten me soon.

Until then, I can't really write much about this if I don't know why it's here.

### Bundle `geo-json`

This bundle provides an adapter API for the GeoJSON Format, as defined
by [RFC7946](https://datatracker.ietf.org/doc/html/rfc7946).

The spec introduces GeoJSON as follows.

> GeoJSON is a geospatial data interchange format based on JavaScript
Object Notation (JSON).  It defines several types of JSON objects and
the manner in which they are combined to represent data about
geographic features, their properties, and their spatial extents.
GeoJSON uses a geographic coordinate reference system, World Geodetic
System 1984, and units of decimal degrees.


### Bundle `impl`

This bundle provides the implementation of the sensiNact Core.

The following APIs are implemented in this bundle:

#### Command
#### DTO
#### Extract
#### The top-level Core API
#### Snapshot
#### Metrics
#### Model
#### Nexus
#### Nexus EMF
#### Nexus EMF Compare
#### Notification
#### Twin
#### Whiteboard

    { "id": "org.eclipse.sensinact.gateway.core:impl:0.0.2-SNAPSHOT" },

## Bundle ``

    { "id": "org.eclipse.sensinact.gateway.core:geo-json:0.0.2-SNAPSHOT" },


## Core Models Bundles

### Bundle `provider`

    { "id": "org.eclipse.sensinact.gateway.core.models:provider:0.0.2-SNAPSHOT" },

### Bundle `metadata`

    { "id": "org.eclipse.sensinact.gateway.core.models:metadata:0.0.2-SNAPSHOT" },


Non-sensiNact dependencies are:

### ``

    { "id": "com.fasterxml.jackson.core:jackson-annotations:2.14.0" },

### ``

    { "id": "com.fasterxml.jackson.core:jackson-core:2.14.0" },

### ``

    { "id": "com.fasterxml.jackson.core:jackson-databind:2.14.0" },

### ``

    { "id": "org.osgi:org.osgi.service.typedevent:1.0.0" },

### ``

    { "id": "org.osgi:org.osgi.util.pushstream:1.0.2" },

### ``

    { "id": "org.eclipse.emf:org.eclipse.emf.common:2.28.0" },

### ``

    { "id": "org.eclipse.emf:org.eclipse.emf.ecore:2.33.0" },

### ``

    { "id": "org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.18.0" },

### ``

    { "id": "org.slf4j:log4j-over-slf4j:1.7.36" },

### ``

    { "id": "org.geckoprojects.emf:org.gecko.emf.osgi.api:5.0.0" },

### ``

    { "id": "org.geckoprojects.emf:org.gecko.emf.osgi.component:5.0.0" },

### ``

    { "id": "org.apache.aries.component-dsl:org.apache.aries.component-dsl.component-dsl:1.2.2" },

### ``

    { "id": "org.apache.aries.typedevent:org.apache.aries.typedevent.bus:0.0.2-SNAPSHOT" },

### ``

    { "id": "io.dropwizard.metrics:metrics-core:4.2.19" }

## Overview of `core-features`

