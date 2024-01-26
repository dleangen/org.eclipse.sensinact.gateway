# Models

All good software systems are based on models, and sensiNact is no different.
To be practical, a software system needs to have a model that simplifies the complexity of
the real world, while providing a view rich enough to allow its users to accomplish a
particular purpose.

As an [integration platform](../concepts/integration.md), one of the principal objectives of sensiNact is to quickly integrate a huge variety of devices and massive quantities of data in order to analyze and visualize the data.
To fully benefit from sensiNact, it is important to understand the underlying models that help the platform achieve this objective.


## Provider-Consumer Model

Within the complex [IoT Ecosystem](../concepts/ecosystem.md), data flows from
[Information Providers](../concepts/data-flow.md#information-providers) to [Information Consumers](../concepts/data-flow.md#information-consumers).
The [Provider-Consumer Model](provider-consumer.md) is core to the sensiNact platform, and defines how sensiNact views the world of IoT
to achieve its objectives as a Smart City integration platform.


## Metamodel

sensiNact uses a [metamodel](metamodel.md) for managing and communicating digital twins,
based on our [Provider-Consumer](provider-consumer.md).

This means that we have a model for working with models.


## Metrics Model

Eclipse sensiNact provides services for gathering statistics. The gathered data is based on the
[Metrics Model](./metrics.md).



```{toctree}
:maxdepth: 2
:hidden:

provider-consumer
metamodel
metrics
```
