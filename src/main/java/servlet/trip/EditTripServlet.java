package servlet.trip;

import dto.TripDto;
import entity.Transport;
import entity.Trip;
import exception.NotFoundException;
import mapper.TripMapper;
import service.TransportService;
import service.TripService;
import service.impl.TransportServiceImpl;
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
import java.time.LocalDate;
import java.util.List;

/**
 * Class processes requests for "/editTrip"  url
 */
@WebServlet("/editTrip")
public class EditTripServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TripService tripService;
    private TransportService transportService;


    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        tripService=new TripServiceImpl();
        transportService=new TransportServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("tripid"));

        try {
           Trip tripDto=tripService.getById(id);
           List<Transport> list=transportService.getAll();

            request.setAttribute("tripDto", tripDto);
            request.setAttribute("transList", list);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_TRIP.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getServletPath() + "/tripList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session= request.getSession();
        Long userId=SessionCookieManager.getLoginedUser(session).getId();

        Long tripId=Long.parseLong(request.getParameter("tripId"));
        LocalDate depDay = LocalDate.parse(request.getParameter("dep_day"));
        LocalDate arrDay = LocalDate.parse(request.getParameter("arr_day"));
        int count = Integer.parseInt(request.getParameter("count"));
        boolean access = Boolean.parseBoolean(request.getParameter("access"));
        Long transportId = Long.parseLong(request.getParameter("transport"));


//        Trip trip=tripService.getById(tripId);
//        trip.setDepartureDay(depDay);
//        trip.setDayOfArrival(arrDay);
//        trip.setCountOfPeople(count);
//        trip.setAccess(access);
//        trip.setTransportId(transportId);
        Trip trip=new Trip(tripId,depDay,arrDay,count,access,transportId, userId);


        request.setAttribute("trip", trip);

        try{
            tripService.updateByEntity(trip);
            response.sendRedirect(request.getContextPath() + "/tripList");

        } catch (NotFoundException e){
            request.setAttribute("error",e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_TRIP.getPath());
            dispatcher.forward(request, response);
        }
    }
}
