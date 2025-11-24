package library.services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    List<T> index();

    Optional<T> show(int id);

    void create(T t);

    void update(int id, T t);

    void destroy(int id);
}
