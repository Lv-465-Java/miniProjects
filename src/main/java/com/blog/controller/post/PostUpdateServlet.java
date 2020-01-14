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
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/post/update/*")
@MultipartConfig
public class PostUpdateServlet extends HttpServlet {

    private PostService postService;

    public PostUpdateServlet() {
        this.postService = new PostServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Security.checkSession(req,resp)) {
            req.setAttribute("session", Security.checkSession(req,resp));
            String pathInfo = req.getPathInfo();
            String[] pathParts = pathInfo.split("/");
            PostDto postDto = postService.getById(Long.parseLong(pathParts[1]));
            req.setAttribute("post", postDto);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.POST_UPDATE.toString())
                    .forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath() + ControllerUrls.HOME_PAGE.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File file = new File(Parameter.IMAGE_PATH
                + postService.getById(Long.parseLong(req.getParameter(Parameter.POST_ID))).getImgPath());
        file.delete();

        Part filePart = req.getPart("file");
        String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileStream = filePart.getInputStream();
        byte[] bytes = new byte[fileStream.available()];
        fileStream.read(bytes);
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(
                        new File(Parameter.IMAGE_PATH + fileName)));
        bos.write(bytes);
        bos.close();

        PostDto postDto = new PostDto();
        postDto.setId(Long.parseLong(req.getParameter(Parameter.POST_ID)));
        postDto.setTitle(req.getParameter(Parameter.TITLE));
        postDto.setContent(req.getParameter(Parameter.CONTENT));
        postDto.setImgPath(fileName);
        postDto.setCategoryId(Long.parseLong(req.getParameter(Parameter.CATEGORY_ID)));

        postService.update(postDto);
        resp.sendRedirect(req.getContextPath() + ControllerUrls.USER_POSTS.toString());
    }
}
