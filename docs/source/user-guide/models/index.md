# Models

Like all good software systems, sensiNact is based on models. What sets sensiNact apart is that, being a a complex
[IoT Gateway](../concepts/gateway.md), it doesn't rely on just one single model, but rather incorporates a multitude of models.
These models are foundational to its architecture and functionality.

To fully grasp the capabilities and design of sensiNact, it's important to understand these underlying models. Each model plays a distinct role in shaping how sensiNact operates, interacts with other systems, and manages data and processes within the IoT ecosystem.

## Things Model

IoT is the Internet of **Things**. These "Things" are modeled by the
[Things Model](things/index.md).

:::{admonition} Note from David
Just trying out this concept.

After all, it is the Internet of **Things**, so I think a Thing model,
to me, makes more sense than a "Core" model. We are not modelling a core, right?
:::


## Metrics Model

Eclipse sensiNact provides services for gathering statistics. The gathered data is based on the
[Metrics Model](./metrics.md).


```{toctree}
:maxdepth: 2
:hidden:

things/index
metrics
```
