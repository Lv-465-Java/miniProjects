package com.itacademy.softserve.controller.task;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.TaskDtoMapper;
import com.itacademy.softserve.service.UserService;
import com.itacademy.softserve.service.impl.TaskServiceImpl;
import com.itacademy.softserve.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class processes requests for /add-task url.
 */
@WebServlet(ServletUrl.ADD_TASK_URL)
public class AddTaskServlet extends HttpServlet {
    private UserService userService;
    private TaskServiceImpl taskService;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        userService = new UserServiceImpl();
        taskService = new TaskServiceImpl();
    }

    /**
     * Method processes GET request for /add-task url
     * and returns add-task.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher(JspUrl.ADD_TASK_JSP).include(req, resp);
    }

    /**
     * Method processes POST request for /add-task url
     * saves task and returns on previous servlet.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        try {
            taskService.save(request, new TaskDtoMapper().createDtoFromRequest(request));
            response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
        } catch (RuntimeException e) {
            request.setAttribute(ErrorMessage.ERROR.toString(), e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.ADD_TASK_JSP)
                    .forward(request, response);
        }
    }
}