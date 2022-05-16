package controller;

import DAO.DBQlSinh_vien;
import DAO.DBQl_muon;
import Model.Muon_sach;
import Model.Sinh_vien;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "XemchitietServlet", urlPatterns = {"/xemchitiet"})
public class XemchitietServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msv=request.getParameter("id");
        DBQlSinh_vien dbQlSinh_vien= new DBQlSinh_vien();
        Sinh_vien sinh_vien=dbQlSinh_vien.getTen_sv(msv);
        request.setAttribute("sinhvien", sinh_vien);
        request.getRequestDispatcher("chitiet_sv.jsp").forward(request, response);
    }
}
