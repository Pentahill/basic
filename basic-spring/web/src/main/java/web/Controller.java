package web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @PostMapping(consumes = "application/json")
    @ResponseBody
    public String hello(@RequestBody Hello hello) {
        System.out.println(hello);
        return hello.toString();
    }

}
