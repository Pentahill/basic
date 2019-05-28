package springbasic.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("springbasic.aop.annotation")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ((AnnotationAopTest)context.getBean("annotationAopTest")).hello("haha");
    }

    @Bean
    public AnnotationAopTest annotationAopTest() {
        return new AnnotationAopTest();
    }
}
