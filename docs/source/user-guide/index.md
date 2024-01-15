# User Guide

:::{warning}
Please note that since sensiNact is currently in its incubation phase, the documentation provided here is a work in progress. We are continuously working to improve and update the documentation.
:::

Welcome to the user reference documentation for the Eclipse sensiNact Gateway (sensiNact). sensiNact is a versatile platform designed for the integration, management, and analysis of IoT networks. It offers tools for effective monitoring and controlling a wide range of IoT devices.

:::{admonition} Note from David
The above intro needs to be consistent with the Welcome Page.

For this, the sensiNact vision needs to be clarified somewhere.
:::


Before getting started, please ensure that you understand the [requirements](requirements.md).

The documentation is divided into 4 sections:

 1. [Core Concepts](concepts/index.md)
 2. [Models](models/index.md)
 3. [Gateway Interfaces](interfaces/index.md)
 4. [Extensions](extensions/index.md)

```{toctree}
:maxdepth: 4
:numbered:
:hidden:

requirements
concepts/index
models/index
interfaces/index
extensions/index
```
:::{admonition} Note from David - **What is "Core"?**
Understanding the "Core" in sensiNact

sensiNact is an IoT Gateway platform that provides essential services for managing IoT networks.

The term "Core" in sensiNact does not represent a modeling concept but rather serves as an organizational concept. It refers to services that are fundamental and integral to the purpose and functionality of the framework. The "Core" services are the building blocks of sensiNact, and they underpin its key functionality.

It's important to note that, for most users, especially those who are not deeply involved in the platform's development (such as end-users and operators), the concept of "Core" may not be particularly relevant or necessary to understand.

In user documentation, it is more appropriate to state, for example, that "Metrics is a core API" or "Metrics is fundamental to the sensiNact platform" to emphasize its importance. Avoiding phrases like "Metrics is part of the sensiNact Core" helps prevent potential confusion.

In essence, "Core" serves an organizational purpose within the sensiNact framework, grouping together services that are fundamental to its operation. It's not a distinct entity that was designed and populated; instead, it reflects the pervasive and essential nature of certain services within the platform.

:::