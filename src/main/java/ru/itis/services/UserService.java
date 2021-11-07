package ru.itis.services;

import ru.itis.form.LoginForm;
import ru.itis.form.UserForm;
import ru.itis.models.User;

import javax.servlet.http.Cookie;

public interface UserService {
    User register(UserForm userForm);
    Cookie signIn(LoginForm loginForm);
}
