package springbasic.aop.program;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HelloAspect {

    @Pointcut("execution(* springbasic.aop.program.Hello.hello(..))")
    public void hello(){}

    @Before("hello()")
    public void beforeHello() {
        System.out.println("before hello");
    }
}
