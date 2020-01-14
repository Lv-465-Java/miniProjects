package com.blog.controller.user;

import com.blog.constant.Message;
import com.blog.constant.Parameter;
import com.blog.controller.ControllerUrls;
import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.dto.LoginDto;
import com.blog.dto.UserDto;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile/update")
public class UserProfileUpdateServlet extends HttpServlet {

    private UserService userService;

    public UserProfileUpdateServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("session", Security.checkSession(req, resp));
        HttpSession session = req.getSession(false);
        LoginDto loginDto = (LoginDto) session.getAttribute("loginDto");
        req.setAttribute("user", userService.findUserByUsername(loginDto.getUsername()));
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.USER_UPDATE_PROFILE.toString())
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UserDto userDto = new UserDto(
                    Long.parseLong(req.getParameter(Parameter.USER_ID)),
                    req.getParameter(Parameter.USERNAME),
                    req.getParameter(Parameter.PASSWORD),
                    req.getParameter(Parameter.FIRST_NAME),
                    req.getParameter(Parameter.LAST_NAME),
                    req.getParameter(Parameter.ROLE_ID)
            );
            userService.update(userDto);
            resp.sendRedirect(req.getContextPath() + ControllerUrls.PROFILE.toString());

    }
}
