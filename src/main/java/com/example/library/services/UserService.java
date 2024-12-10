package com.example.library.services;

import com.example.library.models.User;
import com.example.library.models.enums.Role;
import com.example.library.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserByPrincipal(Principal principal) {
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public boolean createUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("User created with email: " + user.getEmail());
        userRepository.save(user);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()) {
                user.setActive(false);
                log.info("Ban user with id = {}; email: {}", user.getId(), user.getEmail());
            } else {
                user.setActive(true);
                log.info("Unban user with id = {}; email: {}", user.getId(), user.getEmail());
            }
        }
        userRepository.save(user);
    }


    public void changeUserRoles(User user, String role) {


        user.getRoles().clear();
        user.getRoles().add(Role.valueOf(role));
        userRepository.save(user);
    }
    public void changePassword(User user,String NewPassword) {
        if(NewPassword.isEmpty()  || user.getPassword().equals(passwordEncoder.encode(NewPassword))) {
            return;
        }
        user.setPassword(passwordEncoder.encode(NewPassword));
        userRepository.save(user);
    }

    public void changeEmail(User user, String newEmail) {
        if(newEmail.isEmpty() || userRepository.findByEmail(newEmail) != null || user.getEmail().equals(newEmail)) {
            return;
        }
        user.setEmail(newEmail);
        userRepository.save(user);
    }

    public  void changeUsername(User user, String newUsername) {
        if(newUsername.isEmpty() || user.getUsername().equals(newUsername)) {
            return;
        }
        user.setName(newUsername);
        userRepository.save(user);
    }
}
