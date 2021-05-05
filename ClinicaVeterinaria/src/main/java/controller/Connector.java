/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kairos-04
 */
public class Connector {
    
    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    final String USER = "root";
    final String PASSWORD = "";
    final String HOST = "localhost";
    final String PORT = "3308";
    final String DBNAME = "clinicaveterinariadb";
    final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
    Connection con = null;

    public Connector() {

    }

    public Connection connect(){
        
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: ");
            e.printStackTrace();
            return null;
        }
    }
    
    public void disconnect(){
        
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro: ");
            e.printStackTrace();
        }
    }

}
