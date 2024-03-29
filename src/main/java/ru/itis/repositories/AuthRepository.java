package ru.itis.repositories;

import ru.itis.models.Auth;
import ru.itis.models.User;

public interface AuthRepository extends  CrudRepository<Auth>{
    User findByCookieValue(String cookieValue);
}
