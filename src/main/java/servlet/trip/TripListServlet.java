package servlet.trip;

import db.ConnectionManager;
import dto.TripDto;
import dto.UserDto;
import exception.NotFoundException;
import service.TripService;
import service.UserService;
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
import java.util.List;

/**
 * Class processes requests for "/tripList"  url
 */
@WebServlet("/tripList")
public class TripListServlet extends HttpServlet {

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

        try {
            List<TripDto> list = tripService.getAll();

            request.setAttribute("tripList", list);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.TRIP_LIST.getPath());
            dispatcher.forward(request, response);

        } catch (NotFoundException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath());////////////
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
