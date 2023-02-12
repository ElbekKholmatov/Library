package dev.sheengo.library.library.servlets.book;

import dev.sheengo.library.library.dao.BookDAO;
import dev.sheengo.library.library.dao.CategoryDAO;
import dev.sheengo.library.library.dao.DocumentDAO;
import dev.sheengo.library.library.domains.Book;
import dev.sheengo.library.library.domains.Category;
import dev.sheengo.library.library.domains.Document;
import dev.sheengo.library.library.utils.ImageUtils;
import dev.sheengo.library.library.utils.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

@WebServlet(name = "BookUpdateServlet", urlPatterns = "/book/update/*")
@MultipartConfig(location = "/home/jason/apps/library/upload")
public class BookUpdateServlet extends HttpServlet {
    private static final Path rootPath = Path.of(System.getProperty("user.home"), "/apps/library/upload");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        BookDAO bookDAO = BookDAO.getInstance();
        String bookId = request.getPathInfo().substring(1);
        Book book = bookDAO.get(Integer.valueOf(bookId));
        Category currentCategory = categoryDAO.get(book.getCategory());
        request.setAttribute("book", book);
        request.setAttribute("categories", categoryDAO.findAll());
        request.setAttribute("currentCategory", currentCategory);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/book/update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("id");
        String publishedAt1 = request.getParameter("publishedAt");
        LocalDate publishedAt = LocalDate.parse(publishedAt1);
        Part file = request.getPart("file");
        Part image = request.getPart("image");
        String description = request.getParameter("description");
        String publisher = request.getParameter("publisher");
        String categoryId = request.getParameter("category_id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String oldFileId = request.getParameter("old_file_id");
        String oldImageId = request.getParameter("old_image_id");
        BookDAO bookDAO = BookDAO.getInstance();
        Book book = Book.builder()
                .id(Integer.parseInt(bookId))
                .title(title)
                .author(author)
                .description(description)
                .publisher(publisher)
                .publishedAt(publishedAt)
                .coverId((image != null)?Integer.parseInt(oldImageId):saveCover(image).getId())
                .documentId((file != null)?Integer.parseInt(oldFileId):saveFile(file).getId())
                .category(Integer.parseInt(categoryId))
                .pages(300)
                .build();
        bookDAO.update(book);
        response.sendRedirect("/book");
    }

    private Document saveCover(Part part) {
        try {
            DocumentDAO documentDAO = DocumentDAO.getInstance();
            String generateUniqueName = StringUtils.generateUniqueName(part);
            Path coverPath = rootPath.resolve(generateUniqueName);
            String originalName = part.getSubmittedFileName();
            String extension = StringUtils.getFileExtension(originalName);
            String mimeType = part.getContentType();
            Document document = Document.builder()
                    .generatedFileName(generateUniqueName)
                    .originalFileName(originalName)
                    .fileSize(part.getSize())
                    .mimeType(mimeType)
                    .filePath(rootPath.resolve(generateUniqueName).toString())
                    .extension(extension)
                    .build();
            document = documentDAO.save(document);
            ImageUtils.resizeForCover(part.getInputStream(), rootPath.resolve(generateUniqueName));
            return document;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Document saveFile(Part file) {
        try {
            DocumentDAO documentDAO = DocumentDAO.getInstance();
            String originalName = file.getSubmittedFileName();
            String extension = StringUtils.getFileExtension(originalName);
            String generatedName = StringUtils.generateUniqueName(file);
            String mimeType = file.getContentType();
            long size = file.getSize();
            Document document = Document.builder()
                    .generatedFileName(generatedName)
                    .originalFileName(originalName)
                    .fileSize(size)
                    .mimeType(mimeType)
                    .filePath(rootPath.resolve(generatedName).toString())
                    .extension(extension)
                    .build();
            document = documentDAO.save(document);
            file.write(generatedName);
            return document;
        } catch (Exception e) {
            // TODO: 08/02/23 redirect to error page
            throw new RuntimeException(e);
        }
    }


}
