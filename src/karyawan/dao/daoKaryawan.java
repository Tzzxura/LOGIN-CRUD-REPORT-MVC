/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karyawan.dao;
import java.util.logging.Logger;
import java.util.logging.Level;
import karyawan.koneksi.Koneksi;
import karyawan.model.Karyawan;
import java.sql.*;
import java.util.*;
/**
 *
 * 
 * @author zxura
 */
public class daoKaryawan implements implementKaryawan{
    
    
    Connection connection;
    
    final String insert ="INSERT INTO tb_karyawan (IDANGGOTA, NAMA, ALAMAT,TELEPON) VALUES (?,?,?,?)";
    final String update ="UPDATE tb_karyawan SET IDANGGOTA=?, NAMA=?, ALAMAT=?, TELEPON=? WHERE ID=?";
    final String delete ="DELETE FROM tb_karyawan WHERE ID=?";
    final String select ="SELECT * FROM tb_karyawan";
    final String cariAnggota ="SELECT * FROM tb_karyawan WHERE IDANGGOTA LIKE ?";

    public daoKaryawan() throws SQLException{
        connection=Koneksi.connection();
    }

    @Override
    public void insert(Karyawan karyawan) {
        PreparedStatement statement =null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, karyawan.getIdanggota());
            statement.setString(2, karyawan.getNama());
            statement.setString(3, karyawan.getAlamat());
            statement.setString(4, karyawan.getNotelepon());
            
            statement.executeUpdate();
            ResultSet rs =statement.getGeneratedKeys();
            
            while(rs.next()){
                karyawan.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public void update(Karyawan karyawan) {
        PreparedStatement statement =null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, karyawan.getIdanggota());
            statement.setString(2, karyawan.getNama());
            statement.setString(3, karyawan.getAlamat());
            statement.setString(4, karyawan.getNotelepon());
            statement.setInt(5, karyawan.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public void delete(int id) {
        
        PreparedStatement statement =null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
 
            statement.executeUpdate();
     
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public List<Karyawan> getALL() {
        List<Karyawan> listKaryawan=null;
        try {
            listKaryawan= new ArrayList<Karyawan>();
            Statement st= connection.createStatement();
            ResultSet rs= st.executeQuery(select);
            
            while (rs.next()) {
                Karyawan karyawan =new Karyawan();
                karyawan.setId(rs.getInt("ID"));
                karyawan.setIdanggota(rs.getString("IDANGGOTA"));
                karyawan.setNama(rs.getString("NAMA"));
                karyawan.setAlamat(rs.getString("ALAMAT"));
                karyawan.setNotelepon(rs.getString("TELEPON"));
                listKaryawan.add(karyawan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoKaryawan.class.getName()).log(Level.SEVERE,null,ex);
        }
        return listKaryawan;
    }

    @Override
    public List<Karyawan> getCariIDAnggota(String idanggota) {
        List<Karyawan> listKaryawan=null;
        try {
            listKaryawan= new ArrayList<Karyawan>();
            PreparedStatement st= connection.prepareStatement(cariAnggota);
            st.setString(1,"%" + idanggota +"%");
            ResultSet rs= st.executeQuery();
            
            while (rs.next()) {
                Karyawan karyawan =new Karyawan();
                karyawan.setId(rs.getInt("ID"));
                karyawan.setIdanggota(rs.getString("IDANGGOTA"));
                karyawan.setNama(rs.getString("NAMA"));
                karyawan.setAlamat(rs.getString("ALAMAT"));
                karyawan.setNotelepon(rs.getString("TELEPON"));
                listKaryawan.add(karyawan);
                

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoKaryawan.class.getName()).log(Level.SEVERE,null,ex);
        }
        return listKaryawan;
    }
    
}
