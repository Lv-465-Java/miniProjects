package servlet.comment;

import db.ConnectionManager;
import dto.CommentDto;
import entity.Comment;
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

@WebServlet("/editComment")
public class EditCommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CommentService commentService;


    @Override
    public void init() {
        commentService=new CommentServiceImpl();
    }

    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        Long id = Long.parseLong(request.getParameter("id"));

        CommentDto commentDto = null;

        try {
            commentDto = commentService.getById(id);

            request.setAttribute("commentDto", commentDto);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_COMMENT.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getServletPath() + "/commentList");
        }
    }

    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectionManager.getInstance().getConnection();

        String text =  request.getParameter("text_of_comment");
        Long placeId = Long.parseLong(request.getParameter("place_id"));

        Comment comment=Comment.builder().textOfComment(text).placeId(placeId).build();

        request.setAttribute("comment", comment);

        try{
            commentService.updateByEntity(comment);
            response.sendRedirect(request.getContextPath() + "/commentList");

        } catch (NotFoundException e){
            request.setAttribute("error",e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_COMMENT.getPath());
            dispatcher.forward(request, response);
        }
    }
}
