package annotation_custom;

import org.hibernate.annotations.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 11:09
*/
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CustomerCodeValidator.class)
@Documented
public @interface CustomerCode {
    String message() default "Customer code already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
