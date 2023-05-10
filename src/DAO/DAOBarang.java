/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.KoneksiDB;
import Model.Barang;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Connection;
import DAOInterface.IDAOBarang;

/**
 *
 * @author kumil
 */
public class DAOBarang implements IDAOBarang{
    
    public DAOBarang()
    {
        con = KoneksiDB.getConnection();
    }

    @Override
    public List<Barang> getAll() {
        List<Barang> lstBrg = null;
        try
        {
            lstBrg = new ArrayList<Barang>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Barang brg = new Barang();
                brg.setID_Barang(rs.getInt("ID_Barang"));
                brg.setNama_Barang(rs.getString("Nama_Barang"));
                brg.setSatuan(rs.getString("Satuan"));
                brg.setHarga(rs.getInt("Harga"));
                brg.setStok(rs.getInt("Stok"));
                lstBrg.add(brg);
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error");
        }
        return lstBrg;
    }
    
    Connection con;
    //SQL Query
    String strRead = "select * from barang;";
    
    
}
