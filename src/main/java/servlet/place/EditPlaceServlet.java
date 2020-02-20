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

/**
 * Class processes requests for "/editPlace"  url
 */
@WebServlet("/editPlace")
public class EditPlaceServlet extends HttpServlet {

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

        Long id = Long.parseLong(request.getParameter("plId"));

        try {
            Place placeDto = placeService.getById(id);

            request.setAttribute("placeDto", placeDto);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_PLACE.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getServletPath() + "/placeList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String country =  request.getParameter("country");
        String town =  request.getParameter("town");
        String name =  request.getParameter("name");
        String description =  request.getParameter("description");
        String photo =  request.getParameter("photo");
        Long placeId=Long.parseLong(request.getParameter("placeId"));


        Place place=placeService.getById(placeId);
        place.setCountry(country);
        place.setTown(town);
        place.setName(name);
        place.setDescription(description);

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
