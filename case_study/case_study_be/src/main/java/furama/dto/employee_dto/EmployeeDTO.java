package furama.dto.employee_dto;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 14:26
*/

import furama.dto.PersonDTO;
import furama.model.employee_entity.Division;
import furama.model.employee_entity.EducationDegree;
import furama.model.employee_entity.Position;
import furama.model.user_role_entity.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class EmployeeDTO extends PersonDTO {
    @NotBlank(message = "Salary can not emtpy.")
    @Min(value = 0, message = "Salary must greater than 0.")
    private Double salary;

    @NotBlank(message = "Position can not empty.")
    private Position position;

    @NotBlank(message = "Education degree can not empty.")
    private EducationDegree educationDegree;

    @NotBlank(message = "Division can not empty.")
    private Division division;

    @NotBlank(message = "User can not empty.")
    private User user;

    public EmployeeDTO() {
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
