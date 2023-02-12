package dev.sheengo.library.library.servlets.category;

import dev.sheengo.library.library.dao.CategoryDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CategoryDeleteServlet", value = "/category/delete/*")
public class CategoryDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        String pathInfo = request.getPathInfo();
        int categoryID = Integer.parseInt(pathInfo.substring(1));
        request.setAttribute("category", categoryDAO.get(categoryID));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/category/delete.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        categoryDAO.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/category");
    }
}
