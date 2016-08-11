package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mars on 11.08.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String homePage() {
        return "index";
    }
}