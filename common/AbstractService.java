package common;

import enums.Messenger;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save(T t);
    public abstract List<T> findAll();
    public abstract Optional<T> findById(Long id);
    public abstract String count();
    public abstract Optional<T> getOne(String id);
    public abstract String delete(T t);
    public abstract Boolean existById(Long id);

}
