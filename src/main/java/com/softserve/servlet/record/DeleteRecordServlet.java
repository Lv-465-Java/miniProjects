package com.softserve.servlet.record;

import com.softserve.constant.View;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.RecordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/delete-record"})
public class DeleteRecordServlet extends HttpServlet {

    private RecordServiceImpl recordService;
    private Logger LOG = LoggerFactory.getLogger(AddRecordServlet.class);
    private Long recordId;

    @Override
    public void init() {
        this.recordService = new RecordServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        recordId = Long.parseLong(req.getParameter("buttondelete"));
        req.setAttribute("record", recordService.getById(recordId));
        req.getRequestDispatcher(View.RECORD_DELETE_PAGE.getViewUrl()).include(req, resp);

        LOG.info("'Delete Record' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        recordId = Long.parseLong(req.getParameter("buprofile"));
        try {
            recordService.delete(recordId);
            resp.sendRedirect(req.getContextPath() + "/record-dashboard");
            LOG.info("Record is deleted. User is redirected to 'Record Dashboard' Page");
        } catch (NotCompletedActionException e) {
            LOG.info("Error: " + e.getMessage());
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.RECORD_DELETE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}