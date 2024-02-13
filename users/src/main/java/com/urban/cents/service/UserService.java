package com.urban.cents.service;

import com.urban.cents.entity.User;
import com.urban.cents.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User User) {
        log.info("User creation " + User.toString());
        return this.userRepository.save(User);
    }

    public User updateUser(User User) {
        log.info("User update request " + User.toString());
        return this.userRepository.save(User);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
        log.info("User deleted");
    }

    public User getUser(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

}
