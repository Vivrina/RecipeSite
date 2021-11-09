package ru.itis.filters;

import ru.itis.models.Auth;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryImpl;
import ru.itis.repositories.UserRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String s = request.getParameter("cookie_value");

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                System.out.println("fff");
                System.out.println(cookie.getName());
                System.out.println(cookie.getName().equals("auth"));
                System.out.println(cookie.getValue());
                System.out.println(s);
                if (cookie.getValue().equals(s)) {
                    System.out.println("Куки из браузера");
                    System.out.println(cookie.getValue());
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    System.out.println("Пользователь не аутентифицирован!!!");
                    response.sendRedirect("/signIn");
                    return;
                }
            }
        } else {
            System.out.println("Пользователь не аутентифицирован!!!");
            response.sendRedirect("/signIn");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
