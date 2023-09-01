/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.ItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ItemsDAO {

    public ArrayList<ItemDTO> getItems() {
        ResultSet rs = null;
        ArrayList<ItemDTO> item = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select ItemId, ItemName, Price, Items.CateId ,CateName, status "
                    + " from Items, Categories "
                    + " where Items.CateId= Categories.CateId";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                ItemDTO dto = new ItemDTO(rs.getInt("ItemId"), rs.getString("ItemName"), rs.getInt("Price"), rs.getInt("CateId"), rs.getString("CateName"), rs.getInt("Status"));
                item.add(dto);
            }
        } catch (Exception e) {

        }
        return item;
    }

    public boolean setItems(String key, String name, String price, String CateID) {
        PreparedStatement stm = null;
        int rs = 0;
        try {
            Connection con = DBUtils.getConnection();
            String sql = " UPDATE [dbo].[Items] "
                    + " SET [ItemName]= ? , [Price] = ? , [CateId] = ? "
                    + " WHERE ItemId = ? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, price);
            stm.setString(3, CateID);
            stm.setString(4, key);
            rs = stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (rs > 0) {
                return true;
            }else{
                return false;
            }
        }
    }
}
