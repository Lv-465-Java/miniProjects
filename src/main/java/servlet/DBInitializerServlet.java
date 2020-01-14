package servlet;

import service.impl.DBInitializerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class processes requests for "/initDB"  url
 */
@WebServlet("/initDB")
public class DBInitializerServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBInitializerServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

            DBInitializerService.getInstance();
            request.setAttribute("init DB", "DB initialized");
            response.sendRedirect(request.getContextPath() + "/login");

    }
}
