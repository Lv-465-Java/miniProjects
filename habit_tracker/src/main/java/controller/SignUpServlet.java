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

/**
 * Class processes requests for "/signup" url
 */
@WebServlet(ServletUrl.SIGNUP_URL)
public class SignUpServlet extends HttpServlet {
    private UserSignupService userService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() throws ServletException {
        userService = new UserSignupServiceImpl();
    }

    /**
     * Method processes GET request for /signup url
     * and returns /signup.jsp form.
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher(JspUrl.SIGNUP_JSP.toString());
        dispatcher.forward(request, response);
    }

    /**
     * Method processes POST request for /signup url
     *
     * @param request  HTTP request object
     * @param response HTTP response object
     * @throws IOException
     * @throws ServletException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = new UserDto(
                request.getParameter("name"),
                request.getParameter("login"),
                request.getParameter("password"));
        try {
            Map<String, String> errors = userService.create_user(userDto);
            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                request.getRequestDispatcher(JspUrl.SIGNUP_JSP.toString()).forward(request, response);
            } else {
                UserDto created_user = userService.isValid(userDto);
                HttpSession session = request.getSession(true);
                ServletUtils.storeLoginedUser(response, session, new CookieDto(created_user.getId(),
                        userDto.getLogin(),
                        userDto.getPassword()));
                request.getRequestDispatcher(JspUrl.HOME_JSP.toString()).include(request, response);
                response.sendRedirect(request.getContextPath() + ServletUrl.HOME_URL);
            }

        } catch (RuntimeException e) {
            request.setAttribute("error", e.toString());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JspUrl.SIGNUP_JSP.toString())
                    .forward(request, response);
        }
    }

}
