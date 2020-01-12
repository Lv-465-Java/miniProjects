package servlet.place;

import db.ConnectionManager;
import exception.NotFoundException;
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

@WebServlet("/deletePlace")
public class DeletePlaceServlet extends HttpServlet {

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

        //String errorString = null;

        Long id=Long.parseLong(request.getParameter("id"));
        try {
            placeService.deleteById(id);
            response.sendRedirect(request.getContextPath() + "/PlaceList");

        }catch (NotFoundException e){
            // If has an error, redirecte to the error page.
            request.setAttribute("error", e.getMessage());

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deletePlaceError.jsp");
            dispatcher.forward(request, response);
        }

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
