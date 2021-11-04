package com.example.warehouseapp.component;

import com.example.warehouseapp.entity.enums.Permission;
import com.example.warehouseapp.entity.Role;
import com.example.warehouseapp.entity.User;
import com.example.warehouseapp.repository.RoleRepository;
import com.example.warehouseapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {

            Permission[] values = Permission.values();
            Set<Permission> permissionSet = new HashSet<Permission>(Arrays.asList(values));

            Role admin = roleRepository.save(new Role(1, "ADMIN", true,permissionSet));

            userRepository.save(new User("Superadmin",
                    "super",
                    "912455897",
                    passwordEncoder.encode("123"),
                    admin,
                    true));


        }
    }

}
