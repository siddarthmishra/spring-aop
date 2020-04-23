package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	// this will not be called for getter/setter methods
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void m9forDaoPackageNoGetterSetter() {
		System.out.println("===>>> MyCloudLogAsyncAspect - m9forDaoPackageNoGetterSetter");
	}
}
