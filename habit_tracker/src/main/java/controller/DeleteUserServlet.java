package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import service.implementation.UserService;
import util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(ServletUrl.DELETE_USER_URL)
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(JspUrl.DELETE_USER_JSP.toString());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieDto cookieDto = ServletUtils.getLoginedUser(req.getSession());
        try {
            if (userService.delete_by_id(cookieDto.getId())) {
                ServletUtils.deleteUserCookie(req, resp);
                ServletUtils.destroySession(req, resp);
                req.getRequestDispatcher(JspUrl.LOGIN_JSP.toString()).include(req, resp);
                resp.sendRedirect(req.getContextPath() + ServletUrl.LOGIN_URL);
            }
        } catch (RuntimeException e) {
            req.setAttribute("error", e.getMessage());

            req.getRequestDispatcher(JspUrl.LOGIN_JSP.toString()).include(req, resp);
            resp.sendRedirect(req.getContextPath() + ServletUrl.LOGIN_URL);
        }
    }
}
