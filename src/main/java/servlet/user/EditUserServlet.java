package servlet.user;

import db.ConnectionManager;
import dto.UserDto;
import entity.User;
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
import java.sql.Connection;

/**
 * Class processes requests for "/editUser"  url
 */
@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        userService=new UserServiceImpl();
    }

    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        Long id = Long.parseLong(request.getParameter("id"));

        UserDto user = null;

          try {
              user = userService.getById(id);

              request.setAttribute("user", user);
              RequestDispatcher dispatcher = request.getServletContext()
                      .getRequestDispatcher(JSPFILES.EDIT_USER.getPath());
              dispatcher.forward(request, response);
          } catch (NotFoundException e){
              request.setAttribute("error", e.getMessage());
              response.sendRedirect(request.getServletPath() + "/userList");
          }
    }

    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        String firstName =  request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user=User.builder().firstName(firstName).lastName(lastName).username(username)
                .email(email).password(password).build();

        request.setAttribute("user", user);

        try{
            userService.updateByEntity(user);
            response.sendRedirect(request.getContextPath() + "/userList");
        } catch (NotFoundException e){
            request.setAttribute("error",e.getMessage());

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_USER.getPath());
            dispatcher.forward(request, response);
        }
    }
}
