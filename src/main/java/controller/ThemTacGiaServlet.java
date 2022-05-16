package controller;

import DAO.DBTac_gia;
import DAO.DBVi_tri;
import Model.Tac_gia;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ThemTacGiaServlet", urlPatterns = {"/themtacgia"})
public class ThemTacGiaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("themtacgia.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBTac_gia db_tacgia=new DBTac_gia();
        Tac_gia tacgia = new Tac_gia();
        if (request.getParameter("themtacgia") != null){
            String tac_gia = request.getParameter("tacgia");
            String diachi = request.getParameter("diachi");
            tacgia.setTen_tg(tac_gia);
            tacgia.setDia_chi(diachi);
            int result = db_tacgia.getThemtacgia(tacgia);
        }
        doGet(request, response);
    }
}