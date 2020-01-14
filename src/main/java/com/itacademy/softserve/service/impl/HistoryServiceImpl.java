package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.constant.HistoryPeriod;
import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.constant.param.ControlTaskButton;
import com.itacademy.softserve.dao.HistoryDao;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.HistoryDtoMapper;
import com.itacademy.softserve.entity.History;
import com.itacademy.softserve.service.HistoryService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private List<History> historyList;
    private HistoryDao historyDao;

    public HistoryServiceImpl() {
        historyList = new ArrayList<>();
        historyDao = new HistoryDao();
    }

    @Override
    public List<HistoryDto> getHistorySet(HttpServletRequest request, int begin) {
        historyList = (List<History>) request.getSession(false).getAttribute(HistoryPeriod.PERIOD.toString());
        if (historyList == null) {
            historyList = new ArrayList<>();
        }
        List<HistoryDto> historyGroup = new ArrayList<>();
        int end = begin + NumberOfRecordsPerPage.HISTORY_RECORD_PER_PAGE;
        if (end > historyList.size()) {
            end = historyList.size();
        }
        for (History historyRecord : historyList.subList(begin, end)) {
            historyGroup.add(new HistoryDtoMapper().mapFromEntityToDto(historyRecord));
        }
        return historyGroup;
    }

    @Override
    public int getNumberOfPages() {
        if (historyList == null) {
            return 0;
        }
        return (int) Math.ceil((double) historyList.size() / NumberOfRecordsPerPage.HISTORY_RECORD_PER_PAGE);
    }

    @Override
    public boolean clear(HttpServletRequest request) {
        String action = request.getParameter(ControlTaskButton.DELETE);
        if (action != null) {
            historyList = (List<History>) request.getSession(false).getAttribute(HistoryPeriod.PERIOD.toString());
            Long historyId = Long.parseLong(request.getParameter(ControlTaskButton.DELETE));
            for (History history : historyList) {
                if (history.getId().equals(historyId)) {
                    historyList.remove(history);
                    break;
                }
            }
            return historyDao.deleteByID(historyId);
        } else {
            UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
            return historyDao.deleteByField(new UserDao().getByFields(new UserBuilder(), userDto.getName()).get(0).getId());
        }
    }

    @Override
    public boolean addRecord(TaskDto taskDto) {
        History historyRecord = new History();
        historyRecord.setTaskDescription(taskDto.getDescription());
        historyRecord.setModifiedDate(Date.valueOf(LocalDate.now()));
        historyRecord.setStatusID(new StatusDao().getByFields(new StatusBuilder(), taskDto.getStatus()).get(0).getId().intValue());
        historyRecord.setUserID(new UserDao().getByFields(new UserBuilder(), taskDto.getAssignee()).get(0).getId());
        return new HistoryDao().insert(historyRecord);
    }
}