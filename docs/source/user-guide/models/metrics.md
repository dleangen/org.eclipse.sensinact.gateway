# Metrics Model

:::{admonition} Note from David
This probably needs a complete rework.

That said, the concepts of "Stuff" and "Reports" are probably valid concepts,
though we may want a better name instead of "Stuff".
:::

As already introduced, sensiNact uses a model of [Things](things/index.md).
In our Metrics Model, we further include the idea of "Stuff".
Grammatically speaking, Things are the direct objects, and Stuff are indirect objects.
Things are used to track or measure Stuff. Generally it is not the Things we are interested
in analyzing, but rather the Stuff.

Metrics are the types of measurements used to measure and keep track of Things and Stuff.
A series of data about Things or Stuff is called a **Report**.

The sensiNact platform models 4 kinds of Metrics:
1. **Counter**: a simple counter that can be incremented or decremented by 1. Only its current value is used in Reports.
2. **Gauge**: a registered method is called only when a Report is generated. It is supposed to return a number.
3. **Histogram**: a reservoir of values that will be able to generate various statistics on the metric:
   - count of value updates
   - min, max, average values
   - standard deviation
   - median (50th), 75th, 95th, 98th, 99th and 99.9th percentiles
4. **Timer**: a reservoir that keeps track of the time taken to execute a task that will be able to generate various statistics:
   - count of calls
   - min, max, average times to execute task
   - standard deviation
   - median (50th), 75th, 95th, 98th, 99th and 99.9th percentiles
   - average call rate (number of calls per second)
   - average call rates for the last minute, last 5 minutes and last 15 minutes

Rates are given in number of calls per seconds while durations are given in milliseconds.

Note that Metrics can also be used to introspect the sensiNact system itself.
