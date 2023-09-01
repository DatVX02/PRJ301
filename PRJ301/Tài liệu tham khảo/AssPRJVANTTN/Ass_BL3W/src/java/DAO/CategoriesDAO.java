/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CategoriesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CategoriesDAO {

    public ArrayList<CategoriesDTO> getCateName() throws SQLException {
        ArrayList<CategoriesDTO> dto = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            Connection con = DBUtils.DBUtils.getConnection();
            String sql = " Select [CateId],[CateName],[Status] "
                    + " from [dbo].[Categories] ";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            while(rs.next()){
                CategoriesDTO cate = new CategoriesDTO(rs.getInt("CateId"), rs.getString("CateName"), rs.getInt("Status"));
                dto.add(cate);
            }
            return dto;
        }
    }
}
