package my.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyLogAspect {

    @Before("execution(* *(..))")
    public void doLog(JoinPoint point) {
        System.out.println("Intercepted!");
    }

}
