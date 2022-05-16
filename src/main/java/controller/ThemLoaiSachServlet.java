package controller;

import DAO.DBLoai_sach;
import DAO.DBTac_gia;
import Model.Loai_sach;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ThemLoaiSachServlet", urlPatterns = {"/themloaisach"})
public class ThemLoaiSachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("themloaisach.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBLoai_sach dbLoai_sach=new DBLoai_sach();
        Loai_sach loaiSach = new Loai_sach();
        if (request.getParameter("themloaisach") != null){
            String loaisach = request.getParameter("loaisach");
            loaiSach.setTen_ls(loaisach);
            dbLoai_sach.getThemloaisach(loaiSach);
        }
        doGet(request, response);
    }
}