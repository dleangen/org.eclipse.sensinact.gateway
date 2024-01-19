# User Guide

Eclipse sensiNact is an Open Source integration framework for Smart Cities.

Although sensiNact can be used in various IoT settings, 
it is particularly useful for Smart City applications. Our approach is to be technology agnostic
in order to integrate virtually any IoT technology, and the platform
is optimized for the collection, analysis, and visualization of massive quantities of data.

:::{warning}
Please note that since the sensiNact project is currently in its incubation phase, the documentation provided here is a work in progress. We are continuously working to improve and update the documentation.
:::

This User Guide provides mainly high-level conceptual descriptions of sensiNact, including
the environment in which it is used, what problems it attempts to solve, who it is for, and
how it is different from other IoT platforms.

If you are new to sensiNact, we recommend that you start here.

If you are itching to just get started, we have a [Quick Start Guide](../getting-started/index.md).

A more in-depth [Developer Guide](../developer-guide/index.md) is available as a more technical reference.

## Contents

```{toctree}
:maxdepth: 1
:numbered:

overview
requirements
concepts/index
comparison
models/index
interfaces/index
integrations/index
```

<!--
:::{admonition} Note from David - **What is "Core"?**
Understanding the "Core" in sensiNact

sensiNact is an IoT Gateway platform that provides essential services for managing IoT networks.

The term "Core" in sensiNact does not represent a modeling concept but rather serves as an organizational concept. It refers to services that are fundamental and integral to the purpose and functionality of the framework. The "Core" services are the building blocks of sensiNact, and they underpin its key functionality.

It's important to note that, for most users, especially those who are not deeply involved in the platform's development (such as end-users and operators), the concept of "Core" may not be particularly relevant or necessary to understand.

In user documentation, it is more appropriate to state, for example, that "Metrics is a core API" or "Metrics is fundamental to the sensiNact platform" to emphasize its importance. Avoiding phrases like "Metrics is part of the sensiNact Core" helps prevent potential confusion.

In essence, "Core" serves an organizational purpose within the sensiNact framework, grouping together services that are fundamental to its operation. It's not a distinct entity that was designed and populated; instead, it reflects the pervasive and essential nature of certain services within the platform.

:::
-->