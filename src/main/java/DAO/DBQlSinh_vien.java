package DAO;

import Model.Nhan_vien;
import Model.Sinh_vien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBQlSinh_vien {
    private final DB db=new DB();
    public Sinh_vien getTen_sv(String masv){
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT * FROM ttcs.sinh_vien where ma_sv='"+masv+"'");
            while (res.next()){
                String ma=res.getString(1);
                String ten=res.getString(2);
                String lop=res.getString(3);
                String email=res.getString(4);
                int id_nv=res.getInt(5);
                Nhan_vien nhan_vien=new Nhan_vien();
                nhan_vien.setId_nv(id_nv);
                Sinh_vien sinh_vien=new Sinh_vien(ma, ten, lop, email, nhan_vien);
                return sinh_vien;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void getThemsv(Sinh_vien sinh_vien){
        try {
            PreparedStatement pre=db.getCon().prepareStatement("INSERT INTO ttcs.sinh_vien VALUES (?, ?, ?, ?, 1)");
            pre.setString(1, sinh_vien.getMa_sv());
            pre.setString(2, sinh_vien.getTen_sv());
            pre.setString(3, sinh_vien.getLop());
            pre.setString(4, sinh_vien.getEmail());
            pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public String getMasv(int id_muon){
        String masv=null;
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT ma_sv from ttcs.muon where id_muon='"+id_muon+"'");
            while (res.next()){
                masv=res.getString(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return masv;
    }
}
