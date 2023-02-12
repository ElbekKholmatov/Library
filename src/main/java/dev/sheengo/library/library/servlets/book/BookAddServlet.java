package dev.sheengo.library.library.servlets.book;

import dev.sheengo.library.library.utils.ImageUtils;
import dev.sheengo.library.library.dao.BookDAO;
import dev.sheengo.library.library.dao.CategoryDAO;
import dev.sheengo.library.library.dao.DocumentDAO;
import dev.sheengo.library.library.domains.Book;
import dev.sheengo.library.library.domains.Document;
import dev.sheengo.library.library.utils.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

@WebServlet(name = "BookAddServlet", urlPatterns = "/book/add")
@MultipartConfig(location = "/home/jason/apps/library/upload")
public class BookAddServlet extends HttpServlet {

    private static final Path rootPath = Path.of(System.getProperty("user.home"), "/apps/library/upload");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        request.setAttribute("categories", categoryDAO.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/book/create.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String publishedAt1 = request.getParameter("publishedAt");
        System.out.println(publishedAt1);
        LocalDate publishedAt = LocalDate.parse(publishedAt1);
        Part file = request.getPart("file");
        Part image = request.getPart("image");

        String description = request.getParameter("description");
        String publisher = request.getParameter("publisher");
        String categoryId = request.getParameter("category_id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Document fileDocument = saveFile(file);
        Document imageDocument = saveCover(image);

        BookDAO bookDAO = BookDAO.getInstance();
        Book book = Book.builder()
                .title(title)
                .author(author)
                .description(description)
                .publisher(publisher)
                .publishedAt(publishedAt)
                .coverId(imageDocument.getId())
                .documentId(fileDocument.getId())
                .category(Integer.parseInt(categoryId))
                .pages(300)
                .build();
        bookDAO.save(book);
        response.sendRedirect("/book/books.jsp");
    }

    private Document saveCover(Part part) {
        try {
            DocumentDAO documentDAO = DocumentDAO.getInstance();
            String generateUniqueName = StringUtils.generateUniqueName(part);
            Path coverPath = rootPath.resolve(generateUniqueName);
//            byte[] bytes = ImageUtils.resizeForCover(part.getInputStream(), coverPath);
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
