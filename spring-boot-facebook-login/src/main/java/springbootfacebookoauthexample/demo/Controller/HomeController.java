package springbootfacebookoauthexample.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping(value = { "/","/home"})
    private String home(){
        return "home";
    }

    @RequestMapping("/user")
    @ResponseBody
    private Principal getUser(Principal principal){
        return principal;
    }
}
