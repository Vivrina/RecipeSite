package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.form.LoginForm;
import ru.itis.form.UserForm;
import ru.itis.models.Auth;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UserRepository;

import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.util.UUID;

public class UserServicesImpl implements UserService{

    private UserRepository userRepository;
    private AuthRepository authRepository;
    private PasswordEncoder passwordEncoder;

//    public UserServicesImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }

    public UserServicesImpl(UserRepository usersRepository, AuthRepository authRepository) {
        this.userRepository = usersRepository;
        this.authRepository = authRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
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

    @Override
    public Cookie signIn(LoginForm loginForm) {
        User user = userRepository.findByLogin(loginForm.getEmail());
        System.out.println(user);
        if (user != null){
            if (passwordEncoder.matches(loginForm.getPassword(), user.getPasswordHash())){
                System.out.println("Вход выполнен");
                String cookieValue = UUID.randomUUID().toString();
                Cookie cookie = new Cookie("auth", cookieValue);
                cookie.setMaxAge(10*60*60);
                Auth auth = new Auth();
                auth.setUser(user);
                auth.setCookieValue(cookieValue);
                System.out.println("Юзер сервис кукиВ"+ cookie.getValue());
                System.out.println("Юзер сервис ауфКукиВ" + auth.getCookieValue());
                authRepository.save(auth);
                return cookie;
            } else {
                System.out.println("Вход не выполнен");
            }
        }

        return null;
    }


    @Override
    public User getUserByCookie(Cookie cookie) {
        return authRepository.findByCookieValue(cookie.getValue());
    }
}
