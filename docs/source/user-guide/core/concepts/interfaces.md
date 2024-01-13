# Interfaces

The [IoT Gateway](gateway.md) acts as the hub in the complex [ecosystem](ecosystem.md) by
connecting the various things in the ecosystem. It therefore interfaces with all the various
components. To help make sense of the complexity, the components are generally categorized
into either "northbound" or "southbound".

Correspondingly, there are two [interfaces](../../interfaces/index.md) to the sensiNact Gateway:
[Northbound](../../interfaces/northbound/index.md) and [Southbound](../../interfaces/southbound/index.md).
The idea of using a directional analogy has been used commonly in the IoT world for some time.

As illustrated in a typical layered architectural diagram, "low-level" services are drawn below
the platform layer, while "high-level" services are drawn above the platform layer.
Traditionally, geographical maps are drawn with the north at the top of the map, and the
south at the bottom.

At some point, the north/south analogy was used to situate and distinguish two types of services
in an IoT platform: devices and analytical services. The idea stuck, and is still in common use today.

:::{admonition} Note from David
A figure here would be nice.
:::

Devices provide data to the system, so are generally associated with the low-level layer. Hence,
"southbound" providers refer to the connection between the platform and the devices that provide
data.

Visualization and analysis services consume the data, and are therefore associated with a high-level layer.
Thus, "northbound" refers to this category of services.
