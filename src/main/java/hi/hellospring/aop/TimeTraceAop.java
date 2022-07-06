package hi.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect // Aspect이라고 써야 AOP를 쓸 수 있다
public class TimeTraceAop {

    @Around("execution(* hi.hellospring..*(..)) && !target(hi.hellospring.SpringConfig)")
    public Object execute(ProceedingJoinPoint jointPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + jointPoint.toString());
        try {
            return jointPoint.proceed();
        } finally {
            {
                long finish = System.currentTimeMillis();
                long timeMs = finish - start;
                System.out.println("END: " + jointPoint.toString() + " " + timeMs + "ms");

            }

        }
    }
}
