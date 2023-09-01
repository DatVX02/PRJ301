/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.models.Comestic;
import pe.models.User;

/**
 *
 * @author Admin
 */
public class DAO extends DBUtils {

    public User login(String userID, String password) throws ClassNotFoundException {
        try {
            String sql = "select * from tblUsers where userID = ? and password = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
            }
        } catch (SQLException e) {
            System.out.println("Error login");
        }
        return null;
    }

    public Long create(String fullName, String userID, String email, String password) throws ClassNotFoundException {
        try {
            String sql = "INSERT INTO tblUsers(userID, fullName, password, roleID, status) VALUES(?, ?, ?, ?, 1)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, fullName);
            ps.setString(3, password);
            ps.setString(4, "AD");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Create User");
        }
        return null;
    }

    public void addComestic(String id, String name, String description, double price, int size) throws ClassNotFoundException {
        try {
            String sql = "INSERT INTO tblComestic(id, name, description, price, size, status) VALUES(?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setDouble(4, price);
            ps.setInt(5, size);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Adding Comestic");
        }
    }

    public boolean doesExistName(String name) throws ClassNotFoundException {
        try {
            String sql = "SELECT COUNT(*) FROM tblComestic WHERE name = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // If count > 0, name exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Count Comestic");
        }
        return false;
    }

    public boolean doesExistUser(String userID) throws ClassNotFoundException {
        try {
            String sql = "SELECT COUNT(*) FROM tblUsers WHERE userID = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, userID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // If count > 0, name exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Count Comestic");
        }
        return false;
    }

    public List<Comestic> getAllComestic() throws ClassNotFoundException {
        try {
            List<Comestic> comestics = new ArrayList<>();
            String sql = "SELECT * FROM tblComestic";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                double price = rs.getDouble(4);
                int size = rs.getInt(5);
                boolean status = rs.getBoolean(6);
                Comestic comestic = new Comestic(id, name, description, price, size, status);
                comestics.add(comestic);
            }
            return comestics;
        } catch (SQLException e) {
            System.out.println("Error Count Comestic");
        }
        return null;
    }

    public List<Comestic> getComestic(String keyword) throws ClassNotFoundException {
        try {
            List<Comestic> comestics = new ArrayList<>();
            String sql = " SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[description]\n"
                    + "      ,[price]\n"
                    + "      ,[size]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[tblComestic]\n"
                    + "  where name = ? ";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                double price = rs.getDouble(4);
                int size = rs.getInt(5);
                boolean status = rs.getBoolean(6);
                Comestic comestic = new Comestic(id, name, description, price, size, status);
                comestics.add(comestic);
            }
            return comestics;
        } catch (SQLException e) {
            System.out.println("Error Count Comestic");
        }
        return null;
    }

    public void updateComestic(String id, String name, String description, double price, int size) throws ClassNotFoundException {
        try {
            String sql = "UPDATE tblComestic SET name=?, description=?, price=?, size=? WHERE id=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, size);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update Comestic ERROR");
        }
    }

    public void deleteComestic(String id) throws ClassNotFoundException {
        try {
            String sql = "DELETE FROM tblComestic WHERE id = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Comestic ERROR");
        }
    }
}
