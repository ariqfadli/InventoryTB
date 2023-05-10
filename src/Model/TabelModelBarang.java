package Model;


import javax.swing.table.AbstractTableModel;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kumil
 */
public class TabelModelBarang extends AbstractTableModel{
    
    public TabelModelBarang(List<Barang> lstBrg)
    {
        this.lstBrg = lstBrg;
    }
    @Override
    public int getRowCount() {
        return this.lstBrg.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID_Barang";
            case 1:
                return "Nama_Barang";
            case 2:
                return "Satuan";
            case 3:
                return "Harga";
            case 4:
                return "Stok";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lstBrg.get(rowIndex).getID_Barang();
            case 1:
                return lstBrg.get(rowIndex).getNama_Barang();
            case 2:
                return lstBrg.get(rowIndex).getSatuan();
            case 3:
                return lstBrg.get(rowIndex).getHarga();
            case 4:
                return lstBrg.get(rowIndex).getStok();
            default:
                return null;
        }
    }
    
    List<Barang> lstBrg;
}
