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

@WebServlet(name = "Timkiemsach_servlet", urlPatterns = {"/tksach"})
public class Tkiemsach_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBQl_sach dbQl_sach=new DBQl_sach();
        if(request.getParameter("timkiemsach")!=null){
            String ten_sach=request.getParameter("text_tks");
            List<Sach> list=dbQl_sach.getTimkiem(ten_sach);
            request.setAttribute("bookList", list);
            request.getRequestDispatcher("ql_sach.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
