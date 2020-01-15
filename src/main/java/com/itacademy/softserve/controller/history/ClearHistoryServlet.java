package com.itacademy.softserve.controller.history;

import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.impl.HistoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for /delete-record url.
 */
@WebServlet(ServletUrl.DELETE_RECORD)
public class ClearHistoryServlet extends HttpServlet {
    private HistoryService historyService;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        historyService = new HistoryServiceImpl();
    }

    /**
     * Method processes GET request for /delete-record url
     * redirects on history servlet.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + ServletUrl.HISTORY_URL);
    }

    /**
     * Method processes POST request for /delete-record url
     * clears all history or deletes one record.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        historyService.clear(request);
        doGet(request, response);
    }
}