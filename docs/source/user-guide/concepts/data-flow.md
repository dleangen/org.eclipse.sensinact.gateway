# Data Flow

The [Internet of Things](iot.md) is an evolving landscape, and is no longer just about "things".
Data can come from virtually anywhere, from the simplest sensors to complex data-intense systems.
We call these sources of data "Information Providers" and anything that uses the data
"Information Consumers". This tends to create a directional flow of information from the providers
towards the consumers.

:::{admonition} Note from David
A figure here would be nice.
:::

A [Data Gateway](integration.md#data-gateway) functions as the central hub in an [IoT Ecosystem](ecosystem.md),
interfacing with both Information Providers and Consumers.
The Gateway helps to manage and direct the flow of data within the IoT network.

## Information Providers

In the Internet of Things, data derives from "things" such as sensors or other devices. However,
the "things" are becoming increasingly complex. Furthermore, as data flows, it can be aggregated and
processed by other complex systems. The flow of data is potentially infinitely complex, which is why the name
"Internet of Things" is no longer entirely accurate.

Regardless of whether a source of data is a simple sensor with merely an `on|off` state or a complex
database, we call these sources "Information Providers".

Information Providers are diverse and can include:

- **Traditional IoT Devices**: Such as sensors and actuators.
- **Environmental Data Sources**: Providing information on weather, pollution, etc.
- **Public and Private Data Services**: Offering traffic updates, news feeds, and more.
- **Complex Systems**: Like integrated enterprise solutions, smart city infrastructure, and cloud-based services.

## Information Consumers

On the other end are Information Consumers, which utilize the data provided for various purposes:

- **Data Analytics and Visualization Tools**: Transforming raw data into actionable insights.
- **Smart Applications**: Ranging from home automation to sophisticated industrial control systems.

Although Information Consumers can themselves provide information to other consumers, generally speaking
from the perspective of an IoT [Integration Platform](integration.md) we categorize them into Providers
if they are sources of data from the perspective of the platform, and Consumers if they are plugging into
the platform and using data.

## Polarity

We often visualize an data hub as having two poles: north and south.
Data flows from the south to the north. The platform has two interfaces for these dataflows:
[northbound](../interfaces/northbound.md) and [southbound](../interfaces/southbound/index.md).

:::{admonition} Note from David
A figure here would be nice.
:::


### Southbound Interfaces

Southbound interfaces connect the data to the Information Providers. Since data is flowing from
the "south" to the "north", the term "southbound" is actually a misnomer, but from the perspective of the 
data hub, a southbound interface includes:

- **Connectivity**: Facilitating communication with Information Providers.
- **Data Ingestion**: Aggregating and processing data from various sources.
- **Protocol Translation**: Ensuring compatibility between different data formats and protocols.

### Northbound Interfaces

Northbound interfaces, conversely, link the gateway to Information Consumers. They handle:

- **Data Availability**: Making processed data available to applications and services.
- **APIs and Integration Points**: Allowing for seamless integration with analytical tools and other high-level services.
- **User Access and Control**: Enabling users to interact with and control IoT systems.

