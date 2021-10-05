package my.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyLogAspect {

    @Before("execution(* *.minus(*,*))")
    public void doLog(JoinPoint point) {
        System.out.println("Intercepted! "
                + point.toShortString() + " "
                + point.getTarget().getClass().toString() + " "
                + point.getSignature().getName());
        for(Object a: point.getArgs()) {
            System.out.println("Arg: " + a.toString());
        }
    }

    //Напишите такой аспект, который изменяет аргументы,
    // передаваемые методу plus класса Calc,
    // добавляя к каждому по единице

    @Around("execution(int my.aop.Calc.plus(*,*))")
    public int modifyOperation(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();
        args[0] = (int) args[0] + 1;
        args[1] = (int) args[1] + 1;
        return (int) pjp.proceed(args); //Это поможет изменить результат
        //А если pjp.proceed() не вызывать, метод вообще не будет выполнен.

    }

}
