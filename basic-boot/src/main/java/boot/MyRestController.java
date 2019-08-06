package boot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class MyRestController {

    @RequestMapping(value="/{user}", method= RequestMethod.GET)
    public String getUser(@PathVariable Long user) {
        return null;
    }

    @RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
    List<String> getUserCustomers(@PathVariable Long user) {
        return null;
    }

    @RequestMapping(value="/{user}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long user) {
        return null;
    }

}
