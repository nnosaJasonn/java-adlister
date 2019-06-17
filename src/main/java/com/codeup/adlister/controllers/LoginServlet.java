package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        boolean validAttempt = DaoFactory.getLoginsDao().verify(username, password);
        if (validAttempt) {
//        DaoFactory.getLoginsDao().setID(username, password);
            request.getSession().setAttribute("user", username);
//            DaoFactory.getLoginsDao().setID(username, password);
        long userID = DaoFactory.getLoginsDao().getId();
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("userID", userID);
            if (username.equalsIgnoreCase("admin")){
                response.sendRedirect("/admin-portal");
            } else {
                response.sendRedirect("/profile");
            }
        } else {
            response.sendRedirect("/login?blah=blah");
        }
    }
}
