# `@Pointcut` Declarations

1. How can we reuse a pointcut expression or how can we apply it to multiple advices?
    * By using pointcut declarations	

2. How to declare pointcut declaration?
    * By using `@Pointcut` annotation. Pointcut expression is placed in `@Pointcut` annotation.
    * use `org.aspectj.lang.annotation.Pointcut`
    * Create a pointcut declaration once and apply it to multiple advices

e.g.

~~~
	// pointcut declaration to match any methods of any class in the specified package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}
	
	// pointcur declaration method name 'forDaoPackage()' is used in Advice
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("===>>> Performing API Analytics");
	}
~~~