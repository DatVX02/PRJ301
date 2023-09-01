/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.models.User;

/**
 *
 * @author ACER
 */
public class DAO {
    public User login(String userID, String password) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        try {           
              Connection connection = dbu.getConnection();
            String sql = "select * from tblUsers where userID = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("Error login");
        }
        return null;
    }
}
