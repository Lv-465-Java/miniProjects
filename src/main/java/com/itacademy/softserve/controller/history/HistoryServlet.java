package com.itacademy.softserve.controller.history;

import com.itacademy.softserve.constant.HistoryPeriod;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.impl.HistoryServiceImpl;
import com.itacademy.softserve.util.Filter;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(ServletUrl.HISTORY_URL)
public class HistoryServlet extends HttpServlet {
    private Pagination pagination;

    @Override
    public void init(){
        pagination = new Pagination();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        pagination.historyPagination(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        new Filter().determineHistoryPeriod(request);
        doGet(request, response);
    }
}