package backup;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

//    @Before("execution(* backup.HpPrinter.*(..))")
//    public void before() {
//        System.out.println("I am before!!!");
//    }
//
//    @After("execution(* backup.HpPrinter.*(..))")
//    public void after() {
//        System.out.println("I am after!!!");
//    }

//    @Around("execution(* backup.HpPrinter.*(..))")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("I am around before...");
//
//        Object obj = pjp.proceed();
//
//        System.out.println("I am around after...");
//
//        return obj;
//    }

    @Around("execution(* backup.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();

        Object obj = pjp.proceed();

        Date end = new Date();

        long time = end.getTime() - start.getTime();

        System.out.println("Execution Time: " + time + "ms");

        return obj;
    }
}
