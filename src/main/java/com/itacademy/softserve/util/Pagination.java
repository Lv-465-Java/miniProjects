package com.itacademy.softserve.util;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.dto.HistoryDto;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.impl.HistoryServiceImpl;
import com.itacademy.softserve.service.impl.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Pagination {
    private TaskService taskService = new TaskServiceImpl();

    /**
     * Method get current page number from
     * request.
     *
     * @param request HTTP request object
     * @return number of current page
     */
    private Integer getPage(HttpServletRequest request) {
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        return page;
    }

    /**
     * Method returns filled home.jsp
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    public void homePagination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = getPage(request);
        if (SessionManager.isActiveSession(request)) {
            int begin = (page - 1) * NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE;
            List<TaskDto> tasks = taskService.getPageSet(request, begin);
            request.setAttribute("taskList", tasks);
            request.setAttribute("numOfPages", taskService.getNumberOfPages());
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher(JspUrl.HOME_JSP).include(request, response);
        } else {
            request.getRequestDispatcher(JspUrl.MAIN_JSP).forward(request, response);
        }
    }

    /**
     * Method returns filled search.jsp
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    public void searchPagination(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = getPage(request);
        if (SessionManager.isActiveSession(request)) {
            HttpSession session = request.getSession(false);
            UserDto userDto = (UserDto) session.getAttribute("userDto");
            String regex = (String) session.getAttribute("regex");
            List<TaskDto> tasks = taskService.getSearchSet(userDto, regex, (page - 1) * NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE);
            request.setAttribute("taskList", tasks);
            request.setAttribute("numOfPages", taskService.getNumberOfPages());
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher(JspUrl.SEARCH_JSP).include(request, response);
        } else {
            request.getRequestDispatcher(JspUrl.MAIN_JSP).forward(request, response);
        }
    }

    /**
     * Method returns filled history.jsp
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    public void historyPagination(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HistoryService historyService = new HistoryServiceImpl();
        int page = getPage(request);
        if (SessionManager.isActiveSession(request)) {
            List<HistoryDto> historyList = historyService.getHistorySet(request,
                    (page - 1) * NumberOfRecordsPerPage.HISTORY_RECORD_PER_PAGE);
            request.setAttribute("historyList", historyList);
            request.setAttribute("numOfPages", historyService.getNumberOfPages());
            request.setAttribute("currentPage", page);
            request.getRequestDispatcher(JspUrl.HISTORY_JSP).include(request, response);
        } else {
            request.getRequestDispatcher(JspUrl.MAIN_JSP).forward(request, response);
        }
    }
}
