/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author MinhNN
 */
public class DBLogin {
    private final DB db=new DB();
    public boolean check(String user, String pass){
        try {
            PreparedStatement pre=db.getCon().prepareStatement("SELECT ten_tk, mk from ttcs.nhan_vien where ten_tk=? and mk=?");
            pre.setString(1, user);
            pre.setString(2, pass);
            ResultSet res=pre.executeQuery();
            if(res==null){
                return false;
            }else{
                while(res.next()){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi");
        }
        return false;
    }
    public static void main(String[] args) {
        DBLogin dlBLogin=new DBLogin();
        boolean check=dlBLogin.check("abc", "a123@");
        if(check)
            System.out.println("1");
        else
            System.out.println("2");
    }
}
