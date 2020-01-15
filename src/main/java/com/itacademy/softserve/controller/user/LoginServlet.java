package com.itacademy.softserve.controller.user;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.JspUrl;
import com.itacademy.softserve.constant.ServletUrl;
import com.itacademy.softserve.dto.UserDto;
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
 * Class processes requests for /login url.
 */
@WebServlet(ServletUrl.LOGIN_URL)
public class LoginServlet extends HttpServlet {
    private UserService userService;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    /**
     * Method processes GET request for /login url
     * and returns login.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.LOGIN_JSP).include(req, resp);
    }

    /**
     * Method processes POST request for /login url
     * gets parameter from request object,
     * determines if user enter correct name and password.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDto userDto = new UserDto(request.getParameter("name"), request.getParameter("password"));
        try {
            userService.login(userDto);
            SessionManager.createSession(userDto, request, response);
            response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
        } catch (RuntimeException e) {
            request.setAttribute(ErrorMessage.ERROR.toString(), ErrorMessage.BAD_LOGIN_OR_PASSWORD.toString());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.LOGIN_JSP)
                    .forward(request, response);
        }
    }
}