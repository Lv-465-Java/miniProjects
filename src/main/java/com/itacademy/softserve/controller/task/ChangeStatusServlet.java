package com.itacademy.softserve.controller.task;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.constant.param.ControlTaskButton;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.impl.TaskServiceImpl;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(ServletUrl.CHANGE_STATUS)
public class ChangeStatusServlet extends HttpServlet {
    private TaskService taskService;
    private Pagination pagination;

    @Override
    public void init() {
        taskService = new TaskServiceImpl();
        pagination = new Pagination();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.sendRedirect((String) session.getAttribute("referer"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter(ControlTaskButton.DONE);
        Long taskId;
        if (action != null) {
            taskId = Long.parseLong(request.getParameter(ControlTaskButton.DONE));
            taskService.setDone(taskId);
        } else {
            taskId = Long.parseLong(request.getParameter(ControlTaskButton.DELETE));
            taskService.setDelete(taskId);
        }
        doGet(request, response);
    }
}