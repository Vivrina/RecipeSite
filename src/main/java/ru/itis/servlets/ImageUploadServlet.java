package ru.itis.servlets;

import ru.itis.form.CategoryForm;
import ru.itis.form.ImageForm;
import ru.itis.form.RecipeForm;
import ru.itis.repositories.ImageRepository;
import ru.itis.repositories.ImageRepositoryImpl;
import ru.itis.services.ImageService;
import ru.itis.services.ImageServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/upload")
public class ImageUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("isAuth").equals(true)) {
            request.setAttribute("recipe", request.getParameter("recipe"));
            request.getRequestDispatcher("jsp/upload.jsp").forward(request, response);
        }
    }
}
