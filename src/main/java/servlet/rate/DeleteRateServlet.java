package servlet.rate;

import db.ConnectionManager;
import service.RateService;
import service.impl.RateServiceImpl;
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
 * Class processes requests for "/deleteRale"  url
 */
@WebServlet("/deleteRate")
public class DeleteRateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RateService rateService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        rateService=new RateServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id=Long.parseLong(request.getParameter("id"));
        if(!rateService.deleteById(id)){

            request.setAttribute("errorString", "Error when delete user");

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.MAIN_PAGE.getPath());
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/rateList");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
