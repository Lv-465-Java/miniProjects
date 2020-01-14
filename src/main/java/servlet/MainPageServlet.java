package servlet;

import dto.UserDto;
import service.impl.DBInitializerService;
import utils.SessionCookieManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Class processes requests for "/mainPage"  url
 */
@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public MainPageServlet() {
            super();
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpSession session=request.getSession();
            UserDto userDto=SessionCookieManager.getLoginedUser(session);
            String cookie=SessionCookieManager.getUserNameInCookie(request);////////

            if (userDto==null){
                getServletConfig()
                        .getServletContext()
                        .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath())
                        .forward(request, response);
            } else {
                request.setAttribute("userDto",userDto);
                getServletConfig()
                        .getServletContext()
                        .getRequestDispatcher(JSPFILES.MAIN_PAGE.getPath())
                        .forward(request, response);
            }
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);

    }
}
