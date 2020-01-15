package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.TaskDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface HistoryService {

    /**
     * Method for getting list of records
     * for one page.
     *
     * @param request HTTP request object
     * @param begin   index of task in general list
     * @return list of tasks
     */
    List<HistoryDto> getHistorySet(HttpServletRequest request, int begin);

    /**
     * Method for calculating number of pages.
     *
     * @return number of pages
     */
    int getNumberOfPages();

    /**
     * Method clear all history or
     * delete only one record.
     *
     * @param request HTTP request object
     * @return true if history is deleted
     */
    boolean clear(HttpServletRequest request);

    /**
     * Method adds history record.
     *
     * @param taskDto TaskDto object
     * @return true if record is added
     */
    boolean addRecord(TaskDto taskDto);
}
