package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 22/04/2022
    Time: 09:29
*/

import furama.model.user_role_entity.User;
import furama.repository.user_repository.IUserRepository;
import furama.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        iUserRepository.deleteById(id);
    }
}
