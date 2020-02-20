package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import dto.HabitDto;
import dto.UserDto;
import service.implementation.UserService;
import util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(ServletUrl.HOME_URL)
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String user_name;
    private UserService userService;


    @Override
    public void init() throws ServletException {

        userService = new UserService();

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CookieDto cookieDto = ServletUtils.getLoginedUser(request.getSession());
        user_name = userService.getName(cookieDto.getId());
        request.setAttribute("name", user_name);
        try {
            List<HabitDto> all_habits = userService.get_all_habit(new UserDto(cookieDto.getId(), user_name,
                    cookieDto.getLogin()));
            request.setAttribute("all_amount", userService.get_amount_of_all_do_date(all_habits));
            request.setAttribute("all_habits", all_habits);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.HOME_JSP.toString())
                    .forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }

    }

}

