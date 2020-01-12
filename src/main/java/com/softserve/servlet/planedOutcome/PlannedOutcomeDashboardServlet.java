package com.softserve.servlet.planedOutcome;

import com.softserve.constant.View;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.CategoryServiceImpl;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
import com.softserve.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/planned-outcome-dashboard"})
public class PlannedOutcomeDashboardServlet extends HttpServlet {

    private PlanedOutcomeServiceImpl planedOutcomeService;
    private CategoryServiceImpl categoryService;
    private UserSession userSession;
    private Logger LOG = LoggerFactory.getLogger(PlannedOutcomeDashboardServlet.class);

    @Override
    public void init() {
        planedOutcomeService = new PlanedOutcomeServiceImpl();
        categoryService = new CategoryServiceImpl();
        userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentSessionUser = userSession.retrieveUserIdFromSession(req);

        req.setAttribute("plannedOutcomes", planedOutcomeService.getAllByUserId(currentSessionUser.getId()));
        req.setAttribute("categories", categoryService.getAllByUserIdAndFinancialTypeId(currentSessionUser.getId()));
        req.getRequestDispatcher(View.PLANNED_OUTCOME_DASHBOARD_PAGE.getViewUrl()).include(req, resp);
        LOG.info("'Planned Outcome Dashboard' Page is loaded");
    }
}
