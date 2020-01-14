package servlet.user;

import dto.UserDto;
import entity.User;
import exception.NotFoundException;
import mapper.UserMapper;
import service.UserService;
import service.impl.DBInitializerService;
import service.impl.UserServiceImpl;
import servlet.JSPFILES;
import utils.SessionCookieManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class processes requests for "/registration"  url
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{

    private  UserService userService;

        /**
         * Method initializes required resources
         */
        @Override
        public void init() {
            userService=new UserServiceImpl();
        }

        /**
         * Method processes GET request for /registration url
         * and returns /registration.jsp
         *
         * @param req  HTTP request object
         * @param resp HTTP response object
         * @throws ServletException
         * @throws IOException
         */
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(JSPFILES.REGISTRATION_JSP.getPath());
            requestDispatcher.forward(req, resp);
        }

        /**
         * Method processes POST request for /registration url
         *
         * @param req HTTP request object
         * @param resp HTTP response object
         * @throws IOException
         * @throws ServletException
         */
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            if (DBInitializerService.isFirst()) {

//                resp.sendRedirect(req.getContextPath()
//                        + "/initDB");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/initDB");
                requestDispatcher.include(req, resp);
            }

                String firstName = req.getParameter("first_name");
                String lastName = req.getParameter("last_name");
                String username = req.getParameter("username");
                String email = req.getParameter("email");
                String password = req.getParameter("password");

                User user = User.builder().firstName(firstName).lastName(lastName).username(username)
                        .email(email).password(password).build();

//                HttpSession session = req.getSession();
//
//                UserDto userDto = UserMapper.getUserDto(user);
//                SessionCookieManager.storeLoginedUser(session, userDto);
//                SessionCookieManager.storeUserCookie(resp,userDto);


                try {
                    userService.insert(user);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath());
                    requestDispatcher.forward(req, resp);
                } catch (NotFoundException e) {
                    req.setAttribute("errors", e.getMessage());
                    req.getRequestDispatcher(JSPFILES.REGISTRATION_JSP.getPath()).forward(req, resp);
                }
            }
        }
