package servlet.transport;

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

/**
 * Class processes requests for "/createTransport"  url
 */
@WebServlet("/createTransport")
public class CreateTransportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TransportService transportService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        transportService=new TransportServiceImpl();
    }

    // Show place creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher(JSPFILES.CREATE_TRANSPORT.getPath());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name= request.getParameter("name");
        Transport transport=Transport.builder().transportName(name).build();


        try{
            transportService.insert(transport);
            request.setAttribute("transport", transport);
            response.sendRedirect(request.getContextPath() + "/transportList");
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_TRANSPORT.getPath());
            dispatcher.forward(request, response);

        }
    }
}
