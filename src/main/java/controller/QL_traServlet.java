package controller;

import DAO.DBQl_muon;
import Model.Muon_sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QL_traServlet", urlPatterns = {"/qltra"})
public class QL_traServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("username")==null){
            request.setAttribute("err", "Bạn cần đăng nhập trước");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            DBQl_muon dbQl_muon=new DBQl_muon();
            List<Muon_sach> list=dbQl_muon.getDsmuon("1");
            request.setAttribute("traList", list);
            request.getRequestDispatcher("ds_tra.jsp").forward(request, response);
        }
    }
}
