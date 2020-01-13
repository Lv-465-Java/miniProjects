package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TaskService {
    List<TaskDto> getPageSet(HttpServletRequest request, int begin);

    boolean save(HttpServletRequest request, TaskDto taskDto);

    int getNumberOfPages();

    boolean setDone(HttpServletRequest request, Long taskId);

    boolean setDelete(HttpServletRequest request, Long taskId);

    boolean edit(HttpServletRequest request, String description);

    List<TaskDto> getSearchSet(UserDto userDto, String regex, int begin);
}

