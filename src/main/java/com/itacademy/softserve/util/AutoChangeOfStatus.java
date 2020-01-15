package com.itacademy.softserve.util;

import com.itacademy.softserve.constant.Statuses;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dto.mapper.TaskDtoMapper;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.impl.HistoryServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class AutoChangeOfStatus {
    private TaskDao taskDao = new TaskDao();

    /**
     * Method updates task statuses according
     * today date.
     *
     * @param tasks list of task object
     */
    public void updateStatuses(List<Task> tasks) {
        HistoryService historyService = new HistoryServiceImpl();
        TaskDtoMapper taskDtoMapper = new TaskDtoMapper();
        Date currentDate = Date.valueOf(LocalDate.now());
        StatusDao statusDao = new StatusDao();
        TaskDao taskDao = new TaskDao();
        int fail = statusDao.getByFields(new StatusBuilder(), Statuses.FAIL).get(0).getId().intValue();
        int progress = statusDao.getByFields(new StatusBuilder(), Statuses.IN_PROGRESS).get(0).getId().intValue();
        int done = statusDao.getByFields(new StatusBuilder(), Statuses.DONE).get(0).getId().intValue();
        for (Task task : tasks) {
            if (task.getStatusID() == done || task.getStatusID() == progress || task.getStatusID() == fail) {
                continue;
            }
            if (task.getDeadline() != null && task.getDeadline().compareTo(currentDate) < 0) {
                task.setStatusID(fail);
                taskDao.updateByID(fail, task.getId());
            }
            if (task.getCreationDate().compareTo(currentDate) > 0) {
                task.setStatusID(progress);
                taskDao.updateByID(progress, task.getId());
            }
            try {
                historyService.addRecord(taskDtoMapper.mapFromEntityToDto(task));
            } catch (RuntimeException ignored) {
            }
        }
    }
}
