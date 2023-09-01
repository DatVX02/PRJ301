/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class UserDAO {

    public List<UserDTO> searchUser(String fullName) throws ClassNotFoundException, SQLException {
        List<UserDTO> userList = new ArrayList<>();
        DBUtils dbu = new DBUtils();

        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [userID], [fullName], [roleID], [status] FROM yourTableName WHERE [fullName] LIKE ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + fullName + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserDTO user = new UserDTO(
                        rs.getString("userID"),
                        rs.getString("fullName"),
                        rs.getString("roleID"),
                        rs.getString("status")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public boolean updateUser(UserDTO updatedUser) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();

        try {
            Connection connection = dbu.getConnection();
            String sql = "UPDATE yourTableName SET [fullName] = ?, [roleID] = ? WHERE [userID] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, updatedUser.getFullName());
            ps.setString(2, updatedUser.getRoleID());
            ps.setString(3, updatedUser.getUserID());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public UserDTO getUserById(String userID) throws ClassNotFoundException, SQLException {
        UserDTO user = null;
        DBUtils dbu = new DBUtils();

        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [userID], [fullName], [roleID], [status] FROM yourTableName WHERE [userID] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserDTO(
                        rs.getString("userID"),
                        rs.getString("fullName"),
                        rs.getString("roleID"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
