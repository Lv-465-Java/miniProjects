package com.itacademy.softserve.controller.user;

import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.util.SessionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for /log-out url.
 */
@WebServlet(ServletUrl.LOG_OUT_URL)
public class LogOutServlet extends HttpServlet {
    /**
     * Method processes GET request for /log-out url
     * and redirect to main.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        SessionManager.destroySession(req, resp);
        resp.sendRedirect(req.getContextPath() + ServletUrl.MAIN_URL);
    }
}