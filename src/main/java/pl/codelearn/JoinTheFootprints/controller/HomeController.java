package pl.codelearn.JoinTheFootprints.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.codelearn.JoinTheFootprints.controller.generic.SessionUserGeneric;

@Controller
@RequestMapping("/")
public class HomeController extends SessionUserGeneric {

    @GetMapping
    public String displayHomePage() {
        return "home";
    }

}
