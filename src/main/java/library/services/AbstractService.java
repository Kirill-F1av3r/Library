package library.services;

import library.repositories.DAO;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> implements Service<T> {
    private final DAO<T> dao;

    public AbstractService(DAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public List<T> index() {
        return dao.getList();
    }

    @Override
    public Optional<T> show(int id) {
        return Optional.ofNullable(dao.get(id));
    }

    @Override
    public void create(T t) {
        dao.save(t);
    }

    public void update(int id, T t) {
        dao.update(id, t);
    }

    public void destroy(int id) {
        dao.delete(id);
    }
}
