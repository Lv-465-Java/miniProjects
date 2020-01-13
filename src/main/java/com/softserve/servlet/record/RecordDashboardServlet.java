package com.softserve.servlet.record;

import com.softserve.constant.View;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.CategoryServiceImpl;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
import com.softserve.service.implementation.RecordServiceImpl;
import com.softserve.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/record-dashboard"})
public class RecordDashboardServlet extends HttpServlet {

    private RecordServiceImpl recordService;
    private CategoryServiceImpl categoryService;
    private PlanedOutcomeServiceImpl planedOutcomeService;
    private UserSession userSession;
    private Logger LOG = LoggerFactory.getLogger(RecordDashboardServlet.class);

    @Override
    public void init() {
        recordService = new RecordServiceImpl();
        categoryService = new CategoryServiceImpl();
        planedOutcomeService = new PlanedOutcomeServiceImpl();
        userSession = new UserSession();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentSessionUser = userSession.retrieveUserIdFromSession(req);

        req.setAttribute("records", recordService.getAllByUserId(currentSessionUser.getId()));
        req.setAttribute("financialTypes", recordService.getTypes());
        req.setAttribute("categories", categoryService.getAllByUserId(currentSessionUser.getId()));
        req.setAttribute("plannedOutcomes", planedOutcomeService.getAllByUserId(currentSessionUser.getId()));
        req.getRequestDispatcher(View.RECORD_DASHBOARD_PAGE.getViewUrl()).include(req, resp);
        LOG.info("'Record Dashboard' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}