package springbasic.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Configuration
public class Used {

    @Bean
    @Order(1)
    public Used first() {
        return new Used();
    }

    @Bean
    @Order(2)
    public Used seconde() {
        return new Used();
    }
}
