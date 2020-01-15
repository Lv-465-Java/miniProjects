package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TaskService {

    /**
     * Method for getting list of tasks
     * for one page.
     *
     * @param request HTTP request object
     * @param begin   index of task in general list
     * @return list of tasks
     */
    List<TaskDto> getPageSet(HttpServletRequest request, int begin);

    /**
     * Method for saving tasks.
     *
     * @param request HTTP request object
     * @param taskDto UserDto object
     * @return true if task is saved
     */
    boolean save(HttpServletRequest request, TaskDto taskDto);

    /**
     * Method for calculating number of pages.
     *
     * @return number of pages
     */
    int getNumberOfPages();

    /**
     * Method changes status of task on done.
     *
     * @param request HTTP request object
     * @param taskId  id of current task
     * @return true if done status is set
     */
    boolean setDone(HttpServletRequest request, Long taskId);

    /**
     * Method deletes tasks.
     *
     * @param request HTTP request object
     * @param taskId  id of current task
     * @return true if task is deleted
     */
    boolean setDelete(HttpServletRequest request, Long taskId);

    /**
     * Method for editing tasks.
     *
     * @param request     HTTP request object
     * @param description
     * @return true if user has access to edit task
     */
    boolean edit(HttpServletRequest request, String description);

    /**
     * Method for getting list of
     * filtered tasks for one page.
     *
     * @param userDto UserDto object
     * @param regex
     * @param begin   index of task in general list
     * @return list of tasks
     */
    List<TaskDto> getSearchSet(UserDto userDto, String regex, int begin);
}

