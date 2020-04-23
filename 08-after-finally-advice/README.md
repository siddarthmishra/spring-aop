# `@After` (finally) Advice

###### This advice runs custom code AFTER the Target Object method execution is completed regardless of outcome/exceptions. It will always run for success or failure. It works just like finally block.
* `@After` annotation
* use `org.aspectj.lang.annotation.After`

e.g. `@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.method1(..))")`

**Note:** `@After` will execute *before* `@AfterReturning` / `@AfterThrowing`

Flow of execution
1. `@After`
2. `@AfterReturning` / `@AfterThrowing` (either of one will be executed)
	
Just like Java, finally block is executed first before exception is thrown

#### `@After` Advice - Use Case
* Log the exception and/or perform auditing
* Code to run regardless of method outcome
* Encapsulate this functionality in AOP aspect for easy reuse

#### `@After` Advice - Tips
1. The `@After` advice does not have access to the exception
    * If you need exception, then use `@AfterThrowing` advice
2. The `@After` advice should be able to run in the case of success or error
    * Your code should not depend on happy path or an exception
    * Logging/auditing is the easiest case here
    
###### Example

~~~
...
@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

	// print out which method we are advising on
	String method = joinPoint.getSignature().toShortString();
	System.out.println("===>>> Executing @After (finally) on method : " + method);
}
...
~~~