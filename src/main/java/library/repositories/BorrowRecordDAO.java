package library.repositories;

import library.models.BorrowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
