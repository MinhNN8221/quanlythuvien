package controller;

import DAO.DBQl_sach;
import DAO.DBVi_tri;
import Model.Sach;
import Model.Vi_tri;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ThemViTriServlet", urlPatterns = {"/themvitri"})
public class ThemViTriServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            request.setAttribute("err", "Bạn cần đăng nhập trước");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("themvitri.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBVi_tri db_vitri=new DBVi_tri();
        Vi_tri Vitri = new Vi_tri();
        if (request.getParameter("themvitri") != null){
            String vitri = request.getParameter("vitri");
            Vitri.setTen_vt(vitri);
            int result = db_vitri.getThemvitri(Vitri);
            request.setAttribute("err", "Thêm vị trí thành công");
        }
        doGet(request, response);
    }
}