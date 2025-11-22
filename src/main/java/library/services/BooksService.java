package library.services;

import library.models.Book;
import library.repositories.BooksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private final BooksDAO booksDAO;

    @Autowired
    public BooksService(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    public List<Book> index() {
        return booksDAO.listBooks();
    }
}
