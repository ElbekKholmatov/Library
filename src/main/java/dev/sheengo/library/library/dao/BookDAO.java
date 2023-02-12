package dev.sheengo.library.library.dao;

import dev.sheengo.library.library.domains.Book;
import dev.sheengo.library.library.dto.BookDetailsDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDAO extends DAO<Book, Integer> {
    private static final String SELECT_ALL = """
            select b.id, b.title, b.author,b.description, b.views,b.likes, b.dislikes, b.downloads,b.pages,b.publisher,
             d.originalFileName as coverOriginalFileName ,d.generatedFileName as coverGeneratedFileName,d.fileSize as coverFileSize, 
             d2.originalFileName as documentOriginalFileName ,d2.generatedFileName as documentGeneratedFileName,d2.fileSize as documentFileSize,
              c.id as category_id 
              from book b 
             inner join document d on b.coverid = d.id 
             inner join document d2 on b.document_id = d2.id 
             inner join category c on b.category_id = c.id;
                        """;
    public static final String INSERT_QUERY = """
            insert into library1.book (
                        title,
                        author,
                        category_id,
                        pages,
                        publisher,
                        publishedat,
                        coverid,
                        document_id,
                        description
            ) values (?, ?, ?, ?, ?, ?, ?, ?,?) returning id;""";
    private static final String FIND_BOOK_BY_ID = """
            select b.id, b.title, b.author,b.description, b.views,b.likes, b.dislikes, b.downloads,b.pages,b.publisher,b.publishedat,b.category_id,
            b.coverid,b.document_id,
             d.originalFileName as coverOriginalFileName ,d.generatedFileName as coverGeneratedFileName,d.fileSize as coverFileSize, 
             d2.originalFileName as documentOriginalFileName ,d2.generatedFileName as documentGeneratedFileName,d2.fileSize as documentFileSize,
              c.id as category_id 
              from book b 
             inner join document d on b.coverid = d.id 
             inner join document d2 on b.document_id = d2.id 
             inner join category c on b.category_id = c.id where b.id = ?;
                        """;
    private static final String UPDATE_BOOK = """
            update library1.book set title = ?, author = ?, category_id = ?, pages = ?, publisher = ?, publishedat = ?, coverid = ?, document_id = ?, description = ? where id = ?;
                        """;
    private static final String DELETE_BOOK = """
            delete from library1.book where id = ?;
                        """;
    private static BookDAO instance;


    @Override
    public Book save(Book book) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(INSERT_QUERY)) {
            pr.setString(1, book.getTitle());
            pr.setString(2, book.getAuthor());
            pr.setInt(3, book.getCategory());
            pr.setInt(4, book.getPages());
            pr.setString(5, book.getPublisher());
            pr.setDate(6, Date.valueOf(book.getPublishedAt()));
            pr.setInt(7, book.getCoverId());
            pr.setInt(8, book.getDocumentId());
            pr.setString(9, book.getDescription());
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                book.setId(rs.getInt("id"));
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book get(Integer bookId) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(FIND_BOOK_BY_ID)){
            pr.setInt(1, bookId);
            ResultSet resultSet = pr.executeQuery();
            Book build = null;
            if (resultSet.next()) {
                build = Book.builder()
                        .id(resultSet.getInt("id"))
                        .title(resultSet.getString("title"))
                        .author(resultSet.getString("author"))
                        .description(resultSet.getString("description"))
                        .pages(resultSet.getInt("pages"))
                        .likes(resultSet.getInt("likes"))
                        .dislikes(resultSet.getInt("dislikes"))
                        .views(resultSet.getInt("views"))
                        .category(Integer.valueOf(resultSet.getString("category_id")))
                        .publisher(resultSet.getString("publisher"))
                        .publishedAt(resultSet.getDate("publishedat").toLocalDate())
                        .coverId(resultSet.getInt("coverid"))
                        .documentId(resultSet.getInt("document_id"))
                        .build();
            }
            return build;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Book book) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(UPDATE_BOOK)) {
            pr.setString(1, book.getTitle());
            pr.setString(2, book.getAuthor());
            pr.setInt(3, book.getCategory());
            pr.setInt(4, book.getPages());
            pr.setString(5, book.getPublisher());
            pr.setDate(6, Date.valueOf(book.getPublishedAt()));
            pr.setInt(7, book.getCoverId());
            pr.setInt(8, book.getDocumentId());
            pr.setString(9, book.getDescription());
            pr.setInt(10, book.getId());
            return pr.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer integer) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(DELETE_BOOK)) {
            pr.setInt(1, integer);
            return pr.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<BookDetailsDTO> findAll() {
        Connection connection = getConnection();
        List<BookDetailsDTO> books = new ArrayList<>();
        try (var pr = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                books.add(BookDetailsDTO.builder()
                        .id(resultSet.getInt("id"))
                        .title(resultSet.getString("title"))
                        .author(resultSet.getString("author"))
                        .description(resultSet.getString("description"))
                        .pages(resultSet.getInt("pages"))
                        .likes(resultSet.getInt("likes"))
                        .dislikes(resultSet.getInt("dislikes"))
                        .views(resultSet.getInt("views"))
                        .category(resultSet.getString("category_id"))
                        .publisher(resultSet.getString("publisher"))
                        .coverOriginalFileName(resultSet.getString("coverOriginalFileName"))
                        .coverGeneratedFileName(resultSet.getString("coverGeneratedFileName"))
                        .coverFileSize((resultSet.getLong("coverFileSize") / 2 << 20) + "MB")
                        .documentOriginalFileName(resultSet.getString("documentOriginalFileName"))
                        .documentGeneratedFileName(resultSet.getString("documentGeneratedFileName"))
                        .documentFileSize((resultSet.getLong("documentFileSize") / 2 << 20) + "MB")
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static BookDAO getInstance() {
        if (instance == null) {
            synchronized (BookDAO.class) {
                if (instance == null) {
                    instance = new BookDAO();
                }
            }
        }
        return instance;
    }
}
