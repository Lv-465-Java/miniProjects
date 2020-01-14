package dao;

import java.util.List;
import java.util.Optional;

public interface DaoRead<TEntity> {

    Optional<TEntity> getById(Long id);

    Optional<TEntity> getByField(String text);

    List<TEntity> getByUserId(Long userId);

    List<TEntity> getByFieldName(Long id);

    List<TEntity> getAll();

    List<TEntity> getAllLimit();
}
