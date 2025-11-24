package library.repositories;

import library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO extends AbstractDAO<Person> {
    private final JdbcTemplate jdbcTemplate;

    private static final String TABLE_NAME_SQL = "Person";

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, TABLE_NAME_SQL);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public void save(Person person) {
        String sql = "INSERT INTO Person (name, birthday, email, phone) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, person.getName(), person.getBirthday(), person.getEmail(), person.getPhone());
    }

    @Override
    public void update(int id, Person person) {
        String sql = "UPDATE Person SET name = ?, birthday = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql, person.getName(), person.getBirthday(), person.getEmail(), person.getPhone(), id);
    }
}
