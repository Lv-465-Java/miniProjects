package com.itacademy.softserve.controller.task;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.service.UserService;
import com.itacademy.softserve.service.impl.TaskServiceImpl;
import com.itacademy.softserve.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.DataTruncation;
import java.util.List;

@WebServlet(ServletUrl.EDIT_TASK)
public class EditTaskServlet extends HttpServlet {
    private TaskService taskService;
    private UserService userService;

    @Override
    public void init() {
        taskService = new TaskServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.setAttribute("description", req.getParameter("description"));
        session.setAttribute("referer", req.getHeader("Referer"));
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher(JspUrl.EDIT_TASK_JSP).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        try{
            if (request.getParameter("confirm") != null) {
                taskService.edit(request, (String) session.getAttribute("description"));
            }
            response.sendRedirect((String) session.getAttribute("referer"));
        } catch (RuntimeException e) {
            request.setAttribute(ErrorMessage.ERROR.toString(), e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.EDIT_TASK_JSP)
                    .forward(request, response);
        }
    }
}