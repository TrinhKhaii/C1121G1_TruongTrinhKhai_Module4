package phone_number.model;
/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 21:57
*/

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneNumber implements Validator {
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        if (number.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "number", "number.empty", "phoneNumber not empty.");
        } else if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches", "phoneNumber only include number.");
        } else if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith", "phoneNumber start with 0.");
        } else if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number", "number.length", "length form 10 to 11.");
        }

    }
}
