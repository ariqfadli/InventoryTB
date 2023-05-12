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

//ikiproject tegar
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
    
    FormBarang frmBarang;
    IDAOBarang iBarang;
    List<Barang> lstBrg;
}
