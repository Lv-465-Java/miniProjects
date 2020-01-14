package com.blog.dao;

import com.blog.db.ConnectionManager;
import com.blog.entity.IEntity;
import com.blog.entity.SqlQueries;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ADaoCRUD<TEntity extends IEntity> extends ADaoRead<TEntity> implements IDaoCRUD<TEntity> {

    protected final static String DATABASE_INPUT_ERROR = "Database Input Error";

    protected ADaoCRUD() {
        super();
    }

    protected abstract String[] getFields(TEntity entity);

    protected abstract String[] getUpdateFields(TEntity entity);

    private boolean executeQuery(String query, String[] fields,  SqlQueries sqlQueries) {
        if (query == null) {
            throw new RuntimeException(String.format(QUERY_NOT_FOUND));
        }
        boolean result = false;
        try(PreparedStatement preparedStatement = ConnectionManager.getInstance().getConnection().prepareStatement(query)) {
            for (int i = 0; i < fields.length; i++) {
                preparedStatement.setString(i + 1, fields[i]);
            }
            result = preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(DATABASE_INPUT_ERROR, e);
        }
        return result;
    }

    public boolean insert(TEntity entity) {
        String query = String.format(sqlQueries.get(SqlQueries.INSERT).toString());
        System.out.println("query = " + query);
        String[] fields = getFields(entity);
        return executeQuery(query, fields, SqlQueries.INSERT);
    }

    public boolean updateByEntity(TEntity entity) {
        String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString());
        String[] updatedFields = getUpdateFields(entity);
        return executeQuery(query, updatedFields, SqlQueries.UPDATE_BY_FIELD);
    }

    public boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition) {
        String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(),
                fieldName, fieldCondition);
        String[] fields = {text, textCondition};
        return executeQuery(query,fields, SqlQueries.UPDATE_BY_FIELD);
    }

    public boolean deleteByFieldName(String fieldCondition, String textCondition){
        String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_FIELD).toString(), fieldCondition);
        String[] fields = {textCondition};
        return executeQuery(query, fields, SqlQueries.DELETE_BY_FIELD);
    }

    public boolean delete(TEntity entity){
        return deleteById(entity.getId());
    }

    public boolean deleteById(Long id){
        String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_ID).toString());
        String[] fields = {id.toString()};
        //System.out.println("query=" + query);
        return executeQuery(query, fields, SqlQueries.DELETE_BY_ID);
    }

}
