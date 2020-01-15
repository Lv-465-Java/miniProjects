package com.itacademy.softserve.controller;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.constant.param.FilterTypes;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.service.impl.UserServiceImpl;
import com.itacademy.softserve.util.Filter;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class processes requests for /home url.
 */
@WebServlet(ServletUrl.HOME_URL)
public class HomeServlet extends HttpServlet {
    private Pagination pagination;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        pagination = new Pagination();
    }

    /**
     * Method processes GET request for /home url
     * and returns filled home.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UserDto> users = new UserServiceImpl().getAll();
        req.setAttribute("users", users);
        pagination.homePagination(req, resp);
    }

    /**
     * Method processes POST request for /home url
     * gets parameter from request object,
     * sets filter to session.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            String filter = request.getParameter(FilterTypes.FILTER_CHECK);
            session.setAttribute("filter", filter);
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