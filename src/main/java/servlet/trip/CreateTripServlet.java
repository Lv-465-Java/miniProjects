package servlet.trip;

import dto.TripDto;
import entity.Transport;
import entity.Trip;
import exception.NotFoundException;
import service.TransportService;
import service.TripPlaceService;
import service.TripService;
import service.impl.*;
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
import java.time.LocalDate;
import java.util.List;

/**
 * Class processes requests for "/createTrip"  url
 */
@WebServlet("/createTrip")

public class CreateTripServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TripService tripService;
    private TransportService transportService;
    private TripPlaceService tripPlaceService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        tripService = new TripServiceImpl();
        transportService = new TransportServiceImpl();
        tripPlaceService = new TripPlaceServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            List<Transport> transportList = transportService.getAll();

            request.setAttribute("transportList", transportList);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_TRIP.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e) {
            request.setAttribute("error", "Please try again later");
            response.sendRedirect(request.getContextPath() + "/personalCabinet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        LocalDate departureDay = LocalDate.parse(request.getParameter("dep_day"));
        LocalDate dayOfArrival = LocalDate.parse(request.getParameter("arr_day"));
        int countOfPeople = Integer.parseInt(request.getParameter("count"));
        boolean access = Boolean.parseBoolean(request.getParameter("access"));
        Long userId = SessionCookieManager.getLoginedUser(session).getId();
        Long transportId = Long.parseLong(request.getParameter("transport"));

        Trip trip = new Trip(departureDay, dayOfArrival, countOfPeople, access, transportId, userId);

        try {
            tripService.insert(trip);

//            TripDto tripDto = tripService.getByField(departureDay.toString());
//
//            if (tripPlaceService.isEmptyPlaceList(tripDto.getId())) {
//
//                request.setAttribute("trip", tripDto);
//                RequestDispatcher dispatcher = request.getServletContext()
//                        .getRequestDispatcher(JSPFILES.ADD_PLACE_TO_TRIP.getPath());
//                dispatcher.include(request, response);
//            }
            request.setAttribute("trip", trip);
            response.sendRedirect(request.getContextPath() + "/tripList");
        } catch (NotFoundException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_TRIP.getPath());
            dispatcher.forward(request, response);
        }
    }
}
