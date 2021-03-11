/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnt.daos;

import anhnt.dtos.SupplierDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import anhnt.utils.MyConnection;

/**
 *
 * @author TRUNG ANH
 */
public class SupplierDAO {
    public static Vector<SupplierDTO> getSuppliers(){
        Vector<SupplierDTO> v = new Vector<>();
        Connection con = null;
        try {
            con = MyConnection.makeConnection();
            if(con != null){
                String sql = "SELECT supCode, supName, address, collaborating\n" +
                             "FROM tblSuppliers";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    String supCode = rs.getString("supCode");
                    String supName = rs.getString("supName");
                    String address = rs.getString("address");
                    boolean collaborating = rs.getBoolean("collaborating");
                    v.add(new SupplierDTO(supCode, supName, address, collaborating));
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
    
    public static Vector<String> getSupcode(){
        Vector<String> v = new Vector<>();
        Connection con = null;
        try {
            con = MyConnection.makeConnection();
            if(con != null){
                String sql = "SELECT supCode\n" +
                             "FROM tblSuppliers\n" +
                             "WHERE collaborating = 1";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    String supCode = rs.getString("supCode");
                    v.add(supCode);
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
    public static Vector<String> getSupname(){
        Vector<String> v = new Vector<>();
        Connection con = null;
        try {
            con = MyConnection.makeConnection();
            if(con != null){
                String sql = "SELECT supName\n" +
                             "FROM tblSuppliers\n" +
                             "WHERE collaborating = 1";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    String supCode = rs.getString("supName");
                    v.add(supCode);
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
