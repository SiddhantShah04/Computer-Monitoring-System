/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sony
 */
 


public class Administrator {

       public static void main(String[] args) {
        // TODO code application logic here
        new administratorLogin().setVisible(true);
    }
    
}
