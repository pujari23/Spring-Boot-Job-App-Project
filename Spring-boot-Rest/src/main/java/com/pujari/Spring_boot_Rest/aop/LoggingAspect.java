package com.pujari.Spring_boot_Rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //execution(modifier returnType fullyQualifiedClassName.methodName(arguments))
    //execution(public String com.pujari.Spring_boot_Rest.aop.LoggingAspect.logmethodCall(..))

    @Before("execution(* com.pujari.Spring_boot_Rest.service.JobService.getJobPost(..)) || execution(* com.pujari.Spring_boot_Rest.service.JobService.updateJob(..)) ")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Method call " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.pujari.Spring_boot_Rest.service.JobService.getJobPost(..)) || execution(* com.pujari.Spring_boot_Rest.service.JobService.updateJob(..)) ")
    public void logMethodExecuted(JoinPoint joinPoint) {
        LOGGER.info("Method Executed " + joinPoint.getSignature().getName());
    }//After acts as final block

    @AfterThrowing("execution(* com.pujari.Spring_boot_Rest.service.JobService.getJobPost(..)) || execution(* com.pujari.Spring_boot_Rest.service.JobService.updateJob(..)) ")
    public void logMethodCrash(JoinPoint joinPoint) {  //only if there is an error
        LOGGER.info("Method has issues " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.pujari.Spring_boot_Rest.service.JobService.getJobPost(..)) || execution(* com.pujari.Spring_boot_Rest.service.JobService.updateJob(..)) ")
    public void logMethodExecutedSuccess(JoinPoint joinPoint){
        LOGGER.info("Method call Executed Successfully " + joinPoint.getSignature().getName());
}}
