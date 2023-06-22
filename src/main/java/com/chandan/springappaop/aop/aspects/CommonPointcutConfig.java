package com.chandan.springappaop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	
	@Pointcut("execution(* com.chandan.springappaop.aop.*.*.*(..))")
	public void businessAndDataPackageConfig() {
		
	}
	
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBean() {
		
	}
	
	@Pointcut("@annotation(com.chandan.springappaop.aop.annotations.TrackTime)")
	public void trackTimeAnnotation() {}


}
