package dev.sheengo.library.library.servlets.category;

import dev.sheengo.library.library.dao.CategoryDAO;
import dev.sheengo.library.library.domains.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Path;

@WebServlet(name = "CategoryAddServlet", urlPatterns = "/category/add")
public class CategoryAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        request.setAttribute("categories", categoryDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/category/create.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        Category category = Category.builder()
                .name(name)
                .build();
        categoryDAO.save(category);
        response.sendRedirect("/category");
    }
}
