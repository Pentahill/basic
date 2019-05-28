package springbasic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Component
public class Using {

//    @Autowired
    private Used used;

    public Using(Used used) {
        this.used = used;
    }

//    @Required
//    public void init(Used used) {
//        this.used = used;
//    }
}
