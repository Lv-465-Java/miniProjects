package com.blog.controller.user;

import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.dto.LoginDto;
import com.blog.service.PostService;
import com.blog.service.UserService;
import com.blog.service.impl.PostServiceImpl;
import com.blog.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/posts")
public class UserPostsServlet extends HttpServlet {

    private PostService postService;
    private UserService userService;

    public UserPostsServlet() {
        this.postService = new PostServiceImpl();
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("session", Security.checkSession(req,resp));
        HttpSession session = req.getSession(false);
        LoginDto loginDto = (LoginDto) session.getAttribute("loginDto");
        req.setAttribute("posts", postService.findByUser(loginDto.getUsername()));
        req.setAttribute("username", postService.findByUser(loginDto.getUsername()));
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.USER_POSTS.toString())
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
