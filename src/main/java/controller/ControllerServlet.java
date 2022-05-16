/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DBLogin;
import DAO.DBQl_sach;
import Model.Sach;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MinhNN
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/login"})
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBLogin db=new DBLogin();
        String user=request.getParameter("username");
        String pass=request.getParameter("password");
        if(db.check(user, pass)) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        else
            response.sendRedirect("login.jsp?error=sai");
    }
}
