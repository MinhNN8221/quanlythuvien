package DAO;

import Model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DBQl_sach {
    private final DB db=new DB();
    private DBLoai_sach dbLoai_sach=new DBLoai_sach();
    private DBVi_tri dbVi_tri= new DBVi_tri();
    private DBTac_gia dbTac_gia=new DBTac_gia();
    public List<Sach> getAllsach(){
        List<Sach> res=new ArrayList<>();
        Nhan_vien nhan_vien=new Nhan_vien();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * FROM ttcs.sach");
            while (resultSet.next()){
                int id=resultSet.getInt("id_sach");
                int id_ls=resultSet.getInt("id_loai_sach");
                int id_vt=resultSet.getInt("id_vt");
                int id_tg=resultSet.getInt("id_tac_gia");
                String ten=resultSet.getString("ten_sach");
                int sl_bd=resultSet.getInt("solg_bd");
                int sl_cl=resultSet.getInt("solg_clai");
                int id_nv=resultSet.getInt("id_nv");
                Loai_sach ls=dbLoai_sach.getLoai_sach(id_ls);
                Vi_tri vt=dbVi_tri.getVi_tri(id_vt);
                Tac_gia tg=dbTac_gia.getTen_tg(id_tg);
                nhan_vien.setId_nv(id_nv);
                Sach sach=new Sach(id, ls, vt, tg, ten, sl_bd, sl_cl, nhan_vien);
                res.add(sach);
            }
            Collections.sort(res, Comparator.comparing(Sach::getSl_cl));
            return res;
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public Sach getSach_Id(int id_sach){
        Nhan_vien nhan_vien=new Nhan_vien();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * FROM ttcs.sach where id_sach='"+id_sach+"'");
            while (resultSet.next()){
                int id=resultSet.getInt("id_sach");
                int id_ls=resultSet.getInt("id_loai_sach");
                int id_vt=resultSet.getInt("id_vt");
                int id_tg=resultSet.getInt("id_tac_gia");
                String ten=resultSet.getString("ten_sach");
                int sl_bd=resultSet.getInt("solg_bd");
                int sl_cl=resultSet.getInt("solg_clai");
                int id_nv=resultSet.getInt("id_nv");
                Loai_sach ls=dbLoai_sach.getLoai_sach(id_ls);
                Vi_tri vt=dbVi_tri.getVi_tri(id_vt);
                Tac_gia tg=dbTac_gia.getTen_tg(id_tg);
                nhan_vien.setId_nv(id_nv);
                Sach sach=new Sach(id, ls, vt, tg, ten, sl_bd, sl_cl, nhan_vien);
                return sach;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public List<Loai_sach> getLoaisach(){
        List<Loai_sach> list=new ArrayList<>();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * FROM ttcs.loai_sach");
            while (resultSet.next()){
                int id_ls=resultSet.getInt(1);
                String ten_ls=resultSet.getString(2);;
                Loai_sach ls=new Loai_sach(id_ls, ten_ls);
                list.add(ls);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public List<Vi_tri> getVi_tri(){
        List<Vi_tri> list=new ArrayList<>();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * FROM ttcs.vi_tri");
            while (resultSet.next()){
                int id_vt=resultSet.getInt(1);
                String ten_vt=resultSet.getString(2);
                Vi_tri vt=new Vi_tri(id_vt, ten_vt);
                list.add(vt);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public List<Tac_gia> getTac_gia(){
        List<Tac_gia> list=new ArrayList<>();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * FROM ttcs.tac_gia");
            while (resultSet.next()){
                int id_tg=resultSet.getInt(1);
                String ten_tg=resultSet.getString(2);
                String diachi=resultSet.getString(3);
                Tac_gia tg=new Tac_gia(id_tg, ten_tg, diachi);
                list.add(tg);
            }
            return list;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void getUpdate(Sach sach){
        try {
            String sql="update ttcs.sach set id_loai_sach=?, id_vt=?, id_tac_gia=?, ten_sach=?, solg_bd=?, solg_clai=?, id_vt=1 where id_sach=?";
            PreparedStatement pre=db.getCon().prepareStatement(sql);
            pre.setInt(1, sach.getLoai_sach().getId_ls());
            pre.setInt(2, sach.getVi_tri().getId_vt());
            pre.setInt(3, sach.getTac_gia().getId_tg());
            pre.setString(4, sach.getTen_sach());
            pre.setInt(5, sach.getSl_bd());
            pre.setInt(6, sach.getSl_cl());
            pre.setInt(7, sach.getId());
            pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public boolean getXoasach(int id_sach){
        try {
            Statement st=db.getCon().createStatement();
            st.executeUpdate("DELETE from ttcs.sach where id_sach='"+id_sach+"'");
            return true;
        }catch (Exception e){
            return false;
//            System.out.println(e);
        }
    }
    public List<Sach> getTimkiem(String ten_sach){
        List<Sach> list=new ArrayList<>();
        Nhan_vien nhan_vien=new Nhan_vien();
        try{
            Statement st= db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * from ttcs.sach where ten_sach like '%"+ten_sach+"%'");
            while (resultSet.next()){
                int id=resultSet.getInt("id_sach");
                int id_ls=resultSet.getInt("id_loai_sach");
                int id_vt=resultSet.getInt("id_vt");
                int id_tg=resultSet.getInt("id_tac_gia");
                String ten=resultSet.getString("ten_sach");
                int sl_bd=resultSet.getInt("solg_bd");
                int sl_cl=resultSet.getInt("solg_clai");
                int id_nv=resultSet.getInt("id_nv");
                nhan_vien.setId_nv(id_nv);
                Loai_sach ls=dbLoai_sach.getLoai_sach(id_ls);
                Vi_tri vt=dbVi_tri.getVi_tri(id_vt);
                Tac_gia tg=dbTac_gia.getTen_tg(id_tg);
                Sach sach=new Sach(id, ls, vt, tg, ten, sl_bd, sl_cl, nhan_vien);
                list.add(sach);
            }
            Collections.sort(list, Comparator.comparing(Sach::getSl_cl));
            return list;
        }catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }
    public int getThemsach(Sach sach){
        int result=0;
        try {
            PreparedStatement pre=db.getCon().prepareStatement("INSERT INTO ttcs.sach(id_loai_sach, id_vt, id_tac_gia, ten_sach, solg_bd, solg_clai, id_nv) VALUE (?, ?, ?, ?, ?, ?, ?)");
            pre.setInt(1, sach.getLoai_sach().getId_ls());
            pre.setInt(2, sach.getVi_tri().getId_vt());
            pre.setInt(3, sach.getTac_gia().getId_tg());
            pre.setString(4, sach.getTen_sach());
            pre.setInt(5, sach.getSl_bd());
            pre.setInt(6, sach.getSl_cl());
            pre.setInt(7, sach.getNhan_vien().getId_nv());
            result=pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public void getUpdateSlg(int solg, int id){
        try {
            PreparedStatement pre=db.getCon().prepareStatement("UPDATE ttcs.sach set solg_clai=? where id_sach=?");
            pre.setInt(1, solg);
            pre.setInt(2, id);
            pre.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int getSlgclai(int id){
        int slg=0;
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT solg_clai from ttcs.sach where id_sach='"+id+"'");
            while (resultSet.next()){
                slg=resultSet.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return slg;
    }

    public Tac_gia getTac_gia1(String ten){
        Tac_gia tac_gia=new Tac_gia();
        try {
            Statement st=db.getCon().createStatement();
            ResultSet resultSet=st.executeQuery("SELECT * FROM ttcs.tac_gia where ten_tac_gia ='"+ten+"'");
            while (resultSet.next()){
                int id_tg=resultSet.getInt(1);
                String ten_tg=resultSet.getString(2);
                String diachi=resultSet.getString(3);
                Tac_gia tg=new Tac_gia(id_tg, ten_tg, diachi);
                tac_gia.setId_tg(id_tg);
                tac_gia.setTen_tg(ten_tg);
                tac_gia.setDia_chi(diachi);
            }
            return tac_gia;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        DBQl_sach dbQl_sach=new DBQl_sach();
        Loai_sach loai_sach=new Loai_sach();
        Tac_gia tac_gia=new Tac_gia();
        Vi_tri vi_tri=new Vi_tri();
        Nhan_vien nhan_vien=new Nhan_vien();
//        sach.setTen_sach("tensach");
        loai_sach.setId_ls(1);
//        sach.setLoai_sach(loai_sach);
        tac_gia.setId_tg(2);
//        sach.setTac_gia(tac_gia);
        vi_tri.setId_vt(3);
//        sach.setVi_tri(vi_tri);
//        sach.setSl_bd(20);
//        sach.setSl_cl(15);
        nhan_vien.setId_nv(1);
//        sach.setNhan_vien(nhan_vien);
        Sach sach=new Sach(4, loai_sach, vi_tri, tac_gia, "tên sách", 20, 15, nhan_vien);
        dbQl_sach.getThemsach(sach);



        Tac_gia tac_gia1=dbQl_sach.getTac_gia1("Nguyễn Đức Nghĩa");
        System.out.println(tac_gia1.getDia_chi());
    }
}
