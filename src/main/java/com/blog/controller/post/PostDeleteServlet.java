package com.blog.controller.post;

import com.blog.controller.ControllerUrls;
import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.exeption.NotDeleteExeption;
import com.blog.service.PostService;
import com.blog.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post/delete/*")
public class PostDeleteServlet extends HttpServlet {

    private PostService postService;

    public PostDeleteServlet() {
        this.postService = new PostServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String pathInfo = req.getPathInfo();
            String[] pathParts = pathInfo.split("/");
            try {
                postService.deleteById(Long.parseLong(pathParts[1]));
                resp.sendRedirect(req.getContextPath() + ControllerUrls.USER_POSTS.toString());
            }catch (NotDeleteExeption e){
                resp.sendRedirect(req.getContextPath() + ControllerUrls.HOME_PAGE.toString());
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
