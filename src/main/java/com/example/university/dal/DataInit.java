package com.example.university.dal;

import com.example.university.dal.models.User;
import com.example.university.dal.models.UserRole;
import com.example.university.dal.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataInit implements InitializingBean {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setName("Elise");
        user.setLogin("Elise");
        user.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.USER);
        user.setRoles(roles);
        user.setEnabled(true);
        userRepository.save(user);

        User user2 = new User();
        user2.setName("Laurent");
        user2.setLogin("Laurent");
        user2.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles2 = new HashSet<>();
        roles2.add(UserRole.USER);
        user2.setRoles(roles2);
        user2.setEnabled(true);
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("Lucas");
        user3.setLogin("Lucas");
        user3.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles3 = new HashSet<>();
        roles3.add(UserRole.ADMIN);
        user3.setRoles(roles3);
        user3.setEnabled(true);
        userRepository.save(user3);
    }
}