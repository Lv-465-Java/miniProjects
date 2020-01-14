package servlet;

import dto.UserDto;
import dto.UserLoginDto;

import entity.Role;
import entity.User;
import service.impl.DBInitializerService;
import service.impl.UserLoginService;
import utils.MD5HashPassword;
import utils.SessionCookieManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class processes requests for "/login" and ""  url
 */
@WebServlet(value ={"/login",""})
public class LoginServlet  extends HttpServlet {

    private final UserLoginService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet(){
        super();
        userService=new UserLoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath());

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

        if (DBInitializerService.isFirst()) {

            response.sendRedirect(request.getContextPath()
                    + "/initDB");
        } else {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserLoginDto userLoginDto = new UserLoginDto(username, MD5HashPassword.hashPassword(password));

            if (userService.isValid(userLoginDto) & userService.isUsernameUnique(username)) {

                HttpSession session = request.getSession();

                UserDto userDto = userService.getUserDto(userLoginDto);
                SessionCookieManager.storeLoginedUser(session, userDto);
                SessionCookieManager.storeUserCookie(response,userDto);

                if(userDto.getUserRole().toString().equalsIgnoreCase((Role.ADMIN).toString())){
                    response.sendRedirect(request.getContextPath() + "/adminPage");
                } else {
                    response.sendRedirect(request.getContextPath() + "/mainPage");
                }

            } else {

                request.setAttribute("error", "Username or password invalid");
                request.setAttribute("user", userLoginDto);


                RequestDispatcher dispatcher
                        = this.getServletContext().getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath());

                dispatcher.forward(request, response);
            }
        }
    }
}
