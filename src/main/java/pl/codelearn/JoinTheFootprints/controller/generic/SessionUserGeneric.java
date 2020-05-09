package pl.codelearn.JoinTheFootprints.controller.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.impl.UserServiceImpl;

import javax.servlet.http.HttpSession;

public class SessionUserGeneric {

    @Autowired
    private HttpSession session;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @ModelAttribute("sessionUser")
    public User getSessionUser() {
        Long userId = (Long) session.getAttribute("userId");
        return userServiceImpl.findById(userId);
    }

    public String getFirstName() {
        return getSessionUser().getFirstName();
    }
}
