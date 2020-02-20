package servlet.trip;

import service.TripService;
import service.impl.TripServiceImpl;
import servlet.JSPFILES;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for "/deleteTrip"  url
 */
@WebServlet("/deleteTrip")
public class DeleteTripServlet extends HttpServlet {

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

        Long id=Long.parseLong(request.getParameter("tripId"));
        if(!tripService.deleteById(id)){

            request.setAttribute("errorString", "Error when delete trip");

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.TRIP_LIST.getPath());
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/tripList");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
