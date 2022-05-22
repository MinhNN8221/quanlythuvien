package controller;

import DAO.DBQl_sach;
import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChinhsuaServlet", urlPatterns = {"/chinhsua"})
public class ChinhsuaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBQl_sach dbQl_sach=new DBQl_sach();
        Loai_sach loai_sach=new Loai_sach();
        Vi_tri vi_tri=new Vi_tri();
        Nhan_vien nhan_vien=new Nhan_vien();
        Tac_gia tac_gia=new Tac_gia();
        int id=Integer.valueOf(request.getParameter("id"));
        int id_tl=Integer.valueOf(request.getParameter("loaisach"));
        int id_vt=Integer.valueOf(request.getParameter("vitri"));
        int id_tg=Integer.valueOf(request.getParameter("tacgia"));
        String ten_sach=request.getParameter("tensach");
        int sl_bd=Integer.valueOf(request.getParameter("sl_bd"));
        int sl_cl=Integer.valueOf(request.getParameter("sl_cl"));
        loai_sach.setId_ls(id_tl);
        vi_tri.setId_vt(id_vt);
        tac_gia.setId_tg(id_tg);
        nhan_vien.setId_nv(1);
        Sach sach=new Sach(id, loai_sach, vi_tri, tac_gia, ten_sach, sl_bd, sl_cl,nhan_vien);
        dbQl_sach.getUpdate(sach);
        request.setAttribute("err", "Cập nhật thành công");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBQl_sach dbQl_sach=new DBQl_sach();
        int id_sach=Integer.valueOf((String)request.getParameter("id"));
        Sach book=dbQl_sach.getSach_Id(id_sach);
        List<Loai_sach> loai_sach=dbQl_sach.getLoaisach();
        List<Vi_tri> vi_tri=dbQl_sach.getVi_tri();
        List<Tac_gia>tac_gia=dbQl_sach.getTac_gia();
        request.setAttribute("book", book);
        request.setAttribute("list_ls", loai_sach);
        request.setAttribute("list_vt", vi_tri);
        request.setAttribute("list_tg", tac_gia);
        request.getRequestDispatcher("chinhsua_sach.jsp").forward(request, response);
    }
}
