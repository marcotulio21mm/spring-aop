package com.spring_aop.aspects;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    /**
     * intercepta o código nesse ponto de corte:
     * tudo dentro desse pacote, dentro do diretorio dummy, qualquer classe, qualquer método com qualquer assinatura
     */
    @Before("execution(* com.spring_aop.dummy.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("\nBefore {}", joinPoint.getSignature().getName());
    }

    @Around("execution(* com.spring_aop.dummy.*.*(..))")
    public Object loAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("\nlog before: {}", joinPoint.getSignature().getName());
        var object = joinPoint.proceed();
        log.info("\nlog next: {}", joinPoint.getSignature().getName());
        return object;
    }
}
