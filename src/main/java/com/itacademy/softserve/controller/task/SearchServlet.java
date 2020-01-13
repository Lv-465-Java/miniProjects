package com.itacademy.softserve.controller.task;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.util.Pagination;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(ServletUrl.SEARCH_TASK)
public class SearchServlet extends HttpServlet {
    private Pagination pagination;

    @Override
    public void init() {
        pagination = new Pagination();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        pagination.searchPagination(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String regex = request.getParameter("regex");
        session.setAttribute("regex", regex);
        if (regex != null && !regex.isEmpty()) {
            doGet(request, response);
        } else {
            request.setAttribute(ErrorMessage.ERROR.toString(), ErrorMessage.EMPTY_SEARCH.toString());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.HOME_JSP)
                    .forward(request, response);
        }
    }
}
