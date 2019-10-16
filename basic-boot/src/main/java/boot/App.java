package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@SpringBootApplication
@RestController
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

    @GetMapping("/err")
    public String error(HttpServletResponse response) throws IOException {
        response.sendError(404);

        return "error";
    }
}
