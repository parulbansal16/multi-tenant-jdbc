package com.sense.writeback.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TenantInjectorAspect {

    /**
     * All public methods that are annotated with InjectTenant.
     */
    @Pointcut("execution(@com.sense.writeback.interceptor.InjectTenant * *(..))")
    public void injectTenantAnnotatedMethod() {
    }

    /**
     * All public methods of a class annotated with InjectTenant.
     */
    @Pointcut("execution(* (@com.sense.writeback.interceptor.InjectTenant *).*(..))")
    public void injectTenantAnnotatedClassMethod() {
    }

    /**
     * Pointcut expression that joins the first two with OR
     */
    @Pointcut("injectTenantAnnotatedMethod() || injectTenantAnnotatedClassMethod()")
    public void injectTenant() {
    }


    @Before("injectTenant()")
    public void beforeInjectTenant(final JoinPoint jp) {
//        TenantContext.setCurrentTenant("");
        System.out.println("****TenantInjectorAspect.beforeAdviceForAllMethods() " + jp.getSignature().getName());
    }
}

