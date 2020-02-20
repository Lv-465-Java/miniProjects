package servlet.user;

import exception.NotFoundException;
import service.UserService;
import service.impl.UserServiceImpl;
import servlet.JSPFILES;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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


                Long id=Long.parseLong(request.getParameter("userId"));
                try {
                    userService.deleteById(id);
                    response.sendRedirect(request.getContextPath() + "/userList");
                } catch (NotFoundException e){
                request.setAttribute("errorString", e.getMessage());
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher(JSPFILES.USER_LIST.getPath());
                dispatcher.forward(request, response);

            }

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
}
