package pl.codelearn.JoinTheFootprints.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.service.UserService;

import javax.servlet.http.HttpSession;

@Component
public class UserValidator implements Validator {

    private UserService userService;
    private HttpSession session;

    @Autowired
    public UserValidator(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank");
//        Long sessionUserId = (Long) session.getAttribute("userId");
//        User sessionUser = userService.findById(sessionUserId);
        if (userService.findUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotBlank");
        if (!user.getFirstName().equals("")) {
            if (user.getFirstName().length() < 2) errors.rejectValue("firstName", "Size.userForm.firstName");
            if (!user.getFirstName().matches("^[\\p{Lu}]([\\p{L}&&[^\\p{javaUpperCase}]]){1,29}$")) errors.rejectValue("firstName", "Pattern.userForm.firstName");
        }
//        "^[A-Z]{1}[a-z]{1,29}$"

        if (!user.getSurname().equals("")) {
            if (user.getSurname().length() < 2) errors.rejectValue("surname", "Size.userForm.surname");
            if (!user.getSurname().matches("^[\\p{Lu}]([\\p{L}&&[^\\p{javaUpperCase}]]){1,29}$")) errors.rejectValue("surname", "Pattern.userForm.surname");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 15) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
        }
    }

}