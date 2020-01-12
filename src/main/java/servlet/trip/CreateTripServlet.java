package servlet.trip;

import db.ConnectionManager;
import entity.Trip;
import exception.NotFoundException;
import service.TripService;
import service.impl.TripServiceImpl;
import service.impl.UserServiceImpl;
import servlet.JSPFILES;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet("/createTrip")

public class CreateTripServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;
        private TripService tripService;

        @Override
        public void init() {
        tripService=new TripServiceImpl();
    }

        // Show trip creation page.
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_TRIP.getPath());
            dispatcher.forward(request, response);
        }

        // When the user enters the trip information, and click Submit.
        // This method will be called.
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            Connection conn = ConnectionManager.getInstance().getConnection();

            LocalDate departureDay = LocalDate.parse(request.getParameter("departure_day"));
            LocalDate dayOfArrival = LocalDate.parse(request.getParameter("day_of_arrival"));
            int countOfPeople = Integer.parseInt(request.getParameter("count_of_people"));
            boolean access= Boolean.parseBoolean(request.getParameter("access"));
            Long userId=Long.parseLong(request.getParameter("user_id"));
            Long transportId=Long.parseLong(request.getParameter("transport_id"));

            Trip trip=Trip.builder().departureDay(departureDay).dayOfArrival(dayOfArrival)
                    .countOfPeople(countOfPeople).access(access).transportId(transportId).userId(userId).build();


            try {
                tripService.insert(trip);
                request.setAttribute("trip", trip);
                response.sendRedirect(request.getContextPath() + "/TripList");
            } catch (NotFoundException e){
                request.setAttribute("errorString", e.getMessage());
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher(JSPFILES.CREATE_TRIP.getPath());
                dispatcher.forward(request, response);
            }
        }
    }
