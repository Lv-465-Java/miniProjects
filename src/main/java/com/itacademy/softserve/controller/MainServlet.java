package com.itacademy.softserve.controller;

import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.constant.param.MainParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for /main url.
 */
@WebServlet(ServletUrl.MAIN_URL)
public class MainServlet extends HttpServlet {

    /**
     * Method processes GET request for /main url
     * and returns main.jsp
     * for choosing between login and register option.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.MAIN_JSP).include(req, resp);
    }

    /**
     * Method processes POST request for /main url
     * gets parameter from request object,
     * determines next page.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter(MainParam.SUBMIT_LOGIN);
        if (action != null) {
            request.getRequestDispatcher(JspUrl.LOGIN_JSP).forward(request, response);
        } else {
            request.getRequestDispatcher(JspUrl.REGISTER_JSP).forward(request, response);
        }
    }
}