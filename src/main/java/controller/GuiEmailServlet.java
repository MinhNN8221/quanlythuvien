package controller;

import DAO.DB;
import DAO.DBQlSinh_vien;
import DAO.DBQl_muon;
import Model.Sinh_vien;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GuiEmailServlet", urlPatterns = {"/email"})
public class GuiEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        final String username = "itptit104@gmail.com";
        final String password = "a1234567a";
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.port", "587");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(pro, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        String ma_sv=request.getParameter("email");
        System.out.println(ma_sv);
        DBQl_muon dbQl_muon=new DBQl_muon();
        DBQlSinh_vien dbQlSinh_vien=new DBQlSinh_vien();
        Sinh_vien sinh_vien=dbQlSinh_vien.getTen_sv(ma_sv);
        System.out.println(sinh_vien.getMa_sv()+" "+sinh_vien.getEmail());
        String emailTo=sinh_vien.getEmail();
        String emailSubject="Thông báo từ thư viện PTIT";
        String emailContent="Chào bạn "+sinh_vien.getTen_sv()+", bạn có lịch trả sách vào ngày "+dbQl_muon.Ngay_tra(ma_sv);
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));
            message.setSubject(emailSubject);
            message.setText(emailContent);
            Transport.send(message);
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("err", "Gửi email thông báo thành công");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma_sv=request.getParameter("email");
        DBQlSinh_vien dbQlSinh_vien=new DBQlSinh_vien();
        Sinh_vien sinh_vien=dbQlSinh_vien.getTen_sv(ma_sv);
        request.setAttribute("sinhvien", sinh_vien);
        request.getRequestDispatcher("chitiet_sv.jsp").forward(request, response);
    }
}
