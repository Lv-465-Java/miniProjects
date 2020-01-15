package com.blog.controller.user;

import com.blog.constant.Parameter;
import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.dto.LoginDto;
import com.blog.exeption.NotFoundExeption;
import com.blog.service.PostService;
import com.blog.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/user/posts/*")
public class AdminUserPostsServlet extends HttpServlet {
    private PostService postService;

    public AdminUserPostsServlet() {
        this.postService = new PostServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("session", Security.checkSession(req,resp));
        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String username = pathParts[1];
        req.setAttribute("username", username);
        try {
            req.setAttribute("posts", postService.findByUser(username));
        }catch (NotFoundExeption e){
            req.setAttribute(Parameter.MESSAGE, e.getMessage());
        }
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.USER_POSTS.toString())
                .forward(req,resp);
    }
}
