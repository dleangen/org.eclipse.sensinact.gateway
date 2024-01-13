# IoTP

The Web uses HTTP to communicate. In our model, we use what we call **IoTP**, or the
**Internet of Things Protocol** to communicate between the different parts of the
Things Model. If the Providers, Services, and Resources are the objects in the Model,
then the IoTP represents the verbs.

The verbs are GET, DESCRIBE, SET, ACT, SUBSCRIBE and UNSUBSCRIBE.

GET and DESCRIBE are read-only, or non-editing verbs, used to query the state of the Digital Twin without
modifying it.

SET and ACT are write, or editing verbs used to change the state of the Digital Twin.

SUBCRIBE and UNSUBCRIBE allows the caller to watch (or stop watching) changes to the
Digital Twin.

## GET

The simplest verb is **GET**, which is a simple request to read the value of a Resource.


 value, or one of its metadata values, from the sensiNact gateway.

## DESCRIBE

The *DESCRIBE* verb is another read request, but rather than providing access to data or metadata values it provides information about the structure of the described part of the data model. For example a *DESCRIBE* operation on a *Provider* will list the *Services* for that *Provider*, whereas a *DESCRIBE* on a *Resource* will list information about the data and metadata values for the *Resource*.

## SUBSCRIBE

The *SUBSCRIBE* verb allows the caller to watch for changes in the target part of the data model, for example:

 * Lifecyle events for the creation/deletion of a *Provider*, *Service* or *Resource*
 * Changes in the values of *Resource* metadata
 * Changes in the value of a *Resource*
 * Actions ocurring on a *Resource*

## UNSUBSCRIBE

The *UNSUBSCRIBE* verb allows the caller to remove a subscription from an earlier *SUBSCRIBE* call

## SET

The *SET* verb is used to change the value of a *Resource* or to change the metadata associated with a *RESOURCE*

## ACT

The *ACT* verb is used to trigger an *Action Resource*, potentially passing one or more parameters to a device, and potentially returning a value.
