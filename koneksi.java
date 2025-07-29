
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubes_tiket;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Asus Rog flow
 */
public class koneksi {
    
    private static Connection koneksi;
    
    public static Connection getkoneksi(){
        if (koneksi==null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                koneksi=DriverManager.getConnection("jdbc:mysql://localhost/tubes", "root", "");
                System.out.println("Database Connect");
            }catch (Exception e){
                System.out.println("Database Tidak Connect");
            }
        }
        return koneksi;
        
    }
    
    public static void main(String[] args) {
        koneksi test = new koneksi();
        test.getkoneksi();
        System.exit(0);
    }
    
}
