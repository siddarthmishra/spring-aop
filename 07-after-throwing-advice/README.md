# `@AfterThrowing` Advice

###### This advice runs custom code AFTER the Target Object method throws an EXCEPTION
* `@AfterThrowing` annotation
* use `org.aspectj.lang.annotation.AfterThrowing`

e.g. `@AfterThrowing("execution(* com.luv2code.aopdemo.dao.AccountDAO.method1(..))")`

#### `@AfterThrowing` Advice - Use Case
* Log exception
* Perform auditing on the exception
* Notify DevOps team via email or SMS
* Encapsulate this functionality in AOP aspect for easy reuse
    
#### Access the Exception Object in `@AfterThrowing` Advice
* Need to access the exception object for logging
    
###### Example

~~~
...
@AfterThrowing(
	pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
	throwing = "theExe")
public void afterThrowingFindAccountsAdvice(Throwable theExe) {
	...
	// log the exception
	System.out.println("===>>> The Exception is : " + theExe);
	...
}
~~~

* Here, advice argument is always `Throwable` since we know exception will be thrown.
* Important point to note here is that value of `throwing` in `@AfterThrowing` and variable name of `Throwable` in parameter should be same. Here both are same as below

~~~
throwing = "theExe"
Throwable theExe
~~~
Names can be anything but should be same.

If both are different, an exception would be raised. Let's replace `throwing = "theExe"` with `throwing = "theException"`.
>>Caused by: java.lang.IllegalStateException: Throwing argument name 'theException' was not bound in advice arguments

#### Exception Propagation
* At this point, we are only intercepting the exception(reading it)
* However, the exception is still propagated to calling program

>> So the exception process or the propagation still happens in its normal fashion. We simply have a chance to kind of peak at it. See the exception and log it. The exception still works with the normal Java exception handling.

##### *If you want to stop the exception propagation then use the* `@Around` *advice*