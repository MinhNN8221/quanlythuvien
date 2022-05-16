package controller;

import DAO.DBQl_sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Xoa_SachServlet", urlPatterns = {"/xoa"})
public class Xoa_SachServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBQl_sach dbQl_sach=new DBQl_sach();
        if(request.getParameter("xoa")!=null){
            int id=Integer.valueOf((String)request.getParameter("xoa"));
            dbQl_sach.getXoasach(id);
            request.setAttribute("err", "Xóa sách thành công");
            request.getRequestDispatcher("/qlsach").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
