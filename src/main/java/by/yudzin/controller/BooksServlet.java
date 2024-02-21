package by.yudzin.controller;

import by.yudzin.model.entity.Book;
import by.yudzin.model.repository.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookRepository bookRepository = new BookRepository();
        List<Book> books = bookRepository.getBooks();
        //req.getSession().setAttribute("books", books);
        req.setAttribute("books", books);

        req.getRequestDispatcher("/WEB-INF/jsp/books.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }
}