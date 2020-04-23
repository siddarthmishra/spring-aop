# `@AfterReturning` Advice

###### This advice runs custom code AFTER the Target Object method is successfully executed (no exceptions)
* `@AfterReturning` annotation
* use `org.aspectj.lang.annotation.AfterReturning`

e.g. `@AfterReturning("execution(* com.luv2code.aopdemo.dao.AccountDAO.method1())")`

#### `@AfterReturning` Advice - Use Case
* **Most common**
    * logging, security, transaction
* **Audit logging**
    * who, what, when, where
* **Post-processing Data**
    * Post process the data before returning to caller
    * Format the data or enrich the data (really cool but be careful)
    
#### Access the return value in `@AfterReturning` Advice
* need to access the return value of the method
    * either to log or for post processing the data
    
###### Example

~~~
...
@AfterReturning(
	pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
	returning = "listOfAccounts")
public void afterReturningFindAccountsAdvice(List<Account> listOfAccounts) {
	...
	// print out the results of the method call
	System.out.println("===>>> result is : " + listOfAccounts);
	...
}
~~~

* Here, We already know that the return type from the service AccountDAO.findAccounts() is `List<Account>`
* Important point to note here is that value of `returning` in `@AfterReturning` and variable name of return type in parameter should be same. Here both are same as below

~~~
returning = "listOfAccounts"
List<Account> listOfAccounts
~~~
Names can be anything but should be same.

If both are different, an exception would be raised. Let's replace `returning = "listOfAccounts"` with `returning = "result"`.
>>Caused by: java.lang.IllegalStateException: Returning argument name 'result' was not bound in advice arguments