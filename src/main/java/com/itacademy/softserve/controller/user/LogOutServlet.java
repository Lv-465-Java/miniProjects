package com.itacademy.softserve.controller.user;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.util.SessionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(ServletUrl.LOG_OUT_URL)
public class LogOutServlet extends HttpServlet {

    public void init() {
    }

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.MAIN_JSP).include(req, resp);
        SessionManager.destroySession(req, resp);
        resp.sendRedirect(req.getContextPath() + ServletUrl.MAIN_URL);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}