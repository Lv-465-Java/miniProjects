package servlet.transport;

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
 * Class processes requests for "/deleteTransport"  url
 */
@WebServlet("/deleteTransport")
public class DeleteTransportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TransportService transportService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        transportService=new TransportServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name=request.getParameter("transpId");
        try {
            transportService.deleteByName(name);
            response.sendRedirect(request.getContextPath() + "/transportList");
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.ADMIN_PAGE.getPath());
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
