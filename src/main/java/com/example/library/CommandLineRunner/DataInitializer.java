package com.example.library.CommandLineRunner;

import com.example.library.models.User;
import com.example.library.models.enums.Role;
import com.example.library.repositories.UserRepository;
import com.example.library.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private  final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            User admin = new User();
            admin.setName("admin");
            admin.setPassword("admin");
            admin.setEmail("admin@admin.com");
            admin.setActive(true);
            admin.getRoles().add(Role.ROLE_ADMIN);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            userRepository.save(admin);

        }
    }
}
