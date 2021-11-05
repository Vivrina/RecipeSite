package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.form.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;

import java.sql.Connection;

public class UserServicesImpl implements UserService{
    private Connection connection;
    public UserServicesImpl(Connection connection){
        this.connection = connection;
    }



    private UserRepository userRepository;

    public UserServicesImpl(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    @Override
    public User register(UserForm userForm) {

        User user = new User();
        user.setName(userForm.getName());
        String passwordHash = new BCryptPasswordEncoder().encode(userForm.getPassword());

        user.setPasswordHash(passwordHash);
        user.setEmail(userForm.getEmail());
        user.setAchievement(userForm.getAchievement());


        return userRepository.save(user);
    }
}
