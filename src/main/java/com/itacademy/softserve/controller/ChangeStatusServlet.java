package com.itacademy.softserve.controller;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.constant.param.ControlTaskButton;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.impl.TaskServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(ServletUrl.CHANGE_STATUS)
public class ChangeStatusServlet extends HttpServlet {
    private TaskService taskService;

    @Override
    public void init() {
        taskService = new TaskServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(req.getHeader("Referer"));
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