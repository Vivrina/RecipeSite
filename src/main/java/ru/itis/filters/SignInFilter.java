package ru.itis.filters;

import ru.itis.models.Auth;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryImpl;
import ru.itis.repositories.UserRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.UserService;
import ru.itis.services.UserServicesImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebFilter(value = {"/profile"})
public class SignInFilter implements Filter{
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbrecipes", "postgres", "home131");


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        User user = checkCookie(request);
        if (user != null) {
            session.setAttribute("isAuth", true);
            session.setAttribute("user", user);
        } else {
            session.setAttribute("isAuth", false);
        }
        chain.doFilter(request, response);
    }


    private User checkCookie(HttpServletRequest request) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("auth")) {
                user = userService.getUserByCookie(cookie);
            }
        }
        return user;
    }

    @Override
    public void destroy() {

    }
}
