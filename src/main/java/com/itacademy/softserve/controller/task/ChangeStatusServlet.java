package com.itacademy.softserve.controller.task;

import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.constant.param.ControlTaskButton;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.impl.TaskServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class processes requests for /change-status url.
 */
@WebServlet(ServletUrl.CHANGE_STATUS)
public class ChangeStatusServlet extends HttpServlet {
    private TaskService taskService;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        taskService = new TaskServiceImpl();
    }

    /**
     * Method processes GET request for /change-status url
     * and send redirect on previous servlet.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        HttpSession session = req.getSession(false);
        resp.sendRedirect((String) session.getAttribute("referer"));
    }

    /**
     * Method processes POST request for /change-status url
     * sets task status done or delete it.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession(false);
        String action = request.getParameter(ControlTaskButton.DELETE);
        Long taskId;
        if (action == null) {
            String previous = request.getHeader("Referer");
            session.setAttribute("referer", previous);
            taskId = Long.parseLong(request.getParameter(ControlTaskButton.DONE));
            taskService.setDone(request, taskId);
        } else {
            taskId = Long.parseLong(request.getParameter(ControlTaskButton.DELETE));
            taskService.setDelete(request, taskId);
        }
        doGet(request, response);
    }
}