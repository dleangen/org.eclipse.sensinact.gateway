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

The main characteristic of a Thing is that, as a single unit, it has various properties,
can provide data, and can potentially perform actions.

Examples of Things are:

 - Smart watches
 - Thermometers
 - Light sensors
 - Smart appliances
 - Smart plugs

## Resource

Some of the properties of a Thing are **Resources**. Resources (big "R") are to the Internet of Things
as web [resources](https://en.wikipedia.org/wiki/Web_resource) (little "r") are to the Web.
Just like the Web provides access to resources (little "r"), the Internet of Things provides
access to Resources (big "R").

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

## Service 

A **Service** is a logical grouping of one or more Resources that are related, and that
both belong to the same Thing.

:::{admonition} Note from David
Do Services have to belong to the same Thing?
:::

If we reuse our smart plug example above, we might have two services:

1. Switch Service - a service representing the switching capability of the smart plug
   - state: a data resource representing the state of the switch, either ON or OFF
   - toggle: an action resource which changes the state of the switch

2. Monitor Service - a service that monitors the power for the smart plug
   - current: a data resource providing the value of the current passing through the plug
   - power: a data resource providing the value of the power passing through the plug

## Provider

A **Provider** is a logical representation of a Thing that can be made available within sensiNact
and that provides one or more Services.

A Thing that does not provide any Services is not useful, and is not considered by the Things Model.

Also, any resource that could never be connected to sensiNact is not considered by the Things Model.

The description of the Services (and consequently the Resources) associated with a Provider is known
as the **Provider Model**.


```{toctree}
:maxdepth: 2
:hidden:

digital-twin-model
iotp
```
