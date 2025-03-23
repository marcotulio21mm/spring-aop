package com.spring_aop.aspects.mdc;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MdcClearAspect {

    @Pointcut("@annotation(com.spring_aop.aspects.mdc.MdcClear)")
    public void mdcClearPointcut() {}

    @After("mdcClearPointcut()")
    public void clearMdc() {
        MDC.clear();
    }
}
