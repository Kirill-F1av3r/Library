package library.repositories;

import java.util.List;

public interface DAO<T> {
    List<T> getList();

    T get(int id);

    void save(T t);

    void update(int id, T t);

    void delete(int id);
}
