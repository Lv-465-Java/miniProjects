package com.itacademy.softserve.controller.user;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.service.UserService;
import com.itacademy.softserve.service.impl.UserServiceImpl;
import com.itacademy.softserve.util.SessionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for /change-username url.
 */
@WebServlet(ServletUrl.CHANGE_USERNAME)
public class ChangeUsernameServlet extends HttpServlet {
    private UserService userService;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    /**
     * Method processes GET request for /change-username url
     * and returns change-username.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.CHANGE_USERNAME_JSP).include(req, resp);
    }

    /**
     * Method processes POST request for /change-username url
     * changes user name and updates session
     * parameter userDto.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            userService.changeUsername(request);
            SessionManager.changeSessionAttributeNewUserName(request);
            response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
        } catch (RuntimeException e) {
            request.setAttribute(ErrorMessage.ERROR.toString(), e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.CHANGE_USERNAME_JSP)
                    .forward(request, response);
        }

    }
}