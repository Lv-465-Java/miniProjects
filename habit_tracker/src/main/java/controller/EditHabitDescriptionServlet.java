package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.AllHabitInfoDto;
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

@WebServlet(ServletUrl.EDIT_HABIT_DESCRIPTION_URL)
public class EditHabitDescriptionServlet extends HttpServlet {
    private long habit_id;
    private HabitService habitService;

    @Override
    public void init() throws ServletException {

        habitService = new HabitService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        habit_id = PathParser.getPathVariable(req.getPathInfo());
        CookieDto cookieDto = ServletUtils.getLoginedUser(req.getSession());
        AllHabitInfoDto allHabitInfoDto = habitService.getAllInfo(cookieDto.getId(), habit_id);
        req.setAttribute("habit", allHabitInfoDto);
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher(JspUrl.EDIT_HABIT_DESCRIPTION_JSP.toString());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        CookieDto cookieDto = ServletUtils.getLoginedUser(req.getSession());
        try {
            habitService.editDescription(description, cookieDto.getId(), habit_id);
            req.getRequestDispatcher(JspUrl.HABIT_JSP.toString()).include(req, resp);
            resp.sendRedirect(req.getContextPath() + "/habit/" + habit_id);
        } catch (RuntimeException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher(JspUrl.EDIT_HABIT_DESCRIPTION_JSP.toString()).include(req, resp);
            resp.sendRedirect(req.getContextPath() + "/edit_habit_description/" + habit_id);
        }
    }
}
