package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(ServletUrl.LOGOUT_URL)
public class LogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CookieDto cookieDto = ServletUtils.getLoginedUser(request.getSession());
        ServletUtils.destroySession(request, response);
        ServletUtils.deleteUserCookie(request, response);
        request.getRequestDispatcher(JspUrl.LOGIN_JSP.toString()).include(request, response);
        response.sendRedirect(request.getContextPath() + ServletUrl.LOGIN_URL);


    }

}
