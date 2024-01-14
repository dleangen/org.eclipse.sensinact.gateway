# Other stuff to complete later.

entries associated with it. For brevity we will use the term `field` to refer to both value and metadata entries.

The `fields` of a resource have associated time stamps representing the times at which they were last updated. They also have an associated property indicating how their value can change.

## Read-only fields

A read-only field is one cannot be changed by sensiNact. Read-only fields may be `UPDATABLE` and have the potential to change over time (e.g. the data reading from a sensor) or `FIXED` and unchanging (e.g. a hardware identifier reported by a device).

The value of a read-only field can be queried using the `GET` verb, or watched using the `SUBSCRIBE` verb.

## `MODIFIABLE` fields

A `MODIFIABLE` field is one that can be changed by sensiNact. It may represent a configuration property for a device, or a direct output.

The value of a `MODIFIABLE` field can be queried using the `GET` verb, watched using the `SUBSCRIBE` verb, or changed using the `SET` verb.



