/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.models.User;
import pe.utils.DBUtils;

/**
 *
 * @author Hoa Doan
 */
public class FoodDAO {

    public boolean addFood(String id, String name, String description, String price, String cookingtime, boolean status) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        try {
            Connection connection = dbu.getConnection();
            String sql = "INSERT INTO [dbo].[tblFoods]\n"
                    + "           ([id]\n"
                    + "           ,[name]\n"
                    + "           ,[description]\n"
                    + "           ,[price]\n"
                    + "           ,[cookingTime]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, price);
            ps.setString(5, cookingtime);
            ps.setBoolean(6, status);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error insert");
        }
        return false;
    }

    public ArrayList<FoodDTO> getALLFood() throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        ArrayList<FoodDTO> list = new ArrayList<>();
        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[description]\n"
                    + "      ,[price]\n"
                    + "      ,[cookingTime]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[tblFoods]\n"
                    + "  where status = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FoodDTO dto = new FoodDTO(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("price"), rs.getInt("cookingTime"), true);
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("Error list Food");
        }
        return list;
    }

    public boolean deleteFood(String foodID) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        try {
            Connection connection = dbu.getConnection();
            String sql = "DELETE FROM [dbo].[tblFoods]\n"
                    + "      WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, foodID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error login");
        }
        return false;
    }

    public List<FoodDTO> searchFood(String name) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        ArrayList<FoodDTO> list = new ArrayList<>();
        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[description]\n"
                    + "      ,[price]\n"
                    + "      ,[cookingTime]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[tblFoods]\n"
                    + "  where name = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FoodDTO dto = new FoodDTO(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("price"), rs.getInt("cookingTime"), true);
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("Error list Food");
        }
        return list;
    }

    public boolean updateFood(FoodDTO updatedFood) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        try {
            Connection connection = dbu.getConnection();
            String sql = "UPDATE [dbo].[tblFoods]\n"
                    + "   SET [id] = ?\n"
                    + "      ,[name] = ?\n"
                    + "      ,[description] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[cookingTime] = ?\n"
                    + "      ,[status] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, updatedFood.getId());
            ps.setString(2, updatedFood.getName());
            ps.setString(3, updatedFood.getDescription());
            ps.setInt(4, updatedFood.getPrice());
            ps.setInt(5, updatedFood.getCookingtime());
            ps.setBoolean(6, updatedFood.isStatus());
            ps.setString(7, updatedFood.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error insert");
        }
        return false;
    }

    public FoodDTO getFoodById(String foodId) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        FoodDTO list = new FoodDTO();
        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[description]\n"
                    + "      ,[price]\n"
                    + "      ,[cookingTime]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[tblFoods]\n"
                    + "  where id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, foodId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list = new FoodDTO(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("price"), rs.getInt("cookingTime"), true);
            }
        } catch (SQLException e) {
            System.out.println("Error list Food");
        }
        return list;
    }

}
