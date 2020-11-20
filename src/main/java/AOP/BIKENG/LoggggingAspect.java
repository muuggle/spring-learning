package AOP.BIKENG;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggggingAspect {
    @Before("execution(public * AOP.BIKENG.UsserService.*(..))")
    public void doAccessCheck() {
        System.out.println("[Before] do access check...");
    }
}
