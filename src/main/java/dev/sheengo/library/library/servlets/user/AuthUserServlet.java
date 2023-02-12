package dev.sheengo.library.library.servlets.user;

import dev.sheengo.library.library.dao.UserDAO;
import dev.sheengo.library.library.domains.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "AuthUserServlet", value = "/register")
public class AuthUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.getInstance();
        request.setAttribute("users", userDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/sign_up.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmationPassword = request.getParameter("confirmation_password");
        String email = request.getParameter("email");
        if (!password.equals(confirmationPassword)) {
            response.sendRedirect("/register");
            return;
        }

        UserDAO userDAO = UserDAO.getInstance();
        userDAO.save(
                Users.builder().
                        username(username).
                        password(password).
                        email(email).
                        build()
        );
        response.sendRedirect("/main.jsp");
    }
}
