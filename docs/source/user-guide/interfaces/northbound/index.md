# Northbound Interfaces

![Users using Northbound providers to communicate with the Eclipse sensiNact Digital Twin](../../../_static/northbound/northbound-provider-white.png){.float-right w=20em}

[TODO: What is meant by "user"?]


The *northbound* API of Eclipse sensiNact gateway refers to the parts of the gateway which interface with users and/or machines to provide access to the digital twin. This is typically using a specific protocol over a more generic transport (e.g. REST/HTTP or JSON-RPC/Websocket). It is possible to have multiple northbound providers deployed to a single Eclipse sensiNact gateway instance, allowing access via different interfaces, protocols and transports.

<p class="clear-right"/>

The gateway currently includes the following northbound interfaces:

* A [REST API](rest.md){.clear-right} using Jakarta RESTful Web Services
* A [Websocket API](websocket.md) using Jetty Websockets
* A [REST API](sensorthings-rest.md) for [OGC Sensorthings 1.1](https://docs.ogc.org/is/18-088/18-088.html#sensorthings-serviceinterface) using Jakarta RESTful Web Services
* An [MQTT API](sensorthings-mqtt.md) for [OGC Sensorthings 1.1](https://docs.ogc.org/is/18-088/18-088.html#receive-mqtt-subscribe) using [Moquette](https://github.com/moquette-io/moquette)

```{toctree}

rest
websocket
sensorthings-rest
sensorthings-mqtt
```
