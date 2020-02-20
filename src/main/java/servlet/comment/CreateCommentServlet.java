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
import java.sql.Connection;
import java.util.List;

/**
 * Class processes requests for "/createComment"  url
 */
@WebServlet("/createComment")
public class CreateCommentServlet extends HttpServlet {

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

            try {
                List<PlaceDto> placeDto=placeService.getAll();
                request.setAttribute("placeDtoList",placeDto);

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_COMMENT.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
                request.setAttribute("error",e.getMessage());
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher(JSPFILES.MAIN_PAGE.getPath());
                dispatcher.forward(request, response);
            }
        }


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session=request.getSession();

           String text= request.getParameter("comment");
            Long placeId = Long.parseLong(request.getParameter("placeId"));
            Long userId= SessionCookieManager.getLoginedUser(session).getId();

            Comment comment=new Comment(text,placeId,userId);

            try {
                commentService.insert(comment);
                request.setAttribute("commentList", comment);
                response.sendRedirect(request.getContextPath() + "/commentList");
            } catch (NotFoundException e){
                request.setAttribute("error", e.getMessage());
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher(JSPFILES.CREATE_COMMENT.getPath());
                dispatcher.forward(request, response);
            }

            }
        }
