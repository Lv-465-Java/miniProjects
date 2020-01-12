package dao.impl;

import dao.DaoCRUD;
import db.ConnectionManager;
import entity.IEntity;
import entity.SqlQueries;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

 public abstract class DaoCRUDAbsImpl<TEntity extends IEntity> extends DaoReadAbsImpl<TEntity> implements DaoCRUD<TEntity> {
        protected final static String DATABASE_INPUT_ERROR = "Database Input Error";

        protected DaoCRUDAbsImpl() {
            super();
        }

        protected abstract String[] getFields(TEntity entity);

        protected abstract String[] getUpdateFields(TEntity entity);

        private boolean executeQuery(String query, SqlQueries sqlQueries, Object ... args) {
           boolean result;

            if (query == null) {
                throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
            }

            try (PreparedStatement preparedStatement=ConnectionManager.getInstance().getConnection().prepareStatement(query)){

                for (int i=1; i<= args.length; i++) {
                    preparedStatement.setObject(i, args[i-1]);
                }
                result = preparedStatement.executeUpdate()>0 ? Boolean.TRUE : Boolean.FALSE;//.execute();
            } catch (SQLException e) {
                throw new RuntimeException(DATABASE_INPUT_ERROR, e);
            }
            return result;
        }


        public boolean insert(TEntity entity) {
            return executeQuery(sqlQueries.get(SqlQueries.INSERT).toString(), SqlQueries.INSERT,
                    (Object) Arrays.copyOfRange(getFields(entity), 0, getFields(entity).length));
        }

        public boolean updateByEntity(TEntity entity) {

            return executeQuery(sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), SqlQueries.UPDATE_BY_FIELD,  (Object) getUpdateFields(entity));
        }

        public boolean updateByField(String text, String textCondition) {
            return executeQuery(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(), SqlQueries.UPDATE_BY_FIELD,  text, textCondition);
        }

        public boolean deleteById(Long id) {
            return executeQuery(sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(), SqlQueries.DELETE_BY_ID,id);
        }

        public boolean deleteByFieldName(String textCondition) {
            return executeQuery(sqlQueries.get(SqlQueries.DELETE_BY_FIELD).toString(), SqlQueries.DELETE_BY_FIELD, textCondition);
        }

        public boolean delete(TEntity entity) {
            return deleteById(entity.getId());
        }
}
