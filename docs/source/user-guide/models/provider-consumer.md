# Dataflow Model

Eclipse sensiNact is an advanced [IoT Integration Platform](../concepts/integration.md).
As such, it has to be able to quickly integrate a wide variety of
[Information Providers](../concepts/data-flow.md#information-providers) and
[Information Consumers](../concepts/data-flow.md#information-consumers).

To do this effectively, we had to devise a general, flexible, and simple model to describe
both Information Providers and Information Consumers.

Consequently, our **Provider-Consumer Model** gives us a generalized view of the world,
which allows sensiNact to accomplish its objectives. Knowing this model is key
to understanding how sensiNact works.

## Information Provider

An **Information Provider** (or more succinctly, a **Provider**) is a general abstraction for anything that is a source of information.
It could be anything from a simple sensor to a complex analytics system. To qualify
as a potential Information Provider, it just needs to emit meaningful data.

The concept of a Provider is perhaps the most fundamental to sensiNact. As an integration platform, one of the principal functions of the system is to accept and route massive quantities of data.

Although data mainly flows [northbound](../concepts/data-flow.md#northbound-interfaces), note that messages can flow
[southbound](../concepts/data-flow.md#southbound-interfaces) as well, as we explain in more detail below.
So, the label "Information Provider" should not be taken to assume that messages only flow in a single direction.
Data mainly flows northbound in the form of messages, but in some cases "commands" can also flow southbound.
Although sensiNact handles both directions, it favours the northbound flow of data, as this has become the primary concern
of Smart Cities and other data-intense [Verticals](../concepts/verticals.md).

Information Providers have a single `name` property, which also acts as its unique identifier.

An Information Provider emits meaningful data via one or more Services.
As we explain below, information flowing from the Provider is organized as Services.

## Information Service

An **Information Service** (or just **Service** when the context is clear) is a logical grouping of one or more related data sources. The data is aggregated into a coherent source of Information.

By "Information", we mean some structured set of data that has meaning to Consumers.

## Resource

A Resource is the smallest conceptual unit in the Provider-Consumer Model. Related Resources that are grouped together
for a particular purpose comprise a Service.

There are two types of Resources, Data Resources and Action Resources.

Data Resources emit data that aggregates into Information.
Action Resources accept messages, which flow in the opposite direction of the data.

### Data Resources

A **Data Resource** holds data, and may have zero or more **Metadata Resources** associated with it.
Metadata Resources provide information about the Data Resources, such as a timestamp when the
data was last updated.

:::{admonition} Note from David
Include an example.
:::

Data Resources emit data that gets aggregated into more meaning Information.

:::{admonition} Note from David
Is the data queried, or emitted? I.e. push, pull, or either/both?
:::

### Action Resources

**Action Resources** are similar to data resources, but do not have data that it emitted.
Instead, Action Resources represent some actuation capability of a device. These resources
accept messages that can cause some kind of action to occur.

:::{admonition} Note from David
Include an example.
:::
