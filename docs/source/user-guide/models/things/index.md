# Things Model

A complex software system that is built and used by many people needs a model in order to make
its design, operation, and use feasible. The model bridges the domain concepts with the
software engineering.

The [IoT Gateway](../../concepts/gateway.md) is the hub for connecting the "Things"
in the Internet of Things. sensiNact has its own internal model for representing
these Things, and how they interact with the Internet via the Gateway.

Consequently, our **Things Model** is a more specific representation of the Internet of Things
than what you would commonly find in the literature.

## Thing

A **Thing** is a general abstraction for some physical object.
Usually, this object is a device, or even possibly a group of devices.
Although a Thing is often a device, it can be almost any "thing", and we
should not limit our thinking too much.

The main characteristic of a Thing is that, as a single unit, it has various properties,
can provide data, and can potentially perform actions.

Common examples of Things are:

 - Smart watches
 - Thermometers
 - Light sensors
 - Smart appliances
 - Smart plugs

## Resource

**Resources** are properties of a Thing. Resources (big "R") are to the Internet of Things
what web [resources](https://en.wikipedia.org/wiki/Web_resource) (little "r") are to the Web.
Just like the Web provides access to resources (little "r"), the Internet of Things provides
access to Resources (big "R"). If a server provides access to resources (little "r") on the Web,
a Thing provides access to Resources (big "R") on the Internet of Things.

A Thing will generally have one or more Resources.

:::{admonition} Note from David
A figure here would be groovy.
:::

If we consider a smart plug, some examples of Resources associated with the plug are:

 - State: a data resource representing the state of the switch, either ON or OFF
 - Toggle: an action resource which changes the state of the switch
 - Current: a data resource providing the value of the current passing through the plug
 - Power: a data resource providing the value of the power passing through the plug
 
 :::{admonition} Note from David
Is a Resource guaranteed to belong to one and only one Thing?
I.e. a Resource cannot be spread out between two Things?
:::

There are two types of Resources, Data Resources and Action Resources.

### Data Resources

A **Data Resource** holds data, and may have zero or more **Metadata Resources** associated with it.
Metadata Resources provide information about the Data Resources, such as a timestamp when the
data was last updated.


### Action resources

**Action Resources** are similar to data resources, but do not have data that can be queried.
Instead, Action Resources represent some actuation capability of a device. 


## Service 

A **Service** is a logical grouping of one or more Resources that are related, and that
both belong to the same Thing. Again using the Web analogy, a Service could be compared to
an application: a Service is a collection of Resources (big "R"), while an application on the
Web is a collection of resources (little "r").

:::{admonition} Note from David
Do Services have to belong to the same Thing?
:::

:::{admonition} Note from David
Is a Service also a Resource?
If we use the Web analogy, it may make sense to consider a Service as also being a Resource.
:::

If we reuse our smart plug example above, we might have two services:

1. Switch Service - a service representing the switching capability of the smart plug
   - state: a data resource representing the state of the switch, either ON or OFF
   - toggle: an action resource which changes the state of the switch

2. Monitor Service - a service that monitors the power for the smart plug
   - current: a data resource providing the value of the current passing through the plug
   - power: a data resource providing the value of the power passing through the plug

## Provider

A **Provider** provides Services.

One way to think of Services and Providers is by using the analogy of a restaurant.
The restaurant makes dishes. A service at a restaurant, like a lunch service, will
have a menu of dishes. The restaurant offers the service by serving the menu.
Any other restaurant could also offer the same service.

Likewise, a Provider offers a Service, which has a menu of Resources. Other Providers
could also offer the same Service.

A Provider is matched 1:1 with a service. A Thing may have more than one Provider.

<!-- old text
A **Provider** is a logical representation of a Thing that can be made available within sensiNact
and that provides one or more Services.

A Thing that does not provide any Services is not useful, and is not considered by the Things Model.

Also, any resource that could never be connected to sensiNact is not considered by the Things Model.

The description of the Services (and consequently the Resources) associated with a Provider is known
as the **Provider Model**.
-->

:::{admonition} Note from David
A figure would be helpful here.
:::


## Digital Twin

The **Digital Twin Model** based on the concept of a
[Digital Twin](../../concepts/digital-twin.md), and is an instantiation of a
[Thing](index.md#thing). While a Thing is a very general description, applicable to any "thing",
a Digital Twin is a virtual copy of a specific "thing".

Conformant with the Thing Model, the major components of the Digital Twin are **Providers**, **Services**, and **Resources**.
The figure below shows the relationship between these components.

:::{admonition} Note from David
I don't understand the "Model" part, or how it fits into the picture.
:::

![The sensiNact Data Model](../../../_static/core/datamodel-white.png){.block-center w=15em}


<!-- Maybe don't need this here?

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

-->


```{toctree}
:maxdepth: 2
:hidden:

iotp
```
