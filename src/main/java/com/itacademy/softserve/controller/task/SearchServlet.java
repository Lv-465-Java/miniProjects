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

/**
 * Class processes requests for /search-task url.
 */
@WebServlet(ServletUrl.SEARCH_TASK)
public class SearchServlet extends HttpServlet {
    private Pagination pagination;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        pagination = new Pagination();
    }

    /**
     * Method processes GET request for /search-task url
     * and returns filled search.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        pagination.searchPagination(req, resp);
    }

    /**
     * Method processes POST request for /search-task url
     * gets parameter from request object,
     * saves regex in session.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
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
