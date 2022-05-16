package controller;

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

@WebServlet(name = "Tkiemsvien_Servlet", urlPatterns = {"/tksvien"})
public class Tkiemsvien_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DBQl_muon dbQl_muon=new DBQl_muon();
        if(request.getParameter("timkiemsv1")!=null){
            String ten_sv=request.getParameter("text_tksv");
            List<Muon_sach> list=dbQl_muon.getTkSV(ten_sv, "0");
            request.setAttribute("muonList", list);
            request.getRequestDispatcher("ds_muon.jsp").forward(request, response);
        }
        if(request.getParameter("timkiemsv2")!=null){
            String ten_sv=request.getParameter("text_tksv");
            List<Muon_sach> list=dbQl_muon.getTkSV(ten_sv, "1");
            request.setAttribute("traList", list);
            request.getRequestDispatcher("ds_tra.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
