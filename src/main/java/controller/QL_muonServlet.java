package controller;

import DAO.DBQlSinh_vien;
import DAO.DBQl_muon;
import DAO.DBQl_sach;
import Model.Muon_sach;
import Model.Sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QL_muonServlet", urlPatterns = {"/qlmuon"})
public class QL_muonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBQl_muon dbQl_muon=new DBQl_muon();
        DBQl_sach dbQl_sach=new DBQl_sach();
        DBQlSinh_vien dbQlSinh_vien=new DBQlSinh_vien();
        int id_muon=Integer.valueOf((String)request.getParameter("xacnhan"));
        dbQl_muon.getXacnhan(id_muon);
        String ma_sv=dbQlSinh_vien.getMasv(id_muon);
        dbQl_muon.getUpdateLuot(ma_sv, dbQl_muon.getLuotmuon(ma_sv)-1);
        int id_sach=dbQl_muon.getIdsach(id_muon);
        dbQl_sach.getUpdateSlg(dbQl_sach.getSlgclai(id_sach)+1,id_sach);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("username")==null){
            request.setAttribute("err", "Bạn cần đăng nhập trước");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            DBQl_muon dbQl_muon=new DBQl_muon();
            List<Muon_sach> list=dbQl_muon.getDsmuon("0");
            request.setAttribute("muonList", list);
            request.getRequestDispatcher("ds_muon.jsp").forward(request, response);
        }
    }
}
