# Digital Twin Model

The Digital Twin Model is a model of a
[Digital Twin](../../concepts/digital-twin.md), based on the concepts from the sensiNact
[Things Model](index.md).

The major components of the Digital Twin Model are **Providers**, **Services**, and **Resources**.
The figure below shows the relationship between these components.

:::{admonition} Note from David
I don't understand the "Model" part, or how it fits into the picture.
:::

![The sensiNact Data Model](../../../../_static/core/datamodel-white.png){.block-center w=15em}

There are two types of *Resources*, data resources and action resources

## Data Resources

A **Data Resource** holds data, and may have zero or more **Metadata Resources** associated with it.
Metadata Resources provide information about the Data Resources, such as a timestamp when the
data was last updated.


## Action resources

**Action Resources** are similar to data resources, but do not have data that can be queried.
Instead, Action Resources represent some actuation capability of a device. Action resources can be triggered using the `ACT` verb. Action resource metadata will include information about the parameters that can be passed when triggering the action.



### The Admin Service

A Provider has an implicit Admin Service. The Admin Service provides information that sensiNact holds
about the device represented by the Digital Twin. 

:::{admonition} Note from David
What does this mean?

> This information may, or may not, correspond to information actually provided by the device.

:::

Notable properties that the Admin Service provides are:

 * `friendlyName` - a human readable name for the device
 * `location` - a GeoJSON string representing the location of the device
 * `icon` - an icon to use when representing the device
