package ru.itis.servlets;

import ru.itis.form.UserForm;
import ru.itis.repositories.UserRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.UserService;
import ru.itis.services.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/signUp")
public class RegistrationServlet extends HttpServlet {

    //private Connection connection;
    private UserService userService;


    @Override
    public void init() throws ServletException {
        try {
            //This will load the driver, and while loading, the driver will automatically register itself with JDBC
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbrecipes", "postgres", "home131");

            UserRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
            userService = new UserServicesImpl(usersRepository);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserForm userForm = new UserForm();
        userForm.setName(req.getParameter("name"));
        userForm.setPassword(req.getParameter("password"));
        userForm.setEmail(req.getParameter("email"));
        userForm.setAchievement(0);

        userService.register(userForm);
        resp.sendRedirect("/signIn");

        //req.getRequestDispatcher("jsp/registration.jsp").forward(req, resp);
    }


}
