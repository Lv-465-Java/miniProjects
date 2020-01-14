package com.softserve.servlet.planedOutcome;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.PlanedOutcomeDTO;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.CategoryServiceImpl;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
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
import java.time.LocalDate;

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
        this.planedOutcomeService = new PlanedOutcomeServiceImpl();
        this.categoryService = new CategoryServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentSessionUser = userSession.retrieveUserIdFromSession(req);
        plannedOutcomeId = Long.parseLong(req.getParameter("id"));
        req.setAttribute("plannedOutcome", planedOutcomeService.getById(plannedOutcomeId));
        req.setAttribute("categories", categoryService.getAllByUserIdAndFinancialTypeId(currentSessionUser.getId()));
        req.setAttribute("date", planedOutcomeService.getById(plannedOutcomeId).getDate());
        req.getRequestDispatcher(View.PLANNED_OUTCOME_EDIT_PAGE.getViewUrl()).include(req, resp);

        LOG.info("'Edit Planned Outcome' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentSessionUser = userSession.retrieveUserIdFromSession(req);
        plannedOutcomeId = Long.parseLong(req.getParameter(ServletResponseParameter.PLANNED_OUTCOME_ID.getServletParameter()));
        Double sum = Double.parseDouble(req.getParameter(ServletResponseParameter.SUM.getServletParameter()));
        LocalDate date = LocalDate.parse(req.getParameter(ServletResponseParameter.DATE.getServletParameter()));
        String note = req.getParameter(ServletResponseParameter.NOTE.getServletParameter());
        Long categoryId = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_ID.getServletParameter()));

        PlanedOutcomeDTO planedOutcomeDTO = PlanedOutcomeDTO.Builder.aPlanedOutcomeDTO()
                .withId(plannedOutcomeId)
                .withSum(sum)
                .withDate(date)
                .withNote(note)
                .withUserId(currentSessionUser.getId())
                .withCategoryId(categoryId)
                .build();

        try {
            planedOutcomeService.update(plannedOutcomeId, planedOutcomeDTO);
            resp.sendRedirect(req.getContextPath() + "/planned-outcome-dashboard");
            LOG.info("Planned outcome is updated. User is redirected to 'Planned outcome Dashboard' Page");
        } catch (NotCompletedActionException e) {
            doGet(req, resp);
            LOG.info("Error: " + e.getMessage());
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.PLANNED_OUTCOME_EDIT_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }


}