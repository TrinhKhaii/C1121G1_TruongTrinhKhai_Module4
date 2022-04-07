package registration_form.service.impl;
/*
    Created by Trinh Khai
    Date: 07/04/2022
    Time: 11:17
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registration_form.model.User;
import registration_form.repository.IUserRepository;
import registration_form.service.IUserService;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
