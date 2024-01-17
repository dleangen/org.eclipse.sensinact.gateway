# Metamodel

A [Digital Twin](things/index.md#digital-twin) is a model of a an actual, specific
[Thing](things/index.md#thing) that exists in the real world.
The Digital Twin, as the name implies, is a digital replica of the physical object.
For each specific Digital Twin model, sensiNact's has a model for this model, i.e. a metamodel.

:::{admonition} Note from David
A figure here would help a lot to explain this difficult concept.
:::

The sensiNact platform uses this metamodel to allow for the dynamic creation of Digital Twins.
Models can be created in Java code, by using data, or by importing as a pre-defined model in XML, for instance. sensiNact attempts to automate as much of the the model creation as possible.
Digital Twin models can also be updated and expanded as necessary.

:::{admonition} Note from David
I'm having a lot of difficulty explaining why this ought to be a necessary concept.

I assume it is important, because it was in the existing documentation.
Why would anybody need to know about EMF, or the metamodel?
:::