package boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TemplateController {

    @GetMapping("/test")
    public String test(Map<String, Object> model) {
        model.put("name", "Chris");
        model.put("value", 1000);
        model.put("taxed_value", 10000 - (10000 * 0.4));
        model.put("in_ca", true);

        return "mustache";
    }

}
