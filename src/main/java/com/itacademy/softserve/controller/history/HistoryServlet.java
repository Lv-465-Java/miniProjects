package com.itacademy.softserve.controller.history;

import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.util.Filter;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for /history url.
 */
@WebServlet(ServletUrl.HISTORY_URL)
public class HistoryServlet extends HttpServlet {
    private Pagination pagination;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        pagination = new Pagination();
    }

    /**
     * Method processes GET request for /history url
     * and returns filled change-password.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        pagination.historyPagination(req, resp);
    }

    /**
     * Method processes POST request for /history url
     * determines history period.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new Filter().determineHistoryPeriod(request);
        doGet(request, response);
    }
}