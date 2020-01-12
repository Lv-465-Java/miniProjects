package com.softserve.servlet.planedOutcome;

import com.softserve.constant.View;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.CategoryServiceImpl;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
import com.softserve.service.implementation.RecordServiceImpl;
import com.softserve.servlet.record.EditRecordServlet;
import com.softserve.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/edit-planned-outcome"})
public class EditPlanedOutcomeServlet extends HttpServlet {
    private CategoryServiceImpl categoryService;
    private PlanedOutcomeServiceImpl planedOutcomeService;
    private UserSession userSession;
    private Logger LOG = LoggerFactory.getLogger(EditRecordServlet.class);
    private UserDTO currentSessionUser;
    private Long plannedOutcomeId;

    @Override
    public void init() {
        this.userSession = new UserSession();
        this.planedOutcomeService = new PlanedOutcomeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentSessionUser = userSession.retrieveUserIdFromSession(req);
        plannedOutcomeId = Long.parseLong(req.getParameter("editPlannedOutcomeButton"));
        req.setAttribute("plannedOutcome", planedOutcomeService.getById(plannedOutcomeId));
        req.setAttribute("categories", categoryService.getAllByUserIdAndFinancialTypeId(currentSessionUser.getId()));
        req.getRequestDispatcher(View.PLANNED_OUTCOME_EDIT_PAGE.getViewUrl()).include(req, resp);

        LOG.info("'Edit Planned Outcome' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}