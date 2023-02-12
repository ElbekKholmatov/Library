package dev.sheengo.library.library.servlets.category;

import dev.sheengo.library.library.dao.CategoryDAO;
import dev.sheengo.library.library.domains.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Path;

@WebServlet(name = "CategoryListServlet", urlPatterns = "/category")
@MultipartConfig(location = "/home/jason/apps/library/upload")
public class CategoryListServlet extends HttpServlet {
    private static final Path rootPath = Path.of(System.getProperty("user.home"), "/apps/library/upload");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        request.setAttribute("categories", categoryDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/category/categories.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Category category = Category.builder()
                .name(name)
                .build();
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        categoryDAO.save(category);
        response.sendRedirect("/category");
    }
}
