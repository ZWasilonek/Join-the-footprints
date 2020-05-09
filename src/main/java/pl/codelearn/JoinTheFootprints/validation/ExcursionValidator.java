package pl.codelearn.JoinTheFootprints.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.codelearn.JoinTheFootprints.model.Excursion;

import java.time.LocalDate;

@Component
public class ExcursionValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Excursion.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Excursion excursion = (Excursion) o;

        LocalDate departureDate = excursion.getDateOfDeparture();
        if (departureDate == null) {
            errors.rejectValue("dateOfDeparture", "Date.excursionForm.dateOfDeparture");
        }

        LocalDate arrivalDate = excursion.getDateOfArrival();
        if (arrivalDate == null) {
            errors.rejectValue("dateOfArrival", "Date.excursionForm.dateOfArrival");
        } else if (arrivalDate.isBefore(departureDate)) {
            errors.rejectValue("dateOfArrival", "WrongDate.excursionForm.dateOfArrival");
        }

        //EXPENSE
        if (excursion.getExpense() != null) {
            if (excursion.getExpense() > 100000.0 || excursion.getExpense() < 1.0) {
                errors.rejectValue("expense", "Size.excursionForm.expense");
            }
        } else errors.rejectValue("expense", "NotBlank");


        //MAX MEMBERS
        Integer maxMembers = excursion.getMaxMembers();
        if (maxMembers == null || maxMembers < 1 || maxMembers > 100) {
            errors.rejectValue("maxMembers", "Size.excursionForm.maxMembers");
        }

        String phoneNumber = excursion.getPhoneNumber();
        if (!phoneNumber.equals("")) {
            if (!phoneNumber.matches("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")) {
                errors.rejectValue("phoneNumber", "Pattern.excursionForm.phoneNumber");
            }
        }
    }
}
