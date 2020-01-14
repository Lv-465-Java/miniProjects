package com.blog.dao;

public interface IDaoCRUD<IEntity> extends IDaoRead<IEntity> {

    boolean insert(IEntity entity);

    // Update
    boolean updateByEntity(IEntity entity);

    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    // Delete
    boolean deleteById(Long id);

    boolean deleteByFieldName(String fieldCondition, String textCondition);

    boolean delete(IEntity entity);
}
