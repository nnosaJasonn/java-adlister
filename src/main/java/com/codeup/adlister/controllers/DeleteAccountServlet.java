package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DeleteAccountServlet", urlPatterns = "/delete-account")
public class DeleteAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().getAttribute("user");
        DaoFactory.getAdsDao().deleteFromUser(DaoFactory.getLoginsDao().getId());
        DaoFactory.getUsersDao().deleteUser(DaoFactory.getLoginsDao().getId());

        response.sendRedirect("/logout");

    }
}
