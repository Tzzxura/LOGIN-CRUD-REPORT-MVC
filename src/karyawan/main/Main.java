/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package karyawan.main;
//import javax.swing.SwingConstants;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import karyawan.view.*;
import java.sql.DriverManager;

/**
 *
 * @author zxura
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
       SwingUtilities.invokeLater(() -> {
            
           LoginKaryawan Frame;
           Frame = new LoginKaryawan();
           Frame.setVisible(true);
           Frame.setLocationRelativeTo(null);
           
           
        }); 
       
       
       
       
    }  
}
