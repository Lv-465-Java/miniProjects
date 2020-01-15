package com.softserve.util;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.servlet.record.RecordDashboardServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterUtil {

    public List<Object> filterParser(HttpServletRequest req) {
        List<Object> parameters = new ArrayList<>();
        if (req.getParameter(ServletResponseParameter.FINANCIAL_TYPE_ID.getServletParameter()) != null) {
            Long financialTypeId = Long.parseLong(req.getParameter(ServletResponseParameter.FINANCIAL_TYPE_ID.getServletParameter()));
            parameters.add(financialTypeId);
        }
        if (!req.getParameter("fromDate").isEmpty()) {
            LocalDate from = LocalDate.parse(req.getParameter("fromDate"));
            parameters.add(from);
        }
        if (!req.getParameter("toDate").isEmpty()) {
            LocalDate to = LocalDate.parse(req.getParameter("toDate"));
            parameters.add(to);
        }
        return parameters;
    }
}
