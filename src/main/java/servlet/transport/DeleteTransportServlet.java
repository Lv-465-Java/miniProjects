package servlet.transport;

import db.ConnectionManager;
import service.TransportService;
import service.impl.TransportServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/deleteTransport")
public class DeleteTransportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TransportService transportService;

    @Override
    public void init() {
        transportService=new TransportServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        //String errorString = null;

        Long id=Long.parseLong(request.getParameter("id"));
        if(!transportService.deleteById(id)){
            // If has an error, redirecte to the error page.
            request.setAttribute("errorString", "Error when delete user");

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteTransportError.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/TransportList");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
