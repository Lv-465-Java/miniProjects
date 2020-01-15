package com.itacademy.softserve.dao.filter;

import com.itacademy.softserve.dao.builder.HistoryBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.History;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Class, that implements special methods for
 * getting filtered history from database.
 */
public class HistoryFilter {
    private final String queryByTime = "SELECT * FROM history WHERE UserID = ? AND ModifiedDate BETWEEN ? AND ? ;";

    /**
     * Method get today history.
     *
     * @param userID determines task pool of certain user
     * @return list of history records
     */
    public List<History> getToday(Long userID) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, queryByTime, new HistoryBuilder(),
                userID, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
    }

    /**
     * Method get last week history.
     *
     * @param userID determines task pool of certain user
     * @return list of history records
     */
    public List<History> getLastWeek(Long userID) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, queryByTime, new HistoryBuilder(),
                userID, Date.valueOf(LocalDate.now().minusWeeks(1)), Date.valueOf(LocalDate.now()));
    }

    /**
     * Method get last month history.
     *
     * @param userID determines task pool of certain user
     * @return list of history records
     */
    public List<History> getLastMonth(Long userID) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, queryByTime, new HistoryBuilder(),
                userID, Date.valueOf(LocalDate.now().minusMonths(1)), Date.valueOf(LocalDate.now()));
    }

    /**
     * Method get last year history.
     *
     * @param userID determines task pool of certain user
     * @return list of history records
     */
    public List<History> getLastYear(Long userID) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, queryByTime, new HistoryBuilder(),
                userID, Date.valueOf(LocalDate.now().minusYears(1)), Date.valueOf(LocalDate.now()));
    }
}
