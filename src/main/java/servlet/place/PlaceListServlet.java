package servlet.place;

import db.ConnectionManager;
import dto.PlaceDto;
import service.PlaceService;
import service.impl.PlaceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/placeList")
public class PlaceListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PlaceService placeService;

    @Override
    public void init() {
        placeService=new PlaceServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        // String errorString = null;
        List<PlaceDto> list = placeService.getAll();
        //request.setAttribute("errorString", errorString);
        request.setAttribute("placeList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/placeList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
