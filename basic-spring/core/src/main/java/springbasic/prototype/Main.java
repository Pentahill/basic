package springbasic.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("prototype.xml");
        AbstractCommandManager cm = (AbstractCommandManager)context.getBean("commandManager");
        cm.process();
        cm.process();
    }
}
