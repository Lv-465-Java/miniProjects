package com.softserve.servlet;

import com.softserve.entity.User;
import com.softserve.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/login"})
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try{
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = new User(email, password);
           if (userService.login(email, password)){
                resp.sendRedirect("signUp.jsp");
            } else {
               resp.sendRedirect("home.jsp");
//               req.setAttribute("error", "Unknown user, please try again");
//               req.getRequestDispatcher("home.jsp").forward(req, resp);
////               resp.sendRedirect(req.getContextPath() + "home.jsp");
           }
        } catch (RuntimeException e) {

            out.write("<p id='errMsg' style='color: red; font-size: larger;'>Please Enter Both Us </p>");
            resp.sendRedirect("login.jsp");
        }

    }
}
