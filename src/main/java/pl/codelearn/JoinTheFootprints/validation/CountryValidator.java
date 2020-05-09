package pl.codelearn.JoinTheFootprints.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.codelearn.JoinTheFootprints.model.Country;

@Component
public class CountryValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Country.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Country country = (Country) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotBlank");
        //sprawdz czy nie trzeba zobaczyć czy country.equals("") przy option value=""
    }
}
