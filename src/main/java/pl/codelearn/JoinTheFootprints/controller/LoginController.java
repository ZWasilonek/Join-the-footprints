package pl.codelearn.JoinTheFootprints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.codelearn.JoinTheFootprints.impl.UserServiceImpl;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.service.SecurityService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserServiceImpl userServiceImpl;
    private final HttpSession session;
    private final SecurityService securityService;

    @Autowired
    public LoginController(UserServiceImpl userServiceImpl, HttpSession session, SecurityService securityService) {
        this.userServiceImpl = userServiceImpl;
        this.session = session;
        this.securityService = securityService;
    }

    @GetMapping
    public String displayLogin(Model model) {
        model.addAttribute("userLogin", new User());
        if (session.getAttribute("user") != null) {
            return "redirect:app";
        } else return "login";
    }

    @PostMapping
    public String postLogin(@Valid @ModelAttribute("userLogin") User userLogin, Model model){

        if (!userLogin.getEmail().matches("^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")) {
            model.addAttribute("error", "Your email is incorrect.");
            return "login";
        }

        try {
            securityService.autoLogin(userLogin.getEmail(), userLogin.getPassword());
        } catch (UsernameNotFoundException e) {
            model.addAttribute("error", "Your email or password is invalid.");
            return "login";
        }

        User user = userServiceImpl.findUserByEmail(userLogin.getEmail());
        Long id = user.getId();

        session.setAttribute("userId", id);
        session.setMaxInactiveInterval(7200);

        return "redirect:/app";
    }
}
