/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FAQsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class FAQsDAO {

    public ArrayList<FAQsDTO> getCust(String ItemID) throws SQLException {
        ArrayList<FAQsDTO> dto = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            Connection con = DBUtils.DBUtils.getConnection();
            String sql = "select [Id],[CustName],[CustContent],[ItemName]\n"
                    + "FROM [dbo].[FAQ]\n"
                    + "LEFT JOIN [dbo].[Items]\n"
                    + "ON [dbo].[Items].ItemId= [dbo].[FAQ].ItemId \n"
                    + "where [CateId]= ? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, ItemID);
            rs = stm.executeQuery();
        } catch (Exception e) {
        } finally {
            while (rs.next()) {
                FAQsDTO f = new FAQsDTO(rs.getInt("Id"), rs.getString("CustName"), rs.getString("CustContent"), rs.getString("ItemName"));
                dto.add(f);
            }
            return dto;
        }
    }
}
