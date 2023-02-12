package dev.sheengo.library.library.servlets.category;

import dev.sheengo.library.library.dao.CategoryDAO;
import dev.sheengo.library.library.domains.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CategoryUpdateServlet", value = "/category/update/*")
public class CategoryUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        String categoryId = request.getPathInfo().substring(1);
        Category category = categoryDAO.get(Integer.parseInt(categoryId));
        request.setAttribute("category", category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/category/update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        Category category = Category.builder()
                .id(Integer.parseInt(id))
                .name(name)
                .build();
        categoryDAO.update(category);
        response.sendRedirect("/category");
    }
}
