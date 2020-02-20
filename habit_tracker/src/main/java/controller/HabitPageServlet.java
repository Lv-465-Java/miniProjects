package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.AllHabitInfoDto;
import dto.CookieDto;
import dto.HabitDto;
import dto.UserDto;
import service.implementation.HabitService;
import service.implementation.UserService;
import util.PathParser;
import util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(ServletUrl.HABIT_URL)
public class HabitPageServlet extends HttpServlet {
    private HabitService habitService;
    private UserService userService;


    @Override
    public void init() {

        habitService = new HabitService();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = PathParser.getPathVariable(req.getPathInfo());
        req.setAttribute("id", id);
        CookieDto cookieDto = ServletUtils.getLoginedUser(req.getSession());
        String user_name = userService.getName(cookieDto.getId());
        req.setAttribute("name", user_name);
        List<HabitDto> all_habits = null;
        try {
            all_habits = userService.get_all_habit(new UserDto(cookieDto.getId(), user_name,
                    cookieDto.getLogin(),
                    cookieDto.getPassword()));
            req.setAttribute("all_habits", all_habits);
        } catch (RuntimeException e) {
            req.setAttribute("error", e.getStackTrace());
        }
        AllHabitInfoDto allHabitInfoDto = habitService.getAllInfo(cookieDto.getId(), id);
        req.setAttribute("habit", allHabitInfoDto);
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher(JspUrl.HABIT_JSP.toString());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
