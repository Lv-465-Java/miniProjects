package servlet.comment;

import db.ConnectionManager;
import exception.NotFoundException;
import service.CommentService;
import service.impl.CommentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Class processes requests for "/deleteComment"  url
 */
@WebServlet("/deleteComment")
public class DeleteCommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CommentService commentService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        commentService=new CommentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        //String errorString = null;

        Long id=Long.parseLong(request.getParameter("id"));
        try {
            commentService.deleteById(id);
            response.sendRedirect(request.getContextPath() + "/commentList");

        }catch (NotFoundException e){
            request.setAttribute("errorString", e.getMessage());

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteCommentError.jsp");
            dispatcher.forward(request, response);
        }

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
