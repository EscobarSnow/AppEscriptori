/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escobarsnow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author JO
 */
public class ConnexioBD {
    
    public static void connbd() throws SQLException{
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
        
    }
}
