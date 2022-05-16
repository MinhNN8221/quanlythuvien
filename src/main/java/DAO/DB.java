/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MinhNN
 */
public class DB {
    Connection con;
    public DB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ttcs", "root", "a123456");
        } catch (SQLException e) {
            System.out.println("loi SQL");
        }catch(ClassNotFoundException e){
            System.out.println("Loi class");
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public static void main(String[] args) {
        new DB();
    }
}
