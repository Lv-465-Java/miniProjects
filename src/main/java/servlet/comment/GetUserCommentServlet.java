package servlet.comment;

import db.ConnectionManager;
import dto.CommentDto;
import exception.NotFoundException;
import service.CommentService;
import service.impl.CommentServiceImpl;
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
 * Class processes requests for "/getUserComment"  url
 */
@WebServlet("/getUserComment")
public class GetUserCommentServlet extends HttpServlet {

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

        HttpSession session=request.getSession();
        Long userId= SessionCookieManager.getLoginedUser(session).getId();

        try {
            List<CommentDto> list = commentService.getByUserId(userId);
            request.setAttribute("commentList", list);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.COMMENT_LIST.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath());/////////////
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
