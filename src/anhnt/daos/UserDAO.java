/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnt.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import anhnt.utils.MyConnection;

/**
 *
 * @author TRUNG ANH
 */
public class UserDAO implements Serializable{
    public static boolean checkLogin(String userID, String password){
        boolean status = false;
        Connection con = null;
        try {
            con = MyConnection.makeConnection();
            if(con != null){
                String sql = "SELECT status \n" +
                            "FROM tblUsers\n" +
                            "WHERE userID = ? AND password = ? And status = 1";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setString(2, password);
                
                ResultSet rs = pst.executeQuery();
                if(rs.next())
                    status = rs.getBoolean("status");
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
        return status;
    }
    
    public static int doRecord(String sql) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        
        con = MyConnection.makeConnection();
        if(con != null){
            pst = con.prepareStatement(sql);
            result = pst.executeUpdate();
        }
        
        return result;
    }
}
