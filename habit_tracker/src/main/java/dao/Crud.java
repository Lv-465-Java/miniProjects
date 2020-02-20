package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Crud<Entity> {

    int insert(Entity entity);
    List<Entity> getAll();
    Optional<Entity> getById(long id);
    int updateById(Entity entity);
   // boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);
    int deleteById(long id);
   // boolean deleteByFieldName(String fieldCondition, String textCondition);
    //boolean delete(Entity entity);
}
