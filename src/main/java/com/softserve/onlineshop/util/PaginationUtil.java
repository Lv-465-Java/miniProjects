package com.softserve.onlineshop.util;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PaginationUtil {
//    private PhoneService phoneService;
//
//    private Integer getPage(HttpServletRequest request) {
//        int page = 1;
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        return page;
//    }
//
//    public void productPagination (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int page = getPage(request);
//            UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
//            int begin = (page - 1) * NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE;
//            List<TaskDto> tasks = determineFilter(userDto, begin, request);
//            request.setAttribute("taskList", tasks);
//            request.setAttribute("numOfPages", taskService.getNumberOfPages());
//            request.setAttribute("currentPage", page);
//            request.getRequestDispatcher(JspUrl.HOME_JSP).include(request, response);
//    }
}
