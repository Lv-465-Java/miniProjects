package servlet.comment;

import db.ConnectionManager;
import entity.Comment;
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

@WebServlet("/createComment")
public class CreateCommentServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;
        private CommentService commentService;

        @Override
        public void init() {
            commentService=new CommentServiceImpl();
        }

        // Show comment creation page.
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.CREATE_COMMENT.getPath());
            dispatcher.forward(request, response);
        }

        // When the user enters the comment  and click Submit.
        // This method will be called.
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            Connection conn = ConnectionManager.getInstance().getConnection();

           String text= request.getParameter("text_of_comment");
            Long placeId = Long.parseLong(request.getParameter("place_id"));
            Long userId=Long.parseLong(request.getParameter("user_id"));  //////

            Comment comment=Comment.builder().textOfComment(text).placeId(placeId).userId(userId).build();


            if (!commentService.insert(comment)){
                request.setAttribute("errorString", "Something went wrong");
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher(JSPFILES.CREATE_TRIP.getPath());
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("comment", comment);
                response.sendRedirect(request.getContextPath() + "/commentList");
            }
        }
}
