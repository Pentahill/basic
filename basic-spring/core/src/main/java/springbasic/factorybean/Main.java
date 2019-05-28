package springbasic.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("factorybean.xml");
        Object o = context.getBean("&test");

        System.out.println(o instanceof Test);
        System.out.println(o instanceof FactoryBeanTest);
    }
}
