package servlet;

import dto.UserDto;
import utils.SessionCookieManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/personalCabinet")
public class PersonalCabinetServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalCabinetServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session= SessionCookieManager.getSession(request);
        UserDto userDto=SessionCookieManager.getLoginedUser(session);

//        if (userDto==null){
//            getServletConfig()
//                    .getServletContext()
//                    .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath())
//                    .forward(request, response);
//            return;
//        } else {
            request.setAttribute("userDto",userDto);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(JSPFILES.PERSONAL_CABINET.getPath())
                    .forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
