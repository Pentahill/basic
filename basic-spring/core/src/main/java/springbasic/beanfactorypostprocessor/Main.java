package springbasic.beanfactorypostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanfactorypostprocessor.xml");
        ProcessorTest pt = (ProcessorTest)context.getBean("processorTest");
        System.out.println(pt.getName());
    }
}
