package dao;

public interface DaoCRUD<TEntity> extends DaoRead<TEntity> {

    boolean insert(TEntity entity);

    boolean updateByEntity(TEntity entity);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

    boolean deleteByFieldName(String textCondition);

    boolean delete(TEntity entity);
}
