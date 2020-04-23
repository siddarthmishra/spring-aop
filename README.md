# *Spring AOP*
___

#### Benefits of AOP
* **Code for Aspect is defined in a single class**
    * Much better than being scattered everywhere
    * Promotes code reuse an easier to change
* **Business code in your application is cleaner**
    * Only applies to business functionality: addAcount()
    * Reduce code complexity
* **Configurable**
    * Based on configuration, apply Aspects selectively to different parts of app
    * No need to make changes to main application code

#### AOP Terminology
* **Aspect**: module of code for a cross-cutting concern (logging, security)
* **Advice**: What action is taken and when it should be applied
* **Join Point**: When to apply code during program execution
* **Pointcut**: A predicate expression for where advice should be applied

#### Advice Types
* **Before advice**: run before the method
    * `@Before` annotation
    * use `org.aspectj.lang.annotation.Before`
* **After returning advice**: run after the method (success execution)
    * `@AfterReturning` annotation
    * use `org.aspectj.lang.annotation.AfterReturning`
* **After throwing advice**: run after method (if exception thrown)
    * `@AfterThrowing` annotation
    * use `org.aspectj.lang.annotation.AfterThrowing`
* **After finally advice**: run after the method (finally)
    * `@After` annotation
    * use `org.aspectj.lang.annotation.After`
* **Around advice**: run before and after method
    * `@Around` annotation
    * use `org.aspectj.lang.annotation.Around`

#### Spring AOP Roadmap
* Create **Aspects**
* Develop **Advices**
    * *Before*, *After returning*, *After throwing*
    * *After finally*, *Around*
* Create **Pointcut** expressions

#### Additional AOP Use Cases
* **Most common**
    * logging, security, transaction
* **Audit logging**
    * who, what, when, where
* **Exception Handling**
    * log exception and notify DevOps team via SMS/email
* **API Management**
    * how many times has a method been called user
    * analytics: what are peak times? what is average load? who is top user?

#### Best Practices: Aspect and Advice
* Keep the code small
* Keep the code fast
* Do not perform any expensive / slow operations
* Get in and out as QUICKLY as possible