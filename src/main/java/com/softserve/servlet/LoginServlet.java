package com.softserve.servlet;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.ViewURL;
import com.softserve.entity.User;
import com.softserve.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = {""})
public class LoginServlet extends HttpServlet {

    private UserServiceImpl userService;

    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            String email = req.getParameter(ServletResponseParameter.USER_EMAIL.getServletParameter());
            String password = req.getParameter(ServletResponseParameter.USER_PASSWORD.getServletParameter());
           if (userService.login(email, password)){
                resp.sendRedirect(ViewURL.USER_REGISTRATION_URL.getViewUrl());
            } else {
               resp.sendRedirect("home.jsp");
//               req.setAttribute("error", "Unknown user, please try again");
//               req.getRequestDispatcher("home.jsp").forward(req, resp);
////               resp.sendRedirect(req.getContextPath() + "home.jsp");
           }
        } catch (RuntimeException e) {
            String error = e.getMessage();

//            <c:if test="$error!=null">
//                 <p id="loginError"> <c:out value="${error}"/></p>
           // out.write("<p id='errMsg' style='color: red; font-size: larger;'>Please Enter Both Us </p>");
            //resp.sendRedirect(e.getMessage());
        }

    }
}
