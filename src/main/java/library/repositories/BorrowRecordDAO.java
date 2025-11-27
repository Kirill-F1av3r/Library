package library.repositories;

import library.models.BorrowRecord;
import library.models.BorrowRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BorrowRecordDAO extends AbstractDAO<BorrowRecord> {
    private final JdbcTemplate jdbcTemplate;

    private static final String TABLE_NAME_SQL = "borrow_record";

    @Autowired
    public BorrowRecordDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, TABLE_NAME_SQL);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    protected Class<BorrowRecord> getEntityClass() {
        return BorrowRecord.class;
    }

    @Override
    public void save(BorrowRecord borrowRecord) {
        String sql = "INSERT INTO borrow_record (book_id, person_id, borrow_date, return_date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, borrowRecord.getBook_id(), borrowRecord.getPerson_id(),
                borrowRecord.getBorrow_date(), borrowRecord.getReturn_date());
    }

    @Override
    public void update(int id, BorrowRecord borrowRecord) {
        String sql = "UPDATE borrow_record SET book_id = ?, person_id = ?, borrow_date = ?, return_date = ? WHERE id = ?";
        jdbcTemplate.update(sql, borrowRecord.getBook_id(), borrowRecord.getPerson_id(),
                borrowRecord.getBorrow_date(), borrowRecord.getReturn_date(), id);
    }

    public List<BorrowRecordDTO> getListDTO() {
        String sql = "SELECT br.id, br.book_id, br.person_id, br.borrow_date, br.return_date," +
                " book.name AS bookName, person.name AS personName " +
                "FROM borrow_record AS br JOIN book ON book.id = br.book_id " +
                "JOIN person ON person.id = br.person_id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecordDTO.class));
    }

    public BorrowRecordDTO getDTO(int id) {
        String sql = "SELECT br.id, br.book_id, br.person_id, br.borrow_date, br.return_date," +
                " book.name AS bookName, person.name AS personName " +
                "FROM borrow_record AS br JOIN book ON book.id = br.book_id " +
                "JOIN person ON person.id = br.person_id " +
                "WHERE br.id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecordDTO.class), id)
                .stream().findAny().orElse(null);
    }
}
