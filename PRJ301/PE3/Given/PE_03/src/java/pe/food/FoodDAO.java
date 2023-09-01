/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.utils.DBContext;

/**
 *
 * @author Hoa Doan
 */
public class FoodDAO {

    Connection connect = null;
    PreparedStatement pre = null;
    ResultSet re = null;

    public FoodDTO checkDuplicate(String id) {
        String query = " SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "      ,[price]\n"
                + "      ,[cookingTime]\n"
                + "      ,[status]\n"
                + "  FROM [FoodManagement].[dbo].[tblFoods]\n"
                + "  where id LIKE ?";
        try {
            connect = new DBContext().getConnection();
            pre = connect.prepareStatement(query);
            pre.setString(1, id);
            re = pre.executeQuery();
            while (re.next()) {
                return new FoodDTO(re.getString(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5), re.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addNewProduct(String id, String name, String des, String price, String time) {
        String query = "INSERT INTO tblFoods\n"
                + "VALUES (?,?,?,?,?,'1')";
        try {
            connect = new DBContext().getConnection();
            pre = connect.prepareStatement(query);
            pre.setString(1, id);
            pre.setString(2, name);
            pre.setString(3, des);
            pre.setString(4, price);
            pre.setString(5, time);
            re = pre.executeQuery();
        } catch (Exception e) {
        }
    }
}
