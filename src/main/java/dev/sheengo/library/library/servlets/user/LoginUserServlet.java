package dev.sheengo.library.library.servlets.user;

import dev.sheengo.library.library.dao.UserDAO;
import dev.sheengo.library.library.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "LoginUserServlet", value = "/login")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/sign_up.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("login_email");
        String password = request.getParameter("login_password");
        UserService userService = UserService.getInstance();
        if (userService.checkUser(email,password)){
            response.sendRedirect("/main");
        } else {
            response.sendRedirect("/login");
        }

    }
}
