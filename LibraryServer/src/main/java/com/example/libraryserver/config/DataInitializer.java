package com.example.libraryserver.config;

import com.example.libraryserver.model.Role;
import com.example.libraryserver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (roleRepository.findByRoleName("USER") == null) {
            Role userRole = new Role();
            userRole.setRoleName("USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByRoleName("ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setRoleName("ADMIN");
            roleRepository.save(adminRole);
        }
    }
}
