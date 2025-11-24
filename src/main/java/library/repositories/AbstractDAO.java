package library.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T> {

    private final JdbcTemplate jdbcTemplate;
    private final String tableNameSQL;

    public AbstractDAO(JdbcTemplate jdbcTemplate, String tableNameSQL) {
        this.jdbcTemplate = jdbcTemplate;
        this.tableNameSQL = tableNameSQL;
    }

    protected abstract Class<T> getEntityClass();

    @Override
    public List<T> getList() {
        return jdbcTemplate.query("SELECT * FROM " + tableNameSQL, new BeanPropertyRowMapper<>(getEntityClass()));
    }

    @Override
    public T get(int id) {
        return jdbcTemplate.query("SELECT * FROM " + tableNameSQL +" WHERE id = ?",
                        new BeanPropertyRowMapper<>(getEntityClass()), id).stream().findAny().orElse(null);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM " + tableNameSQL +" WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
