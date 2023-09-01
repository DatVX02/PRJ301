/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mylib.DBUtil;

/**
 *
 * @author ACER
 */
public class FAQDao {
    public void setFAQ̣̣̣̣̣̣̣(String ten, String noidung, String ID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int rs = 0;
        try {
            con = DBUtil.makeConnection();
            String sql = "insert into [dbo].[FAQ]\n"
                    + "values (  ? , ? , ? )";
            stm = con.prepareStatement(sql);
            stm.setString(1, ten);
            stm.setString(2, noidung);
            stm.setString(3, ID);
            rs = stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
