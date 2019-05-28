package springbasic.aop.annotation;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {

    @Pointcut(value = "execution(* springbasic.aop.annotation.AnnotationAopTest.hello(..)) && args(aa)")
    public void hello(String aa){}

    @AfterThrowing(value = "springbasic.aop.annotation.NotVeryUsefulAspect.hello(aa)",
                    throwing = "ex")
    public void h(String aa, Exception ex) {
        System.out.println(aa);
        System.out.println("before hello");
    }

}
