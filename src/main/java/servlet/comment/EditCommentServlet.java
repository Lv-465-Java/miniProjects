package servlet.comment;

import dto.PlaceDto;
import entity.Comment;
import exception.NotFoundException;
import service.CommentService;
import service.PlaceService;
import service.impl.CommentServiceImpl;
import service.impl.PlaceServiceImpl;
import servlet.JSPFILES;
import utils.SessionCookieManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class processes requests for "/editComment"  url
 */
@WebServlet("/editComment")
public class EditCommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CommentService commentService;
    private PlaceService placeService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        commentService=new CommentServiceImpl();
        placeService=new PlaceServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("comId"));

        try {
            Comment comment = commentService.getById(id);
            List<PlaceDto> placeDto=placeService.getAll();

            request.setAttribute("commentDto", comment);
            request.setAttribute("placeDto", placeDto);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EDIT_COMMENT.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getServletPath() + "/commentList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession();
        Long userId= SessionCookieManager.getLoginedUser(session).getId();

        String text =  request.getParameter("text_of_comment");
        Long placeId = Long.parseLong(request.getParameter("place"));
        Long commentId=Long.parseLong(request.getParameter("commId"));

        Comment comment=new Comment(commentId,text,placeId,userId);

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
