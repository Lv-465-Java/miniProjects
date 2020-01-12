package servlet.place;

import db.ConnectionManager;
import entity.Comment;
import entity.Place;
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

@WebServlet("/createPlace")
public class CreatePlaceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PlaceService placeService;

    @Override
    public void init() {
        placeService=new PlaceServiceImpl();
    }

    // Show place creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher(JSPFILES.CREATE_PLACE.getPath());
        dispatcher.forward(request, response);
    }

    // When the user enters the place  and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        String country= request.getParameter("country");
        String town= request.getParameter("town");
        String name= request.getParameter("name");
        String description= request.getParameter("description");
        String photo= request.getParameter("photo");

        Place place=Place.builder().country(country).town(town).name(name).description(description)
                .photo(photo).build();


        if (!placeService.insert(place)){
            request.setAttribute("errorString", "Something went wrong");
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_PLACE.getPath());
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("place", place);
            response.sendRedirect(request.getContextPath() + "/placeList");
        }
    }
}
