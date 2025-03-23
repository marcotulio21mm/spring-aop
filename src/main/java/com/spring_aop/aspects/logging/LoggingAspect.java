package com.spring_aop.aspects.logging;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("@annotation(com.spring_aop.aspects.logging.Logging)")
    public void loggingPointcut() {}

    @Around("loggingPointcut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        var object = joinPoint.proceed();
        log.info("\nresponse: {}", object.toString());
        return object;
    }
}
