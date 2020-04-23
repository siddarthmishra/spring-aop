# Combining `@Pointcut` Declarations

#### Problem

1. How to apply multiple pointcut expression to single advice?
2. How to execute an advice only if certain condition is met?

For Example, all methods in a package EXCEPT getter/setter methods

#### Solution

*This can be achieved by combining pointcut declaration using logic operator*
>> AND (`&&`), OR (`||`), NOT (`!`)

* Works like an *if* statement
* Execution happens only if it evaluates to true

    * Example : `@Before("expressionOne() && !expressionTwo()")`

e.g. all methods in a package EXCEPT getter/setter methods

~~~
	// pointcut declaration to match methods in a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create point cut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// create pointcut : include package and exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}
~~~