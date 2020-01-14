package servlet.trip;

import dto.TripDto;
import exception.NotFoundException;
import service.TripService;
import service.impl.TripServiceImpl;
import servlet.JSPFILES;
import utils.SessionCookieManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class processes requests for "/getUserTrip"  url
 */
@WebServlet("/getUserTrip")
public class GetUserTripServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TripService tripService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        tripService=new TripServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession();
        Long userId= SessionCookieManager.getLoginedUser(session).getId();

        try {
            List<TripDto> list = tripService.getByUserId(userId);

            request.setAttribute("tripList", list);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.TRIP_LIST.getPath());
            dispatcher.forward(request, response);

        } catch (NotFoundException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath());
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
