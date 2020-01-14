package com.blog.controller.user;

import com.blog.constant.Parameter;
import com.blog.controller.ViewUrls;
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
        req.setCharacterEncoding("UTF-8");
        if (userService.isAlreadyExists(req.getParameter(Parameter.USERNAME))){
            System.out.println(req.getParameter(Parameter.USERNAME));
            req.setAttribute("error", "User already exist");
            req.getRequestDispatcher(ViewUrls.USER_PROFILE.toString()).forward(req, resp);
        }else {
            UserDto userDto = new UserDto(
                    req.getParameter(Parameter.USERNAME),
                    req.getParameter(Parameter.PASSWORD),
                    req.getParameter(Parameter.FIRST_NAME),
                    req.getParameter(Parameter.LAST_NAME)
            );
            userService.update(userDto);

            resp.sendRedirect(req.getContextPath() + "");
        }
    }
}
