package com.auto.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
    private final static String add = "WEB-INF/login.html";
    private final String username = "admin";
    private final String password = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        if (this.username.equals(username) && this.password.equals(password)) {

            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(5*60);
            Cookie message = new Cookie("message", "Welcome");
            response.addCookie(message);
            response.sendRedirect(request.getContextPath() + "/admin/cars");
        } else {
            request.getRequestDispatcher(add).forward(request,response);
            PrintWriter      out = response.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
        }


    }
}