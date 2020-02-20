package controller;


import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import service.implementation.HabitService;
import util.PathParser;
import util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(ServletUrl.DO_HABIT_URL)
public class DoHabitServlet extends HttpServlet {
    private HabitService habitService;
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        habitService = new HabitService();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long habit_id = PathParser.getPathVariable(request.getPathInfo());
        CookieDto cookieDto = ServletUtils.getLoginedUser(request.getSession());
        try {
            habitService.do_habit(cookieDto.getId(), habit_id);
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }
        request.getRequestDispatcher(JspUrl.HOME_JSP.toString()).include(request, response);
        response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);

    }
}

