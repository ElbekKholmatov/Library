package dev.sheengo.library.library.servlets.book;

import dev.sheengo.library.library.dao.BookDAO;
import dev.sheengo.library.library.dao.CategoryDAO;
import dev.sheengo.library.library.domains.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Path;

@WebServlet(name = "BookListServlet", urlPatterns = "/book")
@MultipartConfig(location = "/home/jason/apps/library/upload")
public class BookListServlet extends HttpServlet {

    private static final Path rootPath = Path.of(System.getProperty("user.home"), "/apps/library/upload");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = BookDAO.getInstance();
        request.setAttribute("books", bookDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/book/books.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/category");
    }
}
