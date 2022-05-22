package controller;

import DAO.DBQlSinh_vien;
import DAO.DBQl_muon;
import DAO.DBQl_sach;
import Model.Muon_sach;
import Model.Nhan_vien;
import Model.Sach;
import Model.Sinh_vien;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ThemsvServlet", urlPatterns = {"/themsv"})
public class ThemsvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBQl_muon dbQl_muon=new DBQl_muon();
        DBQl_sach dbQl_sach=new DBQl_sach();
        DBQlSinh_vien dbQlSinh_vien=new DBQlSinh_vien();
        Muon_sach muon_sach=new Muon_sach();
        Sach sach=new Sach();
        Nhan_vien nhan_vien=new Nhan_vien();
        if(request.getParameter("themsv")!=null){
            String ten_sv=request.getParameter("tensv");
            String ma_sv=request.getParameter("masv");
            String lop=request.getParameter("lopsv");
            String email=request.getParameter("email");
            int id=Integer.valueOf((String)request.getParameter("sach"));
            String ngay_tra=request.getParameter("date");
            nhan_vien.setId_nv(1);
            Sinh_vien sinh_vien=new Sinh_vien(ma_sv, ten_sv, lop, email, nhan_vien);
            sach.setId(id);
            muon_sach.setSach(sach);
            muon_sach.setSinh_vien(sinh_vien);
            muon_sach.setNgay_tra(ngay_tra);
            if(dbQl_muon.getLuotmuon(ma_sv)==0){
                if(dbQl_sach.getSlgclai(id)>0){
                    dbQlSinh_vien.getThemsv(sinh_vien);
                    dbQl_muon.getThem(muon_sach);
                    dbQl_muon.getUpdateLuot(ma_sv, dbQl_muon.getLuotmuon(ma_sv)+1);
                    dbQl_sach.getUpdateSlg(dbQl_sach.getSlgclai(id)-1,id);
                    request.setAttribute("success", "Thêm thông tin sinh viên mượn sách thành công");
                }else{
                    request.setAttribute("error", "Sách bạn muốn mượn tạm hết!");
                }
            }else if(dbQl_muon.getLuotmuon(ma_sv)<3){
                if(dbQl_sach.getSlgclai(id)>0){
                    dbQl_muon.getThem(muon_sach);
                    request.setAttribute("success", "Thêm thông tin sinh viên mượn sách thành công");
                    dbQl_sach.getUpdateSlg(dbQl_sach.getSlgclai(id)-1,id);
                    dbQl_muon.getUpdateLuot(ma_sv, dbQl_muon.getLuotmuon(ma_sv)+1);
                }else{
                    request.setAttribute("error", "Sách bạn muốn mượn tạm hết!");
                }
            }else{
                request.setAttribute("error", "Sinh viên đã mượn sách quá 3 lần");
            }
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBQl_sach dbQl_sach=new DBQl_sach();
        List<Sach> list=dbQl_sach.getAllsach();
        request.setAttribute("listsach", list);
        request.getRequestDispatcher("them_ngdoc.jsp").forward(request, response);
    }
}
