package com.blog.controller.user;

import com.blog.constant.Message;
import com.blog.constant.Parameter;
import com.blog.controller.ControllerUrls;
import com.blog.controller.ViewUrls;
import com.blog.dto.LoginDto;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private UserService userService;

    public UserLoginServlet() {
        this.userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.LOGIN.toString())
                .forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDto loginDto = new LoginDto(
                req.getParameter(Parameter.USERNAME.toString()),
                req.getParameter(Parameter.PASSWORD.toString()));
        if (userService.isValid(loginDto)){
            HttpSession session = req.getSession(true);
            session.setAttribute("loginDto", loginDto);
            session.setMaxInactiveInterval(3000);
            Cookie cookie = new Cookie("id_session", session.getId());
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + ControllerUrls.HOME_PAGE.toString());
        }else {
            req.setAttribute("error", Message.BAD_LOGIN_PASSWORD);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.LOGIN.toString())
                    .forward(req, resp);
        }
    }
}
