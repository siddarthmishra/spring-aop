# `@Before` Advice

###### This advice runs custom code BEFORE the Target Object method call

#### `@Before` Advice - Use Cases
* **Most common**
    * logging, security, transaction
* **Audit logging**
    * who, what, when, where
* **Exception Handling**
    * log exception and notify DevOps team via SMS/email
* **API Management**
    * how many times has a method been called user
    * analytics: what are peak times? what is average load? who is top user?
    
e.g.

~~~
	...
	import org.aspectj.lang.annotation.Before;
	...
	// below matches any addAccount() method in any class
	@Before("execution(public void addAccount())")
	public void m1BeforeAddAccountAdvice() {
		System.out.println("m1BeforeAddAccountAdvice");
	}
~~~

#### Pointcut Expression Language
* Spring AOP uses AspectJ's pointcut expression language

* We will start with *execution* pointcuts
    * Applies to *execution* of methods

###### execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)

* modifiers-pattern is optional
* return-type-pattern is mandatory
* declaring-type-pattern is optional. It is nothing but fully qualified name.
* method-name-pattern is mandatory
* param-pattern is mandatory
    * () - matches a method with no arguments
    * (*) - matches a method with one argument of any type
    * (..) - matches a method with 0 or more arguments of any type
* throws-pattern is optional

Patterns can make use of wildcards. E.g. * (matches on everything)

###### Examples
1. *Match on method names*
    * Match only **addAccount()**  method in **AccountDAO** class
    `@Before(execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount()))`
    * Match any **addAccount()** method in **any** class
    `@Before(execution(public void addAccount()))`
    * Match methods **starting** with **add** in **any** class
    `@Before(execution(public void add*()))`
    * Use wildcards on modifiers and return type
    `@Before(execution(* processCreditCard*()))`

2. *Match on method parameters*
    * Match **addAccount** methods with **no arguments**
    `@Before(execution(* addAccount()))`
    * Match **addAccount** methods that have **Account** param
    `@Before(execution(* addAccount(com.luv2code.aopdemo.Account)))`
    * Match **addAccount** methods with **any number of arguements**
    `@Before(execution(* addAccount(..)))`
    
3. *Match on methods in a package*
    * Match any method in our DAO package: **com.luv2code.aopdemo.dao**
    `@Before(execution(* com.luv2code.aopdemo.dao.*.*(..)))`
