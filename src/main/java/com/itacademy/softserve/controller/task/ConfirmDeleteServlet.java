package com.itacademy.softserve.controller.task;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class processes requests for /confirm-delete url.
 */
@WebServlet(ServletUrl.CONFIRM_DELETE)
public class ConfirmDeleteServlet extends HttpServlet {

    /**
     * Method processes GET request for /confirm-delete url
     * sets session attribute and returns delete-confirm.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String previous = req.getHeader("Referer");
        session.setAttribute("referer", previous);
        req.getRequestDispatcher(JspUrl.CONFIRM_DELETE_JSP).include(req, resp);
    }
}