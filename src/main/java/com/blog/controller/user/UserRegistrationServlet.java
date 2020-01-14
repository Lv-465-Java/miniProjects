package com.blog.controller.user;

import com.blog.constant.Message;
import com.blog.constant.Parameter;
import com.blog.controller.ControllerUrls;
import com.blog.controller.ViewUrls;
import com.blog.dto.UserDto;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class UserRegistrationServlet extends HttpServlet {

    private UserService userService;

    public UserRegistrationServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.REGISTRATION.toString())
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (userService.isAlreadyExists(req.getParameter(Parameter.USERNAME))){
            System.out.println(req.getParameter(Parameter.USERNAME));
            req.setAttribute("error", Message.ALREADY_EXIST);
            req.getRequestDispatcher(ViewUrls.REGISTRATION.toString()).forward(req, resp);
        }else {
            UserDto userDto = new UserDto(
                    req.getParameter(Parameter.USERNAME),
                    req.getParameter(Parameter.PASSWORD),
                    req.getParameter(Parameter.FIRST_NAME),
                    req.getParameter(Parameter.LAST_NAME)
            );
            userService.save(userDto);

            resp.sendRedirect(req.getContextPath() + ControllerUrls.HOME_PAGE.toString());
        }
    }
}
