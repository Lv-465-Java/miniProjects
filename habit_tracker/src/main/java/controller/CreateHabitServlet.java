package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import dto.CreateHabitDto;
import service.implementation.HabitService;
import util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(ServletUrl.CREATE_HABIT_URL)
public class CreateHabitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HabitService habitService;

    @Override
    public void init() {
        habitService = new HabitService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher(JspUrl.CREATE_HABIT_JSP.toString());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CookieDto cookieDto = ServletUtils.getLoginedUser(req.getSession());
            CreateHabitDto createHabitDto = new CreateHabitDto(
                    cookieDto.getId(),
                    req.getParameter("name"),
                    req.getParameter("description"));
            Map<String, String> error = habitService.create_habit(createHabitDto);
            if (error.isEmpty()) {
                req.getRequestDispatcher(JspUrl.HOME_JSP.toString()).include(req, resp);
                resp.sendRedirect(req.getContextPath() + ServletUrl.HOME_URL);
            } else {
                req.setAttribute("errors", error);
                req.getRequestDispatcher(JspUrl.CREATE_HABIT_JSP.toString()).forward(req, resp);
                resp.sendRedirect(req.getContextPath() + ServletUrl.CREATE_HABIT_URL);

            }
        } catch (RuntimeException e) {
            req.setAttribute("error", e.getMessage());
            resp.sendRedirect(req.getContextPath() + ServletUrl.HOME_URL);
        }
    }
}
