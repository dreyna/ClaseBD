/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alum.fial1
 */
public class Conexion {
    private final static String url="jdbc:mysql://localhost:3306/bd_almacen";
    private final static String user="root";
    private final static String pas="root";
    private final static String driver="com.mysql.jdbc.Driver";
    private static Connection conex=null;
    public static Connection getConexion(){
        try {
            Class.forName(driver);
            conex = DriverManager.getConnection(url, user, pas);
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    
    return conex;
    }
    
    
}
