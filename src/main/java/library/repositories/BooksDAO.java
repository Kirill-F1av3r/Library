package library.repositories;

import library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDAO extends AbstractDAO<Book> {
    private final JdbcTemplate jdbcTemplate;

    private static final String TABLE_NAME_SQL = "Book";

    @Autowired
    public BooksDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, TABLE_NAME_SQL);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }

    @Override
    public void save(Book book) {
        String sql = "INSERT INTO Book (name, author, release_date, count) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getRelease_date(), book.getCount());
    }

    @Override
    public void update(int id, Book book) {
        String sql = "UPDATE Book SET name = ?, author = ?, release_date = ?, count = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getRelease_date(), book.getCount(), id);
    }
}
