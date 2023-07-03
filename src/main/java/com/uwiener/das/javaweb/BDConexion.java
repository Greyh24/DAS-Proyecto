package com.uwiener.das.javaweb;

import com.sun.org.apache.bcel.internal.classfile.ElementValue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BDConexion {
  public static Connection initializeDatabases() throws ClassNotFoundException, SQLException {
      String url = "jdbc:mysql://localhost:3306/bd_s";
      String username = "root";
      String password = "";
      
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection cnx = DriverManager.getConnection(url , username, password);
    if (cnx.isValid(2)) { // 2 segundos de tiempo de espera para la verificación
            System.out.println("Conexión a la base de datos válida.");
        } else {
            System.out.println("Conexión a la base de datos no válida.");
        }
    return cnx;
}
    
}
