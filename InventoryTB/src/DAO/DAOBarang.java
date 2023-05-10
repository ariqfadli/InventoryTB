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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public void insert(Barang b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1 , b.getID_Barang());
            statement.setString(2 , b.getNama_Barang());
            statement.setString(3 , b.getSatuan());
            statement.setInt(4 , b.getHarga());
            statement.setInt(5 , b.getStok());
            statement.execute();
        }catch(SQLException x)
        {
            System.out.println("gagal input");

        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("gagal inputt");
            }
        }
    }
   
    @Override
    public void update(Barang b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1 , b.getNama_Barang());
            statement.setString(2 , b.getSatuan());
            statement.setInt(3 , b.getHarga());
            statement.setInt(4 , b.getStok());
            statement.setInt(5 , b.getID_Barang());
            statement.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println("gagal update");

        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException x) {
                System.out.println("gagal updatee");
            }
        }
    }
    
    @Override
    public void delete(int ID_Barang) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1 , ID_Barang);
            statement.executeUpdate();
        }catch(SQLException x)
        {
            System.out.println("gagal delete");

        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("gagal deletee");
            }
        }
    }
    
    Connection con;
    //SQL Query
    String strRead = "select * from barang;";
    String strInsert = "insert into barang(ID_Barang, Nama_Barang, Satuan, Harga, Stok) values(?,?,?,?,?);";
    String strUpdate = "update barang set Nama_Barang=?, Satuan=?, Harga=?, Stok=? where ID_Barang=?";
    String strDelete = "delete from barang where ID_Barang=?";
    

}
