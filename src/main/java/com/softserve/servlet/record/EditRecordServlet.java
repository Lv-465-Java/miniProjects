package com.softserve.servlet.record;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.RecordDTO;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NotCompletedActionException;
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
import java.time.LocalDate;

@WebServlet(value = {"/edit-record"})
public class EditRecordServlet extends HttpServlet {
    private RecordServiceImpl recordService;
    private CategoryServiceImpl categoryService;
    private PlanedOutcomeServiceImpl planedOutcomeService;
    private UserSession userSession;
    private Logger LOG = LoggerFactory.getLogger(EditRecordServlet.class);
    private UserDTO currentSessionUser;
    private Long recordId;

    @Override
    public void init() {
        this.recordService = new RecordServiceImpl();
        this.categoryService = new CategoryServiceImpl();
        this.planedOutcomeService = new PlanedOutcomeServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentSessionUser = userSession.retrieveUserIdFromSession(req);
        recordId = Long.parseLong(req.getParameter("id"));
        req.setAttribute("record", recordService.getById(recordId));
        req.setAttribute("categories", categoryService.getAllByUserId(currentSessionUser.getId()));
        req.setAttribute("financialTypes", recordService.getTypes());
        req.setAttribute("plannedOutcomes", planedOutcomeService.getAllByUserId(currentSessionUser.getId()));
        req.getRequestDispatcher(View.RECORD_EDIT_PAGE.getViewUrl()).include(req, resp);

        LOG.info("'Edit Record' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentSessionUser = userSession.retrieveUserIdFromSession(req);

        recordId = Long.parseLong(req.getParameter(ServletResponseParameter.RECORD_ID.getServletParameter()));
        Double sum = Double.parseDouble(req.getParameter(ServletResponseParameter.SUM.getServletParameter()));
        LocalDate date = LocalDate.parse(req.getParameter(ServletResponseParameter.DATE.getServletParameter()));
        String note = req.getParameter(ServletResponseParameter.NOTE.getServletParameter());
        Long financialTypeId = Long.parseLong(req.getParameter(ServletResponseParameter.FINANCIAL_TYPE_ID.getServletParameter()));
        Long categoryId = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_ID.getServletParameter()));
        Long plannedOutcomeId = null;

        if (req.getParameter(ServletResponseParameter.PLANNED_OUTCOME_ID.getServletParameter()) != null) {
            plannedOutcomeId = Long.parseLong(req.getParameter(ServletResponseParameter.PLANNED_OUTCOME_ID.getServletParameter()));
        }

        RecordDTO recordDTO = RecordDTO.Builder.aRecordDTO()
                .withId(recordId)
                .withSum(sum)
                .withDate(date)
                .withNote(note)
                .withUserId(currentSessionUser.getId())
                .withFinancialTypeId(financialTypeId)
                .withCategoryId(categoryId)
                .withPlanedOutcomeId(plannedOutcomeId)
                .build();
        try {
            recordService.update(recordId, recordDTO);
            resp.sendRedirect(req.getContextPath() + "/record-dashboard");
            LOG.info("Record is updated. User is redirected to 'Record Dashboard' Page");
        } catch (NotCompletedActionException e) {
            LOG.info("Error: " + e.getMessage());
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.RECORD_EDIT_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}