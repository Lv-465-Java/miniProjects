package com.blog.controller.common;

import com.blog.constant.Parameter;
import com.blog.controller.ViewUrls;
import com.blog.dto.CategoryDto;
import com.blog.dto.PostDto;
import com.blog.exeption.NotFoundExeption;
import com.blog.service.CategoryService;
import com.blog.service.PostService;
import com.blog.service.impl.CategoryServiceImpl;
import com.blog.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class MainServlet extends HttpServlet {

    private PostService postService;
    private CategoryService categoryService;

    public MainServlet() {
        this.postService = new PostServiceImpl();
        this.categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("session", Security.checkSession(req, resp));
        try {
            List<PostDto> postDtoList = postService.getAll();
            req.setAttribute("postList", postDtoList);
            List<CategoryDto> categoryDtoList = categoryService.getAll();
            req.setAttribute("categories", categoryDtoList);
        }catch (NotFoundExeption e){
            req.setAttribute(Parameter.MESSAGE, e.getMessage());
        }
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.HOME_PAGE.toString())
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
