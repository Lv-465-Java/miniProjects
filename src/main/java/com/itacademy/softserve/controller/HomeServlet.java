package com.itacademy.softserve.controller;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.UserService;
import com.itacademy.softserve.service.impl.UserServiceImpl;
import com.itacademy.softserve.util.Filter;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(ServletUrl.HOME_URL)
public class HomeServlet extends HttpServlet {
    private Pagination pagination;

    @Override
    public void init() {
        pagination = new Pagination();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UserDto> users = new UserServiceImpl().getAll();
        req.setAttribute("users", users);
        pagination.homePagination(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            new Filter().determineFilter(request);
            doGet(request, response);
        } catch (RuntimeException e) {
            request.setAttribute(ErrorMessage.ERROR.toString(), ErrorMessage.NO_INFO.toString());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.HOME_JSP)
                    .forward(request, response);
        }
    }
}