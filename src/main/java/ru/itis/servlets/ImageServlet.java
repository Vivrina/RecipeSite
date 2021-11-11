package ru.itis.servlets;

import ru.itis.form.ImageForm;
import ru.itis.models.User;
import ru.itis.repositories.ImageRepository;
import ru.itis.repositories.ImageRepositoryImpl;
import ru.itis.repositories.RecipeRepository;
import ru.itis.repositories.RecipeRepositoryImpl;
import ru.itis.services.ImageService;
import ru.itis.services.ImageServiceImpl;
import ru.itis.services.RecipeServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/image")
@MultipartConfig
public class ImageServlet extends HttpServlet {
    private ImageService imagesService;
    private static final String storage = "D:\\site\\";

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            //This will load the driver, and while loading, the driver will automatically register itself with JDBC
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbrecipes", "postgres", "home131");

            ImageRepository imageRepository = new ImageRepositoryImpl(connection);
            imagesService = new ImageServiceImpl(imageRepository);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = storage + request.getParameter("name");

        ServletOutputStream out;
        out = response.getOutputStream();
        FileInputStream fis = new FileInputStream(name);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch =0; ;
        while((ch=bis.read())!=-1)
        {
            bout.write(ch);
        }

        bis.close();
        fis.close();
        bout.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("isAuth").equals(true)) {
            Part image = request.getPart("image");
            ImageForm imageForm = new ImageForm();
            imageForm.setName(image.getSubmittedFileName());
            imageForm.setRecipe_id(Integer.parseInt(request.getParameter("id_recipe")));
            imageForm.setSize(image.getSize());
            imagesService.upload(imageForm, image.getInputStream());
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/signIn");
        }
    }
}
