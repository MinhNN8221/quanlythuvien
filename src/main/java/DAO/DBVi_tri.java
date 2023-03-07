package DAO;


import Model.Vi_tri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBVi_tri {
    private final DB db=new DB();
    public Vi_tri getVi_tri(int id_vt){
        try {
            Statement st=db.getCon().createStatement();
            ResultSet res=st.executeQuery("SELECT * from ttcs.vi_tri where id_vt='"+id_vt+"'");
            while (res.next()){
                int id=res.getInt(1);
                String ten_vt=res.getString(2);
                Vi_tri vt=new Vi_tri(id, ten_vt);
                return vt;
            }
            return null;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public int getThemvitri(Vi_tri vi_tri){
        int result=0;
        try {
            PreparedStatement pre=db.getCon().prepareStatement("INSERT INTO ttcs.vi_tri(ten_vt) VALUE (?)");
            pre.setString(1, vi_tri.getTen_vt());
            result=pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

}
