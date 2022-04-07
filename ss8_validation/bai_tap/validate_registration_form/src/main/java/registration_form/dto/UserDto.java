package registration_form.dto;
/*
    Created by Trinh Khai
    Date: 07/04/2022
    Time: 11:06
*/

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import javax.validation.constraints.Email;

public class UserDto implements Validator {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer age;
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        String phoneNumber = userDto.getPhoneNumber();
        String age = String.valueOf(userDto.getAge());
        String email = userDto.getEmail();

        if (firstName.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty", "First name not empty.");
        } else if (firstName.length() > 45 || firstName.length() < 5) {
            errors.rejectValue("firstName", "firstName.length", "First name length must from 5 to 45.");
        }

        if (lastName.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty", "Last name not empty.");
        } else if (lastName.length() > 45 || lastName.length() < 5) {
            errors.rejectValue("lastName", "lastName.length", "Last name length must from 5 to 45.");
        }

        if (phoneNumber.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty", "phoneNumber not empty.");
        } else if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches", "phoneNumber only include number.");
        } else if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith", "phoneNumber start with 0.");
        } else if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            errors.rejectValue("phoneNumber", "phoneNumber.length", "length form 10 to 11.");
        }

        if (age.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "age", "age.empty", "Age not empty");
        } else if (Integer.parseInt(age) < 18) {
            errors.rejectValue("age", "age.limit", "Age must greater than 18");
        }

        if (email.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "email", "email.empty", "Email not empty");
        } else if (!email.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$")) {
            errors.rejectValue("email", "email.format", "Wrong format of email");
        }
    }
}
