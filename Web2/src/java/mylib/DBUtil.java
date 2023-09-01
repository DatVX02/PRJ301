/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class DBUtil {
    //ham nay de lam buoc ket noi project voi DB
    public static Connection makeConnection() throws Exception{
       Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=WS_PRJ301";
        conn= DriverManager.getConnection(url, "sa", "12345");
        return conn; 
    }
}
