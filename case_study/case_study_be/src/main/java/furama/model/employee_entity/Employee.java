package furama.model.employee_entity;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 00:52
*/

import com.fasterxml.jackson.annotation.JsonBackReference;
import furama.model.Person;
import furama.model.contract_entity.Contract;
import furama.model.user_role_entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotNull
    private String employeeCode;

    @NotNull
    private Double salary;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @OneToOne
    @JoinColumn(name = "user_name_id", referencedColumnName = "userNameId")
    private User user;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private Set<Contract> contracts;

    public Employee() {
        setDeleteFlag(false);
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
