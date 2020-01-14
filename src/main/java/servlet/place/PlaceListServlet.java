package servlet.place;

import db.ConnectionManager;
import dto.PlaceDto;
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
import java.util.List;

/**
 * Class processes requests for "/placeList"  url
 */
@WebServlet("/placeList")
public class PlaceListServlet extends HttpServlet {

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
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
        List<PlaceDto> list = placeService.getAll();
        request.setAttribute("placeList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher(JSPFILES.PLACE_LIST.getPath());
        dispatcher.forward(request, response);
    } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
