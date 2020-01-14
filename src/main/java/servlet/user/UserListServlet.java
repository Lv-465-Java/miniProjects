package servlet.user;

import db.ConnectionManager;
import dto.UserDto;
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
import java.util.List;

/**
 * Class processes requests for "/userList"  url
 */
@WebServlet("/userList")
public class UserListServlet extends HttpServlet {

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

        try {
            List<UserDto> list = userService.getAll();

            request.setAttribute("userList", list);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.USER_LIST.getPath());
            dispatcher.forward(request, response);

        } catch (NotFoundException e) {
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/adminPage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
