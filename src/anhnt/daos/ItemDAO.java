/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnt.daos;

import anhnt.dtos.ItemDTO;
import anhnt.dtos.SupplierDTO;
import anhnt.dtos.SuppliersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.function.Supplier;
import javax.swing.JOptionPane;
import anhnt.utils.MyConnection;

/**
 *
 * @author TRUNG ANH
 */
public class ItemDAO {
    public static Vector<ItemDTO> getItems(){
       Vector<ItemDTO> v = new Vector<>();
       Connection con = null;
      
        try {
            con = MyConnection.makeConnection();
            if(con != null){
                String sql = "SELECT itemCode, itemName, unit, price, supplying, tblSuppliers.supCode, tblSuppliers.supName\n" +
                             "FROM tblItems\n" +
                            "INNER JOIN tblSuppliers ON tblItems.supCode = tblSuppliers.supCode ";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    String itemCode = rs.getString("itemCode");
                    String itemName = rs.getString("itemName");
                    float price = rs.getFloat("price");
                    boolean supplying = rs.getBoolean("supplying");
                    String supCode = rs.getString("supCode");
                    String supName = rs.getString("supName");
                    String unit = rs.getString("unit");
                    v.add(new ItemDTO(supCode, itemCode, itemName, unit, supName, price, supplying));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                if(con != null)
                    con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return v;
    }
}
