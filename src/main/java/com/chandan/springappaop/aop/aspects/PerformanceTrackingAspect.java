package com.chandan.springappaop.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Around("com.chandan.springappaop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	
	@Around("com.chandan.springappaop.aop.aspects.CommonPointcutConfig.trackTimeAnnotation()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// Start timer
		long startTimeMillis = System.currentTimeMillis();
		
		
		// Execute the Method
		Object returnValue = proceedingJoinPoint.proceed();		
		
		
		
		// Stop timer
		long stopTimeMillis = System.currentTimeMillis();
		
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		logger.info("Around Aspect - {} Method executed in {} in ms ",proceedingJoinPoint, executionDuration);
		
		return returnValue;
	}

}
