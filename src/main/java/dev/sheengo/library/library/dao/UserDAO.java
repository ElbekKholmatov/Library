package dev.sheengo.library.library.dao;

import dev.sheengo.library.library.domains.Users;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO extends DAO<Users, Integer>{
    private static final String INSERT_USER_QUERY = """
            insert into library1.users (username, email, password) values (?, ?, ?) returning id;
            """;
    private static final String FIND_USER_BY_ID = """
            select id,username,email,role from library1.users where id = ?;
            """;
    private static final String UPDATE_USER_QUERY = """
            update library1.users set username = ?, email = ? where id = ?;
            """;
    private static final String DELETE_USER_QUERY = """
            update library1.users set is_active = false where id = ?
            """;
    private static final String FIND_ALL_USERS_QUERY = """
            select id,username,email,role from library1.users where is_active = true;
            """;
    private static final String CHECK_PASSWORD = """
            select password from library1.users where email = ?;
            """;
    private static final String FIND_USER_BY_EMAIL = """
            select id,username,email,role,password from library1.users where email = ?;
            """;
    private static UserDAO instance;


    @Override
    public Users save(Users users) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(INSERT_USER_QUERY)) {
            pS.setString(1, users.getUsername());
            pS.setString(2, users.getEmail());
            pS.setString(3, users.getPassword());
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                users.setId(rs.getInt("id"));
                return users;
            } else {
                throw new RuntimeException("Exception");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users get(Integer integer) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(FIND_USER_BY_ID)){
            pS.setInt(1, integer);
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                return Users.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .role(rs.getString("role"))
                        .build();
            } else {
                throw new RuntimeException("Exception");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Users users) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(UPDATE_USER_QUERY)) {
            pS.setString(1, users.getUsername());
            pS.setString(2, users.getEmail());
            pS.setInt(3, users.getId());
            return pS.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer integer) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(DELETE_USER_QUERY)) {
            pS.setInt(1, integer);
            return pS.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Users> findAll() {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(FIND_ALL_USERS_QUERY)) {
            ResultSet rs = pS.executeQuery();
            List<Users> users = new ArrayList<>();
            while (rs.next()) {
                users.add(Users.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .role(rs.getString("role"))
                        .build());
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    public Users getUserByEmail(@NonNull String email) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(FIND_USER_BY_EMAIL)) {
            pS.setString(1, email);
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                return Users.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .role(rs.getString("role"))
                        .build();
            } else {
                throw new RuntimeException("Exception");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
