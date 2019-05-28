package springbasic.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
//        AopTest aopTest = (AopTest)context.getBean("aopTest");
//        aopTest.hello();
//        aopTest.helloThrowException();

        StudentAdditionalDetails studentAdditionalDetails = (StudentAdditionalDetails) context.getBean("studentAdditionalDetails");
        ((Student) studentAdditionalDetails).showDetails();
        studentAdditionalDetails.showAdditionalDetails();
    }
}
