/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lastproject;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author SHIRAF
 */
public class mysqlconnect {
    Connection con = null;
    public static Connection connectDB(){
        try{
            
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Cot_project","root","admin");
        //JOptionPane.showMessageDialog(null,"Database connected");
        return con;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Database not connected");
            return null;
            
        }

    }
    
}
