package controller;


import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import dto.UserDto;
import service.UserSignupService;
import service.implementation.UserService;
import service.implementation.UserSignupServiceImpl;
import util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(ServletUrl.EDIT_USER_URL)
public class EditUserServlet extends HttpServlet {
    private long id;
    private String user_name;
    private UserSignupService userSignupService;
    private UserService userService;

    @Override
    public void init() {
        userSignupService = new UserSignupServiceImpl();
        userService = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieDto cookieDto = ServletUtils.getLoginedUser(req.getSession());
        user_name = userService.getName(cookieDto.getId());
        req.setAttribute("name", user_name);
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher(JspUrl.EDIT_USER_JSP.toString());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieDto cookieDto = ServletUtils.getLoginedUser(req.getSession());
        UserDto userDto = new UserDto(cookieDto.getId(), req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("password"));
        Map<String, String> errors = userSignupService.update(userDto);
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher(JspUrl.EDIT_USER_JSP.toString()).forward(req, resp);
            resp.sendRedirect(req.getContextPath() + ServletUrl.EDIT_USER_URL);
        } else {
            req.getRequestDispatcher(JspUrl.HOME_JSP.toString()).include(req, resp);
            resp.sendRedirect(req.getContextPath() + ServletUrl.HOME_URL);
        }

    }

}
