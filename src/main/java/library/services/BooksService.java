package library.services;

import library.models.Book;
import library.repositories.BooksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Book> show(int id) {
        return Optional.ofNullable(booksDAO.getBook(id));
    }

    public void create(Book book) {
        booksDAO.save(book.getName(), book.getAuthor(), book.getRelease_date(), book.getCount());
    }
}
