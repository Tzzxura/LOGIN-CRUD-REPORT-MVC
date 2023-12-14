/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karyawan.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
/**
 *
 * @author zxura
 */
public class Koneksi {
    static Connection con;
    
    public static Connection connection()throws SQLException{
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");

            //4. Buat variabel untuk menampung nama db, user, dan password
            String db = "jdbc:mysql://localhost:3306/db_karyawan?serverTimezone=Asia/Jakarta";
            String user = "root";
            String password = "";
            
            //5.Melakukan koneksi 
            con = DriverManager.getConnection(db, user, password);
            
            //6. pesan berhasil
            JOptionPane.showMessageDialog(null, "Berhasil 🔥", "🔥🔥🔥 Success 🔥🔥🔥 ", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            //pesan jika gagal
            JOptionPane.showMessageDialog(null, "Gagal", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return con;
    }
}

