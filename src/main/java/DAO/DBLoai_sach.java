package DAO;

import Model.Loai_sach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBLoai_sach {
    private final DB db=new DB();
    public Loai_sach getLoai_sach(int id){
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT * FROM ttcs.loai_sach where id_loai_sach='"+id+"'");
            while (res.next()) {
                int id1 = res.getInt(1);
                String ten_loai_sach = res.getString(2);
                Loai_sach ls = new Loai_sach(id1, ten_loai_sach);
                return ls;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public int getThemloaisach(Loai_sach loai_sach){
        int result=0;
        try {
            PreparedStatement pre=db.getCon().prepareStatement("INSERT INTO ttcs.loai_sach(ten_loai_sach) VALUE (?)");
            pre.setString(1, loai_sach.getTen_ls());
            result=pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    public static void main(String[] args) {
    }
}
