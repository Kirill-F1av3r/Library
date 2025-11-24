package library.services;

import library.models.Book;
import library.repositories.BooksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService extends AbstractService<Book> {

    @Autowired
    public BooksService(BooksDAO booksDAO) {
        super(booksDAO);
    }

}
