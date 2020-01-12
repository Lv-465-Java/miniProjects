package servlet.place;

import db.ConnectionManager;
import dto.PlaceDto;
import entity.Place;
import exception.NotFoundException;
import service.PlaceService;
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

@WebServlet("/editPlace")
public class EditPlaceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PlaceService placeService;


    @Override
    public void init() {
        placeService=new PlaceServiceImpl();
    }

    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        Long id = Long.parseLong(request.getParameter("id"));

        PlaceDto placeDto = null;

        try {
            placeDto = placeService.getById(id);

            request.setAttribute("placeDto", placeDto);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_PLACE.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getServletPath() + "/placeList");
        }
    }

    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        String country =  request.getParameter("country");
        String town =  request.getParameter("town");
        String name =  request.getParameter("name");
        String description =  request.getParameter("description");
        String photo =  request.getParameter("photo");


        Place place=Place.builder().country(country).town(town).name(name).description(description)
                .photo(photo).build();

        request.setAttribute("place", place);

        try{
            placeService.updateByEntity(place);
            response.sendRedirect(request.getContextPath() + "/placeList");

        } catch (NotFoundException e){
            request.setAttribute("error",e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_PLACE.getPath());
            dispatcher.forward(request, response);
        }
    }
}
