/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package karyawan.dao;
import java.util.List;
import karyawan.model.*;
/**
 *
 * @author zxura
 */
public interface implementKaryawan {
    public void insert(Karyawan karyawan);
    
    public void update(Karyawan karyawan);
    
    public void delete(int id);
    
    public List<Karyawan> getALL();
    
    public List<Karyawan> getCariIDAnggota(String idanggota);
}
