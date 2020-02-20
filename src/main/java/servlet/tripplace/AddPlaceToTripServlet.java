package servlet.tripplace;


import dto.PlaceDto;
import entity.TripPlace;
import exception.NotFoundException;
import service.PlaceService;
import service.TripPlaceService;
import service.impl.PlaceServiceImpl;
import service.impl.TripPlaceServiceImpl;
import servlet.JSPFILES;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 * Class processes requests for "/addPlaceToTrip"  url
 */
@WebServlet("/addPlaceToTrip")
public class AddPlaceToTripServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TripPlaceService tripPlaceService;
    private PlaceService placeService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        tripPlaceService=new TripPlaceServiceImpl();
        placeService=new PlaceServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long tripId=Long.parseLong(request.getParameter("trid"));
        try {
            List<PlaceDto> placeDtoList=placeService.getAll();

            request.setAttribute("placeDtoList", placeDtoList);
            request.setAttribute("tripId",tripId);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.ADD_PLACE_TO_TRIP.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getServletPath() + "/placeList");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String [] placeList= request.getParameterValues("placesId");
       List<Long> longList=Arrays.stream(placeList).map(Long::parseLong).collect(Collectors.toList());

       Long tripId= Long.parseLong(request.getParameter("tripId"));


        try{
            Iterator<Long> iterator=longList.iterator();
         while (iterator.hasNext()) {
             Long placeId = iterator.next();
             TripPlace tripPlace = new TripPlace(tripId, placeId);
             tripPlaceService.insert(tripPlace);
             request.setAttribute("message", "place added");
             response.sendRedirect(request.getContextPath() + "/mainPage");
         }

        } catch (NotFoundException e){
            request.setAttribute("error",e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.ADD_PLACE_TO_TRIP.getPath());
            dispatcher.forward(request, response);
        }
    }
}
