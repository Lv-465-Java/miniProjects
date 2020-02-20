package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import service.implementation.HabitService;
import util.PathParser;
import util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(ServletUrl.DELETE_HABIT_URL)
public class DeleteHabitServlet extends HttpServlet {
    private long habit_id;
    private HabitService habitService;

    @Override
    public void init() {
        habitService = new HabitService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        habit_id = PathParser.getPathVariable(request.getPathInfo());
        request.setAttribute("id", habit_id);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(JspUrl.DELETE_HABIT_JSP.toString());
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CookieDto cookieDto = ServletUtils.getLoginedUser(request.getSession());
        try {
            habitService.delete_habit(cookieDto.getId(), habit_id);
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getContextPath() + ServletUrl.DELETE_HABIT_URL);
        }
        request.getRequestDispatcher(JspUrl.HOME_JSP.toString()).include(request, response);
        response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
    }
}
