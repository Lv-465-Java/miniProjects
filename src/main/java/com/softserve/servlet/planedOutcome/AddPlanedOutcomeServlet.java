package com.softserve.servlet.planedOutcome;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.PlanedOutcomeDTO;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NotCompletedActionException;
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
import java.time.LocalDate;

@WebServlet(value = {"/add-planned-outcome"})
public class AddPlanedOutcomeServlet extends HttpServlet {
    private CategoryServiceImpl categoryService;
    private PlanedOutcomeServiceImpl planedOutcomeService;
    private UserSession userSession;
    private Logger LOG = LoggerFactory.getLogger(AddPlanedOutcomeServlet.class);
    private UserDTO currentSessionUser;

    @Override
    public void init() {
        this.categoryService = new CategoryServiceImpl();
        this.planedOutcomeService = new PlanedOutcomeServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentSessionUser = userSession.retrieveUserIdFromSession(req);
        req.setAttribute("categories", categoryService.getAllByUserIdAndFinancialTypeId(currentSessionUser.getId()));
        req.getRequestDispatcher(View.PLANNED_OUTCOME_ADD_PAGE.getViewUrl()).include(req, resp);

        LOG.info("'Add new Planned outcome' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentSessionUser = userSession.retrieveUserIdFromSession(req);
        try {
            Double sum = Double.parseDouble(req.getParameter(ServletResponseParameter.SUM.getServletParameter()));
            LocalDate date = LocalDate.parse(req.getParameter(ServletResponseParameter.DATE.getServletParameter()));
            String note = req.getParameter(ServletResponseParameter.NOTE.getServletParameter());
            Long categoryId = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_ID.getServletParameter()));

            PlanedOutcomeDTO planedOutcomeDTO = PlanedOutcomeDTO.Builder.aPlanedOutcomeDTO()
                    .withSum(sum)
                    .withDate(date)
                    .withNote(note)
                    .withUserId(currentSessionUser.getId())
                    .withCategoryId(categoryId)
                    .build();


            planedOutcomeService.create(planedOutcomeDTO);
            resp.sendRedirect(req.getContextPath() + "/planned-outcome-dashboard");
            LOG.info("New Planned Outcome is created. User is redirected to 'Planned outcome Dashboard' Page");
        } catch (NotCompletedActionException | NumberFormatException e) {
            doGet(req, resp);
            LOG.info("Error: " + e.getMessage());
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.PLANNED_OUTCOME_ADD_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}