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
 * Class processes requests for /register url.
 */
@WebServlet(ServletUrl.REGISTER_URL)
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    /**
     * Method processes GET request for /register url
     * and returns register.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.REGISTER_JSP).include(req, resp);
    }

    /**
     * Method processes POST request for /register url
     * gets parameters from request object,
     * saves new user.
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
            userService.save(userDto);
            SessionManager.createSession(userDto, request, response);
            response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
        } catch (RuntimeException e) {
            request.setAttribute(ErrorMessage.ERROR.toString(), ErrorMessage.SUCH_USER_EXIST.toString());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.REGISTER_JSP)
                    .forward(request, response);
        }
    }
}