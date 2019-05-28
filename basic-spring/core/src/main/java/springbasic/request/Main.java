package springbasic.request;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Main {
    public static void main(String[] args) {
        WebApplicationContext context = new XmlWebApplicationContext();
        context.getEnvironment();
        context.getBean("aa");
    }
}
