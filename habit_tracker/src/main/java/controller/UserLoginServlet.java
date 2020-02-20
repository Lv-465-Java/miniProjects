package controller;

import constant.JspUrl;
import constant.ServletUrl;
import dto.CookieDto;
import dto.UserDto;
import service.UserSignupService;
import service.implementation.UserSignupServiceImpl;
import util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(ServletUrl.LOGIN_URL)
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserSignupService userService;

    public UserLoginServlet() {

        // TODO Auto-generated constructor stub
        userService = new UserSignupServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher(JspUrl.LOGIN_JSP.toString());
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = new UserDto(
                request.getParameter("login"),
                request.getParameter("password"));
        Map<String, String> messages = userService.login_errors(userDto);
        if (messages.isEmpty()) {
            UserDto user = null;
            try {
                user = userService.isValid(userDto);
            } catch (RuntimeException e) {
                messages.put("password", "Password is incorrect");
                request.setAttribute("messages", messages);
                getServletConfig()
                        .getServletContext()
                        .getRequestDispatcher(JspUrl.LOGIN_JSP.toString())
                        .forward(request, response);
            }
            if (user != null) {
                HttpSession session = request.getSession(true);
                ServletUtils.storeLoginedUser(response, session, new CookieDto(user.getId(),
                        userDto.getLogin(),
                        userDto.getPassword()));
                request.getRequestDispatcher(JspUrl.HOME_JSP.toString()).include(request, response);
                response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);

            }
        } else {
            request.setAttribute("messages", messages);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.LOGIN_JSP.toString())
                    .forward(request, response);
        }
    }
}






