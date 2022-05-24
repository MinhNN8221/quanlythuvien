package controller;

import DAO.DBQl_sach;
import Model.Sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QL_sachServlet", urlPatterns = {"/qlsach"})
public class QL_sachServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBQl_sach dbQl_sach=new DBQl_sach();
        List<Sach> list=dbQl_sach.getAllsach();
        if(request.getSession().getAttribute("username")!=null){
        request.setAttribute("bookList", list);
        request.getRequestDispatcher("ql_sach.jsp").forward(request, response);}
        else{
            request.setAttribute("err", "Bạn cần đăng nhập trước");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
