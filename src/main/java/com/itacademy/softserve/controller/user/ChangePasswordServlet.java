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
 * Class processes requests for /change-password url.
 */
@WebServlet(ServletUrl.CHANGE_PASSWORD)
public class ChangePasswordServlet extends HttpServlet {
    private UserService userService;

    /**
     * Method initializes required resources.
     */
    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    /**
     * Method processes GET request for /change-password url
     * and returns change-password.jsp.
     *
     * @param req  HTTP request object
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JspUrl.CHANGE_PASSWORD_JSP).include(req, resp);
    }

    /**
     * Method processes POST request for /change-password url
     * changes password and updates session
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
            userService.changePassword(request);
            SessionManager.changeSessionAttributeNewPassword(request);
            response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
        } catch (RuntimeException e) {
            request.setAttribute(ErrorMessage.ERROR.toString(), e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.CHANGE_PASSWORD_JSP)
                    .forward(request, response);
        }
    }
}