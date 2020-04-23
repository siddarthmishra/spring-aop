# `JoinPoint`

#### Problem
When we are in an Aspect (i.e. for logging)
    
   * How can we access method parameters?
   * e.g. In the below code snippet, how can we log/access parameters passed to addAccount in Aspect?

~~~
Account account = new Account();
account.setName("John Doe");
account.setLevel("Platinum");
theAccountDAO.addAccount(account, true);
~~~

#### Solution
**JoinPoint** : `JoinPoint` has metadata about method call

~~~
...
import org.aspectj.lang.JoinPoint;
...
@Before("...")
public void beforeAddAccountAdvice(JoinPoint joinPoint){
	...
}
~~~

###### Development Process
1. Access and display Method Signature
    * `MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();`
2. Access and display Method Arguments
    * `Object[] args = joinPoint.getArgs();`

###### Example
~~~
@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
public void beforeAddAccountAdvice(JoinPoint joinPoint) {
	System.out.println("beforeAddAccountAdvice");

	// display the method signature
	MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
	System.out.println("\tMethod Signature : " + methodSign);

	// display method arguments
	Object[] args = joinPoint.getArgs();
	for (Object arg : args) {
		System.out.println("\t" + arg);
		if (arg instanceof Account) {
			Account account = (Account) arg;
			System.out.println("\t\tAccount Name : " + account.getName());
			System.out.println("\t\tAccount Level : " + account.getLevel());
		}
	}
}
~~~
