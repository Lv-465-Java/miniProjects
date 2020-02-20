package servlet.place;

import db.ConnectionManager;
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
 * Class processes requests for "/deletePlace"  url
 */
@WebServlet("/deletePlace")
public class DeletePlaceServlet extends HttpServlet {

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

        Long id=Long.parseLong(request.getParameter("placeId"));
        try {
            placeService.deleteById(id);
            response.sendRedirect(request.getContextPath() + "/placeList");

        }catch (NotFoundException e){

            request.setAttribute("error", e.getMessage());

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.PLACE_LIST.getPath());
            dispatcher.forward(request, response);
        }

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
