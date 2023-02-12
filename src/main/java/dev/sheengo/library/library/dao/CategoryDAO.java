package dev.sheengo.library.library.dao;

import dev.sheengo.library.library.domains.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDAO extends DAO<Category, Integer> {

    private static final String DELETE_CATEGORY_QUERY = """
            delete from library1.category where id = ?
            """;


    public static final String FIND_ALL_QUERY = "select * from library1.category";
    public static final String UPDATE_CATEGORY_QUERY = """
            update library1.category set name = ? where id = ?;
""";
    public static final String TOTAL_COUNT = "select count(0) from library1.category;";
    public static final String INSERT_CATEGORY_QUERY = """
            insert into library1.category (name) values (?) returning id;""";
    private static final String FIND_BY_ID = """
            select id,name from library1.category where id = ?;
            """;
    private static CategoryDAO instance;

    public static CategoryDAO getInstance() {
        if (instance == null) {
            synchronized (CategoryDAO.class) {
                if (instance == null) {
                    instance = new CategoryDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public Category save(Category category) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(INSERT_CATEGORY_QUERY)) {
            pS.setString(1, category.getName());
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                category.setId(rs.getInt("id"));
                return category;
            } else {
                throw new RuntimeException("Exception");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Category get(Integer integer) {
        Connection connection = getConnection();
        try (PreparedStatement pS = connection.prepareStatement(FIND_BY_ID)){
            pS.setInt(1, integer);
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                return Category.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
            } else {
                throw new RuntimeException("Exception");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean update(@NonNull Category category) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(UPDATE_CATEGORY_QUERY)) {
            pr.setString(1, category.getName());
            pr.setInt(2, category.getId());
            return pr.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer categoryId) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(DELETE_CATEGORY_QUERY)) {
            pr.setInt(1, categoryId);
            return pr.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Category> findAll() {
        List<Category> students = new ArrayList<>();
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(FIND_ALL_QUERY)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                students.add(Category.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public long totalCount() {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(TOTAL_COUNT)) {
            ResultSet rs = pr.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
