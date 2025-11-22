package library.repositories;

import library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class BooksDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BooksDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> listBooks() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBook(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id = ?", new BeanPropertyRowMapper<>(Book.class), id)
                .stream().findAny().orElse(null);
    }

    public void save(String name, String author, Date release_date, int count) {
        String sql = "INSERT INTO Book (name, author, release_date, count) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, author, release_date, count);
    }

    public void update(int id, String name, String author, Date release_date, int count) {
        String sql = "UPDATE Book SET name = ?, author = ?, release_date = ?, count = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, author, release_date, count, id);
    }
}
