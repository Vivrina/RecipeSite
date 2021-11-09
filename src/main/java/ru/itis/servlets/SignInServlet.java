package ru.itis.servlets;

import ru.itis.form.LoginForm;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryImpl;
import ru.itis.repositories.UserRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.UserService;
import ru.itis.services.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbrecipes", "postgres", "home131");

            UserRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
            AuthRepository authRepository = new AuthRepositoryImpl(connection);
            userService = new UserServicesImpl(usersRepository, authRepository);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email);
        System.out.println(password);

        LoginForm loginForm = new LoginForm(email, password);
        Cookie cookie = userService.signIn(loginForm);

        System.out.println("Сигн ин сервлет куки значение" + cookie.getValue());
        System.out.println(cookie);
        if (cookie != null) {
            resp.addCookie(cookie);
            resp.sendRedirect("/profile");
        } else {
            req.setAttribute("signInStatus", "Неправильный логин или пароль");
            req.getRequestDispatcher("jsp/signIn.jsp").forward(req, resp);
        }

    }
}
