package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mars on 11.08.2016.
 */
@Controller
public class Login {
    @RequestMapping(value = "/login")
    public String homePage() {
        return "login";
    }
}
