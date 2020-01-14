package com.blog.controller.user;

import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.dto.CategoryDto;
import com.blog.dto.PostDto;
import com.blog.service.PostService;
import com.blog.service.UserService;
import com.blog.service.impl.PostServiceImpl;
import com.blog.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private PostService postService;
    private UserService userService;

    public AdminServlet(){
        this.postService = new PostServiceImpl();
        this.userService = new UserServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PostDto> postDtoList = postService.getAll();
        req.setAttribute("session", Security.checkSession(req, resp));
        req.setAttribute("users", userService.getAll());
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.ADMIN_PAGE.toString())
                .forward(req, resp);
    }
}
