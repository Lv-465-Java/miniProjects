package servlet.transport;

import db.ConnectionManager;
import entity.Transport;
import exception.NotFoundException;
import service.TransportService;
import service.impl.TransportServiceImpl;
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

@WebServlet("/transportList")
public class TransportListServlet extends HttpServlet {

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

        try{
        List<Transport> list = transportService.getAll();
        request.setAttribute("transportList", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher(JSPFILES.TRANSPORT_LIST.getPath());
        dispatcher.forward(request, response);
    } catch (NotFoundException e){
            request.setAttribute("error",e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath());
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
