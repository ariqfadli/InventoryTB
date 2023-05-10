/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Barang;
import java.util.List;

/**
 *
 * @author kumil
 */
public interface IDAOBarang {
    //read
    public List<Barang> getAll();
    //insert
    public void insert(Barang b);
    //update
    public void update(Barang b);
    //delete
    public void delete(int ID_Barang);  
}
