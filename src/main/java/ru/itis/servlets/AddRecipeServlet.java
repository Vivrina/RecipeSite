package ru.itis.servlets;

import ru.itis.form.CategoryForm;
import ru.itis.form.RecipeForm;
import ru.itis.repositories.*;
import ru.itis.services.RecipeService;
import ru.itis.services.RecipeServiceImpl;
import ru.itis.services.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/addRecipe")
public class AddRecipeServlet extends HttpServlet {
    private RecipeService recipeService;

    @Override
    public void init() throws ServletException {
        try {
            //This will load the driver, and while loading, the driver will automatically register itself with JDBC
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbrecipes", "postgres", "home131");

            RecipeRepository recipeRepository = new RecipeRepositoryImpl(connection);
            recipeService = new RecipeServiceImpl(recipeRepository);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("isAuth").equals(true)) {
            List<CategoryForm> categories = recipeService.findCategories();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("jsp/addRecipe.jsp").forward(request, response);
        } else {
            response.sendRedirect("signIn");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("isAuth").equals(true)) {
            RecipeForm rf = new RecipeForm();
            rf.setTitle(request.getParameter("title"));
            rf.setDescription(request.getParameter("description"));
            rf.setCategory(Integer.parseInt(request.getParameter("category_id")));
            rf.setUser(Integer.parseInt(request.getParameter("user")));
            rf = recipeService.addRecipe(rf);
            response.sendRedirect("/upload?recipe="+rf.getId());
        } else {
            response.sendRedirect("/signIn");
        }
    }
}
