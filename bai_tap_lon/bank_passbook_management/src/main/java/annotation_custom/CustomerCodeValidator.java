package annotation_custom;
/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 11:11
*/

import org.springframework.beans.factory.annotation.Autowired;
import passbook.model.Customer;
import passbook.service.ICustomerService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerCodeValidator implements ConstraintValidator<CustomerCode, String> {
    @Override
    public void initialize(CustomerCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Autowired
    private ICustomerService iCustomerService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Customer customerExist = iCustomerService.findByCode(value);

        return false;
    }
}
