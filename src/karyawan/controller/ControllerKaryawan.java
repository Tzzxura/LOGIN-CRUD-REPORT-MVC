/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karyawan.controller;

/**
 *
 * 
 * @author zxura
 */

//import
import java.sql.SQLException;
import karyawan.dao.*;
import karyawan.model.*;
import karyawan.view.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerKaryawan {
    KaryawanView fm;
    implementKaryawan impKaryawan;
    List<Karyawan> listKaryawan;
    
    public  ControllerKaryawan(KaryawanView fm) throws SQLException{
        this.fm =fm;
        impKaryawan = new daoKaryawan();
        listKaryawan =impKaryawan.getALL();
    }
    
//    mengosongkan field
    public void reset(){
        fm.getTxtID().setText("");
        fm.getTxtIDAnggota().setText("");
        fm.getTxtNama().setText("");
        fm.getTxtAlamat().setText("");
        fm.getTxtNoTelepon().setText("");

    }
    
//    menampilkan data ke tabel
    public void isiTabel(){
        listKaryawan =impKaryawan.getALL();
        TableModelKaryawan tmk =new TableModelKaryawan(listKaryawan);
        fm.getTabelData().setModel(tmk);
    }
    
    public void isiField(int row){
        fm.getTxtID().setText(listKaryawan.get(row).getId().toString());
        fm.getTxtIDAnggota().setText(listKaryawan.get(row).getIdanggota());
        fm.getTxtNama().setText(listKaryawan.get(row).getNama());
        fm.getTxtAlamat().setText(listKaryawan.get(row).getAlamat());
        fm.getTxtNoTelepon().setText(listKaryawan.get(row).getNotelepon());  

        
    }
    
    public void insert(){
        Karyawan k = new Karyawan();
        k.setIdanggota(fm.getTxtIDAnggota().getText());
        k.setNama(fm.getTxtNama().getText());
        k.setAlamat(fm.getTxtAlamat().getText());
        k.setNotelepon(fm.getTxtNoTelepon().getText());
        k.setId(Integer.parseInt(fm.getTxtID().getText()));
        impKaryawan.insert(k);
        JOptionPane.showMessageDialog(fm, "Data Berhasil di Masukan 🔥");


        
    }
    
    public void update(){
        Karyawan k = new Karyawan();
        k.setIdanggota(fm.getTxtIDAnggota().getText());
        k.setNama(fm.getTxtNama().getText());
        k.setAlamat(fm.getTxtAlamat().getText());
        k.setNotelepon(fm.getTxtNoTelepon().getText());
        k.setId(Integer.parseInt(fm.getTxtID().getText()));
        impKaryawan.update(k);
        JOptionPane.showMessageDialog(fm, "Data Berhasil di update 🔥");
    }
    
    public void delete(){
        if (!fm.getTxtID().getText().trim().isEmpty()) {
            int id= Integer.parseInt(fm.getTxtID().getText());
            impKaryawan.delete(id);
        }else{
            JOptionPane.showMessageDialog(fm, "Pilih data yang akan di Hapus");
        }
    }
    
    public void isiTabelCariAnggota(){
        listKaryawan =impKaryawan.getCariIDAnggota(fm.getTxtCari().getText());
        TableModelKaryawan tmk =new TableModelKaryawan(listKaryawan);
        fm.getTabelData().setModel(tmk);
        
    }
    
    public void CariAnggota(){
        if (!fm.getTxtCari().getText().trim().isEmpty()) {
            impKaryawan.getCariIDAnggota(fm.getTxtCari().getText());
            isiTabelCariAnggota();
        }else{
            JOptionPane.showMessageDialog(fm, "Silahkan Pilih Data !");
        }
    }
}
