package servlet.trip;

import db.ConnectionManager;
import service.TripService;
import service.impl.TripServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for "/deleteTripByDepartureDay"  url
 */
public class DeleteTripByDepartureDayServlet extends HttpServlet {

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

        //String errorString = null;

        Long id=Long.parseLong(request.getParameter("id"));
        if(!tripService.deleteById(id)){
            // If has an error, redirecte to the error page.
            request.setAttribute("errorString", "Error when delete user");

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteTripError.jsp");
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
