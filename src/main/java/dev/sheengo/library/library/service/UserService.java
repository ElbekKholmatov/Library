package dev.sheengo.library.library.service;

import dev.sheengo.library.library.dao.UserDAO;

import java.util.Optional;

public class UserService {
    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public boolean checkUser(String email, String password) {
        UserDAO userDAO = UserDAO.getInstance();
        return userDAO.getUserByEmail(email).getPassword().equals(password);
    }
}
