package pl.codelearn.JoinTheFootprints.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.codelearn.JoinTheFootprints.dto.ExcursionDTO;

@Component
public class ExcursionDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ExcursionDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ExcursionDTO excursionDTO = (ExcursionDTO) o;

        String minExpense = String.valueOf(excursionDTO.getMinExpense());
        if (!minExpense.matches("\\d+[\\.,]\\d+")) {
            errors.rejectValue("minExpense", "Pattern.excursionDTO.minExpense");
        }

        String maxExpense = String.valueOf(excursionDTO.getMaxExpense());
        if (!maxExpense.matches("\\d+[\\.,]\\d+")) {
            errors.rejectValue("maxExpense", "Pattern.excursionDTO.maxExpense");
        }
    }
}
