package com.blog.controller.post;

import com.blog.constant.Parameter;
import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.dto.PostDto;
import com.blog.service.PostService;
import com.blog.service.UserService;
import com.blog.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/post/view/*")
public class PostViewServlet extends HttpServlet {

    private PostService postService;

    public PostViewServlet() {
        this.postService = new PostServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("session", Security.checkSession(req, resp));

        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String post_id = pathParts[1];
        PostDto postDto = postService.getById(Long.parseLong(post_id));
        req.setAttribute("post", postDto);
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.POST_VIEW.toString())
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
