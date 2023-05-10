/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import Model.Barang;
import Model.TabelModelBarang;
import View.FormBarang;
import java.util.List;
import DAOInterface.IDAOBarang;
import javax.swing.JOptionPane;


/**
 *
 * @author kumil
 */
public class ControllerBarang {
    public ControllerBarang(FormBarang frmBarang)
    {
        this.frmBarang = frmBarang;
        iBarang = new DAOBarang();
    }
    
    public void isiTable()
    {
        lstBrg = iBarang.getAll();
        TabelModelBarang tabelBrg = new TabelModelBarang(lstBrg);
        frmBarang.getTabelData().setModel(tabelBrg);
    }
    
    public void Insert()
    {
         Barang b = new Barang();
         b.setID_Barang(Integer.parseInt(frmBarang.gettxtID_Barang().getText()));
         b.setNama_Barang(frmBarang.gettxtNama_Barang().getText());
         b.setSatuan(frmBarang.gettxtSatuan().getText());
         b.setHarga(Integer.parseInt(frmBarang.gettxtHarga().getText()));
         b.setStok(Integer.parseInt(frmBarang.gettxtStok().getText()));
         iBarang.insert(b);
         JOptionPane.showMessageDialog(null, "Input berhasil");
    }
    
    public void reset()
    {
        if(!frmBarang.gettxtID_Barang().isEnabled())
            frmBarang.gettxtID_Barang().setEnabled(true);
        frmBarang.gettxtID_Barang().setText("");
        frmBarang.gettxtNama_Barang().setText("");
        frmBarang.gettxtSatuan().setText("");
        frmBarang.gettxtHarga().setText("");
        frmBarang.gettxtStok().setText("");
    }
    
    public void isiField(int row)
    {
        frmBarang.gettxtID_Barang().setEnabled(false);
        frmBarang.gettxtID_Barang().setText(lstBrg.get(row).getID_Barang().toString());
        frmBarang.gettxtNama_Barang().setText(lstBrg.get(row).getNama_Barang());
        frmBarang.gettxtSatuan().setText(lstBrg.get(row).getSatuan());
        frmBarang.gettxtHarga().setText(lstBrg.get(row).getHarga().toString());
        frmBarang.gettxtStok().setText(lstBrg.get(row).getStok().toString());
    }
    
    public void update()
    {
         Barang b = new Barang();
         b.setNama_Barang(frmBarang.gettxtNama_Barang().getText());
         b.setSatuan(frmBarang.gettxtSatuan().getText());
         b.setHarga(Integer.parseInt(frmBarang.gettxtHarga().getText()));
         b.setStok(Integer.parseInt(frmBarang.gettxtStok().getText()));
         b.setID_Barang(Integer.parseInt(frmBarang.gettxtID_Barang().getText()));
         iBarang.update(b);
         JOptionPane.showMessageDialog(null, "Update berhasil");
    }
    
    public void delete()
    {
         Barang b = new Barang();
         iBarang.delete(Integer.parseInt(frmBarang.gettxtID_Barang().getText()));
         JOptionPane.showMessageDialog(null, "Delete berhasil");
    }
    FormBarang frmBarang;
    IDAOBarang iBarang;
    List<Barang> lstBrg;
}
