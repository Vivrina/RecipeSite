package ru.itis.servlets;

import ru.itis.form.CategoryForm;
import ru.itis.form.RecipeForm;
import ru.itis.repositories.RecipeRepository;
import ru.itis.repositories.RecipeRepositoryImpl;
import ru.itis.services.RecipeService;
import ru.itis.services.RecipeServiceImpl;

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

@WebServlet("/category")
public class CategoriesServlet extends HttpServlet {
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
        int category_id = Integer.parseInt(request.getParameter("id"));

            List<RecipeForm> recipes = recipeService.findRecipesForCategory(category_id);
            recipes.toString();
            request.setAttribute("recipes", recipes);
            request.getRequestDispatcher("jsp/categories.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
