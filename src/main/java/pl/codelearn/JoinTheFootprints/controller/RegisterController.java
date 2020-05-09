package pl.codelearn.JoinTheFootprints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.codelearn.JoinTheFootprints.impl.UserServiceImpl;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.service.SecurityService;
import pl.codelearn.JoinTheFootprints.service.UserService;
import pl.codelearn.JoinTheFootprints.validation.UserValidator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final HttpSession session;
    private final UserServiceImpl userServiceImpl;
    private final SecurityService securityService;
    private final UserValidator userValidator;

    @Autowired
    public RegisterController(HttpSession session, UserServiceImpl userServiceImpl, SecurityService securityService, UserValidator userValidator) {
        this.session = session;
        this.userServiceImpl = userServiceImpl;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping
    public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

//        if (userForm.getSurname().equals("")) userForm.setSurname(null);
        userServiceImpl.saveUser(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());

        User user = userServiceImpl.findUserByEmail(userForm.getEmail());
        Long id = user.getId();
        session.setAttribute("userId", id);
        session.setMaxInactiveInterval(7200);

        return "redirect:/app";
    }
}
