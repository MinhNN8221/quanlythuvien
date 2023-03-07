package DAO;

import Model.Loai_sach;
import Model.Muon_sach;
import Model.Sach;
import Model.Sinh_vien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBQl_muon {
    private final DB db=new DB();
    private DBQl_sach dbQl_sach=new DBQl_sach();
    private DBQlSinh_vien dbQlSinh_vien=new DBQlSinh_vien();
    public List<Muon_sach> getDsmuon(String status){
        List<Muon_sach> list=new ArrayList<>();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT * FROM muon where trang_thai='"+status+"'");
            while (res.next()){
                int id_muon=res.getInt(1);
                int id=res.getInt(2);
                String msv=res.getString(3);
                int luot_muon=res.getInt(4);
                Date bd=res.getDate(5);
                Date kt=res.getDate(6);
                SimpleDateFormat Format=new SimpleDateFormat("dd/MM/yyyy");
                String ngay_muon=Format.format(bd);
                String ngay_tra=Format.format(kt);
                Sach tensach=dbQl_sach.getSach_Id(id);
                Sinh_vien sv=dbQlSinh_vien.getTen_sv(msv);
                Muon_sach muon_sach=new Muon_sach(id_muon, tensach, sv, luot_muon, ngay_muon, ngay_tra, "1");
                list.add(muon_sach);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public String Ngay_tra(String ma_sv){
        String ngay_tra=null;
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT ngay_tra from muon where ma_sv='"+ma_sv+"' and trang_thai=0");
            while (resultSet.next()){
                SimpleDateFormat Format=new SimpleDateFormat("dd/MM/yyyy");
                Date date=resultSet.getDate(1);
                ngay_tra=Format.format(date);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ngay_tra;
    }
    public void getXacnhan(int id){
        try {
            Date date=new Date();
            PreparedStatement pre=db.getCon().prepareStatement("UPDATE muon SET trang_thai=1 where id_muon=?");
            pre.setInt(1, id);
            pre.executeUpdate();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Muon_sach> getTkSV(String ten, String status){
        List<Muon_sach> list=new ArrayList<>();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT id_muon, id_sach, muon.ma_sv, luot_muon, ngay_muon, ngay_tra, trang_thai " +
                    "FROM muon left join sinh_vien on muon.ma_sv=sinh_vien.ma_sv where ten_sv like '%"+ten+"%' and trang_thai='"+status+"'");
            while (res.next()){
                int id=res.getInt(1);
                int id_sach=res.getInt(2);
                String msv=res.getString(3);
                int luot_muon=res.getInt(4);
                Date bd=res.getDate(5);
                Date kt=res.getDate(6);
                SimpleDateFormat Format=new SimpleDateFormat("dd/MM/yyyy");
                String ngay_muon=Format.format(bd);
                String ngay_tra=Format.format(kt);
                Sach tensach=dbQl_sach.getSach_Id(id_sach);
                Sinh_vien sv=dbQlSinh_vien.getTen_sv(msv);
                Muon_sach muon_sach=new Muon_sach(id, tensach, sv, luot_muon, ngay_muon, ngay_tra, status);
                list.add(muon_sach);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void getThem(Muon_sach muon_sach){
        try {
            PreparedStatement pre=db.getCon().prepareStatement("INSERT INTO muon(id_sach, ma_sv, luot_muon, ngay_tra) VALUES (?,?,?,?)");
            pre.setInt(1, muon_sach.getSach().getId());
            pre.setString(2, muon_sach.getSinh_vien().getMa_sv());
            pre.setInt(3, 0);
            pre.setString(4, muon_sach.getNgay_tra());
            pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int getLuotmuon(String masv){
        int luotmuon=0;
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT luot_muon from muon where ma_sv='"+masv+"'");
            while (res.next()){
                luotmuon=res.getInt(1);
                break;
            }
        }catch (Exception e){
            luotmuon=0;
        }
        return luotmuon;
    }

    public void getUpdateLuot(String masv, int luot){
        try {
            PreparedStatement pre=db.getCon().prepareStatement("UPDATE muon set luot_muon=? where ma_sv=?");
            pre.setInt(1, luot);
            pre.setString(2, masv);
            pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int getIdsach(int id_muon){
        int id=0;
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT id_sach from muon where id_muon='"+id_muon+"'");
            while (res.next()){
                id=res.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return id;
    }

    public static void main(String[] args) {
        DBQl_muon dbQl_muon=new DBQl_muon();
        System.out.println(dbQl_muon.getLuotmuon("B19DCCN005"));
    }
}
