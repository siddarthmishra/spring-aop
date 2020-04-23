# `@Order`

#### Problem

How to control the order of advice being applied?

#### Solution

1. Refactor: Place advices in separate Aspects.
2. Then add control order on Aspects using the `@Order` annotation.
3. use `org.springframework.core.annotation.Order`

E.g. `@Order(1)`

##### `@Order` annotation
* Lower number have higher precedence
    * Range : `Integer.MIN_VALUE` to `Integer.MAX_VALUE`
* Does not have to be consecutive. It doesn't care if something is missing.
      * E.g. `@Order(-21)`, `@Order(-5)`, `@Order(0)`, `@Order(2)`, `@Order(5)`, `@Order(10)`, `@Order(87)`.
* Two or more Aspects can have same order e.g. `@Order(0)`. In this case order is undefined for `@Order(0)`. Consider below example. MyShowAspect and MyFunnyAspect will start *AFTER* MyCloudLogAspect and *BEFORE* MyLoggingDemoAspect. But the order is undefined between MyShowAspect and MyFunnyAspect.

~~~
@Order(-21)
public class MyCloudLogAspect {...}

@Order(0)
public class MyShowAspect {...}

@Order(0)
public class MyFunnyAspect {...}

@Order(2)
public class MyLoggingDemoAspect {...}
~~~

