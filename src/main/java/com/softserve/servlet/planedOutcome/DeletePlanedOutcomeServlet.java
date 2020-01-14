package com.softserve.servlet.planedOutcome;

import com.softserve.constant.ErrorMessage;
import com.softserve.constant.View;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/delete-planned-outcome"})
public class DeletePlanedOutcomeServlet extends HttpServlet {

    private PlanedOutcomeServiceImpl planedOutcomeService;
    private Logger LOG = LoggerFactory.getLogger(DeletePlanedOutcomeServlet.class);
    private Long plannedOutcomeId;

    @Override
    public void init() {
        this.planedOutcomeService = new PlanedOutcomeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        plannedOutcomeId = Long.parseLong(req.getParameter("id"));
        req.setAttribute("plannedOutcome", planedOutcomeService.getById(plannedOutcomeId));
        req.getRequestDispatcher(View.PLANNED_OUTCOME_DELETE_PAGE.getViewUrl()).include(req, resp);

        LOG.info("'Delete Planned outcome' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        plannedOutcomeId = Long.parseLong(req.getParameter("id"));
        try {
            planedOutcomeService.delete(plannedOutcomeId);
            resp.sendRedirect(req.getContextPath() + "/planned-outcome-dashboard");
            LOG.info("Planned outcome is deleted. User is redirected to 'Planned outcome Dashboard' Page");
        } catch (RuntimeException e) {
            LOG.info("Error: " + e.getMessage());
            req.setAttribute("error", ErrorMessage.FAIL_TO_DELETE_A_PLANED_OUTCOME.getErrorMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.PLANNED_OUTCOME_DELETE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}
