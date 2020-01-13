package com.itacademy.softserve.controller.task;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(ServletUrl.CONFIRM_DELETE)
public class ConfirmDeleteServlet extends HttpServlet {
    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.setAttribute("referer", req.getHeader("Referer"));
        req.getRequestDispatcher(JspUrl.CONFIRM_DELETE_JSP).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}