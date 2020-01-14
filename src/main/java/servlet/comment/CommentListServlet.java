package servlet.comment;

import db.ConnectionManager;
import dto.CommentDto;
import exception.NotFoundException;
import service.CommentService;
import service.impl.CommentServiceImpl;
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
 * Class processes requests for "/commentList"  url
 */
@WebServlet("/commentList")
public class CommentListServlet extends HttpServlet {

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

        try {
            List<CommentDto> list = commentService.getAll();
            request.setAttribute("commentList", list);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.COMMENT_LIST.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.MAIN_PAGE.getPath());
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
