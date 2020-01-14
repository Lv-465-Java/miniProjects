package com.blog.controller.post;

import com.blog.constant.Parameter;
import com.blog.controller.ControllerUrls;
import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.dto.LoginDto;
import com.blog.dto.PostDto;
import com.blog.service.PostService;
import com.blog.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/post/create")
@MultipartConfig
public class PostCreateServlet extends HttpServlet {

    PostService postService;

    public PostCreateServlet() {
        this.postService = new PostServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("session", Security.checkSession(req, resp));
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.POST_CREATE.toString())
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        InputStream fileStream = filePart.getInputStream();
        byte[] bytes = new byte[fileStream.available()];
        fileStream.read(bytes);

        String PathToImages = "/C:/Users/Marian/Desktop/blog/target/blog/resources/images/posts/";
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(
                        new File(Parameter.IMAGE_PATH + fileName)));
        bos.write(bytes);
        bos.close();

        PostDto postDto = new PostDto(
                req.getParameter(Parameter.TITLE),
                req.getParameter(Parameter.CONTENT),
                fileName,
                Long.parseLong(req.getParameter(Parameter.CATEGORY_ID))
        );
        HttpSession session = req.getSession(false);
        LoginDto loginDto = (LoginDto) session.getAttribute("loginDto");
        String username = loginDto.getUsername();

        postService.save(postDto, username);

        resp.sendRedirect(req.getContextPath() + ControllerUrls.HOME_PAGE.toString());

    }
}
