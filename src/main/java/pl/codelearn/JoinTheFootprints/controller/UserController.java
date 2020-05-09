package pl.codelearn.JoinTheFootprints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.codelearn.JoinTheFootprints.controller.generic.SessionUserGeneric;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.service.SecurityService;
import pl.codelearn.JoinTheFootprints.impl.UserServiceImpl;
import pl.codelearn.JoinTheFootprints.validation.UserValidator;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/app/user")
public class UserController extends SessionUserGeneric {

    private UserServiceImpl userServiceImpl;
    private HttpSession session;
    private SecurityService securityService;
    private UserValidator userValidator;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, HttpSession session, SecurityService securityService, UserValidator userValidator) {
        this.userServiceImpl = userServiceImpl;
        this.session = session;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }


//    @ModelAttribute("sessionUser")
//    public User getSessionUser() {
//        Long userId = (Long) session.getAttribute("userId");
//        User sessionUser = null;
//
//        try {
//            sessionUser = userService.findById(userId);
//        } catch (NoSuchElementException e) {
//            System.out.println("No such user in session");
//        }
//        return sessionUser;
//    }

    @ModelAttribute("userId")
    public Long getUserSessionId() {
        return getSessionUser().getId();
    }

    @GetMapping("/show")
    public String displayUser(@RequestParam("id") Long userId,
                              Model model) {
        User user = userServiceImpl.findById(userId);
        model.addAttribute("user", user);
        return "app-user-show";
    }


    //------------------------EDIT---------------------------
    @GetMapping("/edit")
    public String editUser(Model model) {
        model.addAttribute("updateUserSession", getSessionUser());
        return "app-user-edit";
    }

    @PostMapping("/edit")
    public String updateUserDetails(@ModelAttribute("updateUserSession") User updatedUser,
                                    BindingResult bindingResult) {
        userValidator.validate(updatedUser, bindingResult);

        if (bindingResult.hasErrors()) {
            return "app-user-edit";
        }
//        if (userForm.getSurname().equals("")) userForm.setSurname(null);
        userServiceImpl.saveUser(updatedUser);

        securityService.autoLogin(updatedUser.getEmail(), updatedUser.getConfirmPassword());

        User user = userServiceImpl.findUserByEmail(updatedUser.getEmail());
        Long id = user.getId();
        session.setAttribute("userId", id);
        session.setMaxInactiveInterval(7200);
        return "app-user-show";
    }

    //------------------------LOGOUT---------------------------
    @RequestMapping("/logout")
    public String logout(){
        session.invalidate();
        return "redirect:login";
    }

}
