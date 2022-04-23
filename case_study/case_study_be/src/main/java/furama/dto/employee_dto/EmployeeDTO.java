package furama.dto.employee_dto;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 14:26
*/

import furama.dto.PersonDTO;
import furama.model.employee_entity.Division;
import furama.model.employee_entity.EducationDegree;
import furama.model.employee_entity.Employee;
import furama.model.employee_entity.Position;
import furama.model.user_role_entity.User;
import furama.service.IEmployeeService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class EmployeeDTO extends PersonDTO implements Validator {
    private Integer employeeId;

    @NotBlank(message = "Mã nhân viên không được để trống")
    @Pattern(regexp = "(^$|NV-\\d{4})", message = "Mã nhân viên phải có định dạng NV-XXXX, trong đó X là số tự nhiên.")
    private String employeeCode;

    @NotNull(message = "Salary can not emtpy.")
    @Min(value = 0, message = "Salary must greater than 0.")
    private Double salary;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    @Valid
    private UserDTO userDTO;

    private String currentPassword;

    private IEmployeeService iEmployeeService;

    public EmployeeDTO() {
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public IEmployeeService getiEmployeeService() {
        return iEmployeeService;
    }

    public void setiEmployeeService(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
        String employeeCurrentCode = employeeDTO.getEmployeeCode();
        Employee employee = this.iEmployeeService.findByCode(employeeDTO.getEmployeeCode());
        if (employee != null) {
            if (employee.getEmployeeCode().equals(employeeCurrentCode)) {
                errors.rejectValue("employeeCode", "", "Mã khách hàng đã tồn tại.");
            }
        }
    }
}
