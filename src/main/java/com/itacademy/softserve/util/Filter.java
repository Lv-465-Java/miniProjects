package com.itacademy.softserve.util;

import com.itacademy.softserve.constant.HistoryPeriod;
import com.itacademy.softserve.dao.HistoryDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.HistoryBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dao.filter.HistoryFilter;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.History;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;

public class Filter {


    public void determineHistoryPeriod(HttpServletRequest request) {
        HistoryFilter historyFilter = new HistoryFilter();
        HistoryDao historyDao = new HistoryDao();
        List<History> historyList;
        HttpSession session = request.getSession(false);
        Long userId = new UserDao().getByFields(new UserBuilder(),
                ((UserDto)session.getAttribute("userDto")).getName()).get(0).getId();
        String period = null;
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
        session.setAttribute(HistoryPeriod.PERIOD.toString(), historyList);
    }
}

