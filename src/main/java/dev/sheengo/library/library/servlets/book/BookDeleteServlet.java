package dev.sheengo.library.library.servlets.book;

import dev.sheengo.library.library.dao.BookDAO;
import dev.sheengo.library.library.dao.CategoryDAO;
import dev.sheengo.library.library.domains.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookDeleteServlet", urlPatterns = "/book/delete/*")
public class BookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = BookDAO.getInstance();
        String pathInfo = request.getPathInfo();
        int bookID = Integer.parseInt(pathInfo.substring(1));
        request.setAttribute("book", bookDAO.get(bookID));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/book/delete.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = BookDAO.getInstance();
        bookDAO.delete(Integer.getInteger(request.getParameter("id")));
        response.sendRedirect("/book");
    }
}
