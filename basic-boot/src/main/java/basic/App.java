package basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;


@SpringBootApplication
public class App {

    @Autowired
    ContentNegotiatingViewResolver contentNegotiatingViewResolver;

    @Autowired
    BeanNameViewResolver beanNameViewResolver;

    @Autowired
    ResourceHttpRequestHandler resourceHttpRequestHandler;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
