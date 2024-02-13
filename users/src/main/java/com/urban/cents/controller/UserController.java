package com.urban.cents.controller;

import com.urban.cents.entity.User;
import com.urban.cents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * UserController
 * Showcase a simple RESTful API for User entity.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getUser(id));
    }

    /**
     * Use the @Valid annotation to validate the request body (given the restrictions in the entity class).
     * @param User the User to be created
     * @return the created User
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User User) {
        return ResponseEntity.ok(this.userService.createUser(User));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User User) {
        return ResponseEntity.ok(this.userService.updateUser(User));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }

    @GetMapping("/")
    public Iterable<User> findAll() {
        return this.userService.getUsers();
    }

}
