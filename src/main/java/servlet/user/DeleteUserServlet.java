package servlet.user;

import db.ConnectionManager;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Class processes requests for "/deleteUser"  url
 */
@WebServlet(urlPatterns = {"/deleteUser"})
public class DeleteUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        userService=new UserServiceImpl();
    }

    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            Connection conn = ConnectionManager.getInstance().getConnection();

            //String errorString = null;

                Long id=Long.parseLong(request.getParameter("id"));
                if(!userService.deleteById(id)){
            // If has an error, redirecte to the error page.
                request.setAttribute("errorString", "Error when delete user");

                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/WEB-INF/views/deleteUserError.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/userList");
            }

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
}
