package furama.dto.employee_dto;
/*
    Created by Trinh Khai
    Date: 22/04/2022
    Time: 00:33
*/

import furama.model.user_role_entity.User;
import furama.service.IUserService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class UserDTO implements Validator {

    private Integer userNameId;
    @NotBlank(message = "Tên đăng nhập không được để trống.")
    private String userName;
    @NotBlank(message = "Mật khẩu không được để trống.")
    private String password;
    private IUserService iUserService;

    private String currentPassword;

    public UserDTO() {
    }

    public IUserService getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    public Integer getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(Integer userNameId) {
        this.userNameId = userNameId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        String currentPassword = userDTO.getCurrentPassword();
        User user = this.iUserService.findById(userDTO.getUserNameId()).orElse(null);
        if (user != null) {
            if (!user.getPassword().equals(currentPassword)) {
                errors.rejectValue("currentPassword", "", "Wrong password");
            }
        }
    }
}
