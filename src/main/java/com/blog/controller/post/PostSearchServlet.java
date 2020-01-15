package com.blog.controller.post;

import com.blog.constant.Parameter;
import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
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

@WebServlet("/search/*")
public class PostSearchServlet extends HttpServlet {

    private PostService postService;
    private CategoryService categoryService;

    public PostSearchServlet() {
        this.postService = new PostServiceImpl();
        this.categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("session", Security.checkSession(req, resp));
        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        Long categoryId = Long.parseLong(pathParts[1]);
        try {
            req.setAttribute("field", "Category - " + categoryService.getById(categoryId).getName());
            req.setAttribute("categories", categoryService.getAll());
            req.setAttribute("posts", postService.findByCategory(categoryId));
        }catch (NotFoundExeption e){
            req.setAttribute(Parameter.MESSAGE, e.getMessage());
        }
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.SEARCH_RESULT.toString())
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter(Parameter.TEXT);
        req.setAttribute("field", text);
        try {
            req.setAttribute("categories", categoryService.getAll());
            req.setAttribute("posts", postService.findByTitle(text));
        }catch (NotFoundExeption e){
            req.setAttribute(Parameter.MESSAGE, e.getMessage());
        }
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.SEARCH_RESULT.toString())
                .forward(req, resp);
    }
}
