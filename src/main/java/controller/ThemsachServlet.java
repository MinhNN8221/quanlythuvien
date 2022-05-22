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

@WebServlet(name = "ThemsachServlet", urlPatterns = {"/themsach"})
public class ThemsachServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBQl_sach dbQl_sach=new DBQl_sach();
        List<Sach> listsach=dbQl_sach.getAllsach();
        Sach sach=new Sach();
        Loai_sach loai_sach=new Loai_sach();
        Tac_gia tac_gia=new Tac_gia();
        Vi_tri vi_tri=new Vi_tri();
        Nhan_vien nhan_vien=new Nhan_vien();
        if(request.getParameter("themsach")!=null){
            String tensach=request.getParameter("tensach");
            int id_ls=Integer.valueOf((String)request.getParameter("loaisach"));
            int id_vt=Integer.valueOf((String)request.getParameter("vitri"));
            int id_tg=Integer.valueOf((String)request.getParameter("tacgia"));
            int sl_bd=Integer.valueOf((String)request.getParameter("sl_bd"));
            int sl_cl=Integer.valueOf((String)request.getParameter("sl_cl"));
            sach.setTen_sach(tensach);
            loai_sach.setId_ls(id_ls);
            sach.setLoai_sach(loai_sach);
            tac_gia.setId_tg(id_tg);
            sach.setTac_gia(tac_gia);
            vi_tri.setId_vt(id_vt);
            sach.setVi_tri(vi_tri);
            sach.setSl_bd(sl_bd);
            sach.setSl_cl(sl_cl);
            nhan_vien.setId_nv(1);
            sach.setNhan_vien(nhan_vien);
//            if(listsach.contains("Lập trình")){
//                request.setAttribute("err", "Tên sách bị trùng");
//            }else{
                int result=dbQl_sach.getThemsach(sach);
                request.setAttribute("err", "Thêm sách thành công");
                doGet(request, response);
//            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBQl_sach dbQl_sach=new DBQl_sach();
        List<Loai_sach> loai_sach=dbQl_sach.getLoaisach();
        List<Vi_tri> vi_tri=dbQl_sach.getVi_tri();
        List<Tac_gia>tac_gia=dbQl_sach.getTac_gia();
        request.setAttribute("list_ls", loai_sach);
        request.setAttribute("list_vt", vi_tri);
        request.setAttribute("list_tg", tac_gia);
        request.getRequestDispatcher("themsach.jsp").forward(request, response);
    }
}
