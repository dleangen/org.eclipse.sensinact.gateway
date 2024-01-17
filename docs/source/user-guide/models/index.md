# Models

All good software systems are based on models, and sensiNact is no different.
To be practical, a software system needs to have a model that simplifies the complexity of
the real world, while providing a view rich enough to allow its users to accomplish a
particular purpose.

The objective of sensiNact is to quickly integrate a huge variety of devices with
massive quantities of data in order to analyze and visualize the data.
To fully understand sensiNact, it is important to understand the underlying models
that help the platform achieve this objective.


## Things Model

This model is core to the sensiNact platform, and defines how we view the world
to achieve the objectives of a Smart City IoT Gateway platform.

To understand why we take this approach, you may be interested in our explanation
to the question: [Why sensiNact?](../../why-sensinact.md)

IoT is the Internet of **Things**. These "Things" are modeled by the
[Things Model](things/index.md).

:::{admonition} Note from David
Just trying out this concept.

After all, it is the Internet of **Things**, so I think a Thing model,
to me, makes more sense than a "Core" model. We are not modelling a core, right?

Additional note after the fact: this approach is not an outlier.
The [Web of Things](https://en.wikipedia.org/wiki/Web_of_Things)
also uses the concept of "Things" as a first class citizen.
:::


## Metamodel

sensiNact uses a [metamodel](metamodel.md) for managing and communicating digital twins,
based on our [Things Model](things/index.md).

This means that we have a model for working with models.


## Metrics Model

Eclipse sensiNact provides services for gathering statistics. The gathered data is based on the
[Metrics Model](./metrics.md).



```{toctree}
:maxdepth: 2
:hidden:

things/index
metamodel
metrics
```
