/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karyawan.model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zxura
 */
public class TableModelKaryawan extends AbstractTableModel{
    List<Karyawan> listKaryawan;
    
    public TableModelKaryawan(List<Karyawan> listKaryawan){
        this.listKaryawan=listKaryawan;
    }

    @Override
    public int getRowCount() {
        return listKaryawan.size();
    }

    @Override
    public int getColumnCount() {
        return 5;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "IDANGGOTA";
            case 2:
                return "NAMA";
            case 3:
                return "ALAMAT";
            case 4:
                return "TELEPON";    
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listKaryawan.get(rowIndex).getId();
            case 1:
                return listKaryawan.get(rowIndex).getIdanggota();
            case 2:
                return listKaryawan.get(rowIndex).getNama();
            case 3:
                return listKaryawan.get(rowIndex).getAlamat();
            case 4:
                return listKaryawan.get(rowIndex).getNotelepon();
            default:
                return null;
        }
    }   
}
