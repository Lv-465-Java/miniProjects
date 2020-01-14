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
    // private PlaceService placeService;
    private TransportService transportService;
    private TripPlaceService tripPlaceService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        tripService = new TripServiceImpl();
        transportService = new TransportServiceImpl();
        // placeService=new PlaceServiceImpl();
        tripPlaceService = new TripPlaceServiceImpl();
    }

    // Show trip creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //List<PlaceDto> placeDtoList = placeService.getAll();
            List<Transport> transportList = transportService.getAll();
            //request.setAttribute("placeDtoList", placeDtoList);
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
        HttpSession session = request.getSession();

        LocalDate departureDay = LocalDate.parse(request.getParameter("departure_day"));
        LocalDate dayOfArrival = LocalDate.parse(request.getParameter("day_of_arrival"));
        int countOfPeople = Integer.parseInt(request.getParameter("count_of_people"));
        boolean access = Boolean.parseBoolean(request.getParameter("access"));
        Long userId = SessionCookieManager.getLoginedUser(session).getId();
        Long transportId = Long.parseLong(request.getParameter("transport_id"));

        Trip trip = Trip.builder().departureDay(departureDay).dayOfArrival(dayOfArrival)
                .countOfPeople(countOfPeople).access(access).transportId(transportId).userId(userId).build();

        try {
            tripService.insert(trip);

        } catch (NotFoundException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_TRIP.getPath());
            dispatcher.forward(request, response);
        }

        TripDto tripDto = tripService.getByField(departureDay.toString());

        if (tripPlaceService.isEmptyPlaceList(tripDto.getId())) {

//                response.sendRedirect(request.getContextPath()
//                        + "/addPlaceToTrip");
            request.setAttribute("triId", tripDto.getId());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.ADD_PLACE_TO_TRIP.getPath());
            dispatcher.include(request, response);
        }
            request.setAttribute("trip", trip);
            response.sendRedirect(request.getContextPath() + "/TripList");
        }
}
