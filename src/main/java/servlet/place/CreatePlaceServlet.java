package servlet.place;

import db.ConnectionManager;
import entity.Comment;
import entity.Place;
import exception.NotFoundException;
import service.CommentService;
import service.PlaceService;
import service.impl.CommentServiceImpl;
import service.impl.PlaceServiceImpl;
import servlet.JSPFILES;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Class processes requests for "/createPlace"  url
 */
@WebServlet("/createPlace")
public class CreatePlaceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PlaceService placeService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        placeService=new PlaceServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher(JSPFILES.CREATE_PLACE.getPath());
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String country= request.getParameter("country");
        String town= request.getParameter("town");
        String name= request.getParameter("name");
        String description= request.getParameter("descr");
        String photo= request.getParameter("photo");

        Place place=Place.builder().country(country).town(town).name(name).description(description)
                .photo(photo).build();


        try {
            placeService.insert(place);
            request.setAttribute("place", place);
            response.sendRedirect(request.getContextPath() + "/placeList");

        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_PLACE.getPath());
            dispatcher.forward(request, response);
        }
    }
}
