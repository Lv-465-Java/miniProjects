package com.itacademy.softserve.util;

import com.itacademy.softserve.constant.HistoryPeriod;
import com.itacademy.softserve.constant.param.FilterTypes;
import com.itacademy.softserve.dao.HistoryDao;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.HistoryBuilder;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.TaskBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dao.filter.HistoryFilter;
import com.itacademy.softserve.dao.filter.TaskFilter;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.History;
import com.itacademy.softserve.entity.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filter {
    public void determineHistoryPeriod(HttpServletRequest request) {
        HistoryFilter historyFilter = new HistoryFilter();
        HistoryDao historyDao = new HistoryDao();
        List<History> historyList;
        HttpSession session = request.getSession(false);
        Long userId = new UserDao().getByFields(new UserBuilder(),
                ((UserDto) session.getAttribute("userDto")).getName()).get(0).getId();
        if (request.getParameter(HistoryPeriod.TODAY.toString()) != null) {
            historyList = historyFilter.getToday(userId);
            session.setAttribute(HistoryPeriod.PERIOD.toString(), historyList);
        } else if (request.getParameter(HistoryPeriod.LAST_WEEK.toString()) != null) {
            historyList = historyFilter.getLastWeek(userId);
        } else if (request.getParameter(HistoryPeriod.LAST_MONTH.toString()) != null) {
            historyList = historyFilter.getLastMonth(userId);
        } else if (request.getParameter(HistoryPeriod.LAST_YEAR.toString()) != null) {
            historyList = historyFilter.getLastYear(userId);
        } else {
            historyList = historyDao.getAll(new HistoryBuilder(), userId);
        }
        Collections.reverse(historyList);
        session.setAttribute(HistoryPeriod.PERIOD.toString(), historyList);
    }

    public void determineFilter(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserDao userDao = new UserDao();
        UserDto userDto = (UserDto) session.getAttribute("userDto");
        UserBuilder userBuilder = new UserBuilder();
        Long userId = userDao.getByFields(userBuilder, userDto.getName()).get(0).getId();
        TaskFilter taskFilter = new TaskFilter();
        TaskDao taskDao = new TaskDao();
        TaskBuilder taskBuilder = new TaskBuilder();
        List<Task> tasks;
        String filter = request.getParameter(FilterTypes.FILTER_CHECK);
        session.setAttribute("filter", filter);
        String reset = request.getParameter("reset");
        if (filter == null || reset != null) {
            tasks = taskDao.getAll(new TaskBuilder(), userId, userId);
        } else if (filter.equals(FilterTypes.BY_OWNER)) {
            String owner = request.getParameter("users");
            Long ownerId = userDao.getByFields(userBuilder, owner).get(0).getId();
            tasks = taskFilter.filterByOwner(taskBuilder, userId, ownerId);
        } else if (filter.equals(FilterTypes.BY_DATE)) {
            String beginDate = request.getParameter("from");
            String endDate = request.getParameter("to");
            tasks = taskFilter.filterByDate(taskBuilder, userId, Date.valueOf(beginDate), Date.valueOf(endDate));
        } else if (filter.equals(FilterTypes.BY_STATUS)) {
            String status = request.getParameter("statuses");
            Integer statusId = new StatusDao().getByFields(new StatusBuilder(), status).get(0).getId().intValue();
            tasks = taskFilter.filterByStatus(taskBuilder, userId, statusId);
        } else {
            tasks = new ArrayList<>();
        }
        Collections.reverse(tasks);
        session.setAttribute("tasks", tasks);
    }
}

