package ru.itis.services;

import ru.itis.form.UserForm;
import ru.itis.models.User;

public interface UserService {
    User register(UserForm userForm);

}
