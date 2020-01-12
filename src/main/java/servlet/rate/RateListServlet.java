package servlet.rate;

import db.ConnectionManager;
import entity.Rate;
import service.RateService;
import service.impl.RateServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/rateList")
public class RateListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RateService rateService;

    @Override
    public void init() {
        rateService=new RateServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        // String errorString = null;
        List<Rate> list = rateService.getAll();
        //request.setAttribute("errorString", errorString);
        request.setAttribute("rateList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/rateList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
