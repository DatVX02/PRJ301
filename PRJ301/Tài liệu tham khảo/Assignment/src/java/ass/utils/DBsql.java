/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBsql {

    public static Connection SQLserver() {
        try {
            String user = "sa";
            String pass = "12345";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=WS_PRJ301";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}
