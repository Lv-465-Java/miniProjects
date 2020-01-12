package servlet;

import dto.UserDto;
import service.impl.DBInitializerService;
import utils.SessionCookieManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet implementation class Main
 */
@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;
       // private MainService mainService;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public MainPageServlet() {
            super();
           // mainService = new MainService();
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            boolean isActiveSession = true;
//            HttpSession session=SessionCookieManager.getSession(request); // Do not Create new Session
//            Cookie idSessionCookie = SessionCookieManager.getIdSessionInCookie(request);
//
//            isActiveSession = session != null
//                    && SessionCookieManager.getLoginedUser(session) != null
//                    && SessionCookieManager.getLoginedUser(session).getUsername() != null
//                    && idSessionCookie != null;
//            isActiveSession = isActiveSession
//                    && (idSessionCookie.getValue().equals(session.getId()));
//
//
//            if (!isActiveSession) {
//                getServletConfig()
//                        .getServletContext()
//                        .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath())
//                        .forward(request, response);
//            } else {
//
//                request.setAttribute("info", "LOGINED");
//
//                getServletConfig()
//                        .getServletContext()
//                        .getRequestDispatcher(JSPFILES.MAIN_PAGE.getPath())
//                        .forward(request, response);
//            }
            HttpSession session=SessionCookieManager.getSession(request);
            UserDto userDto=SessionCookieManager.getLoginedUser(session);

            if (userDto==null){
                getServletConfig()
                        .getServletContext()
                        .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath())
                        .forward(request, response);
                return;
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
