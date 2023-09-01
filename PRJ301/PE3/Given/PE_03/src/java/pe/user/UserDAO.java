/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.utils.DBContext;

/**
 *
 * @author nguye
 */
public class UserDAO {

    Connection connect = null;
    PreparedStatement pre = null;
    ResultSet re = null;
//
//    public UserDTO checkDuplicate(String userID) {
//        String query = "   SELECT [userID]\n"
//                + "      ,[fullName]\n"
//                + "      ,[roleID]\n"
//                + "      ,[password]\n"
//                + "  FROM [FoodManagement].[dbo].[tblUsers]\n"
//                + "  where userID LIKE ?";
//        try {
//            connect = new DBUtils().getConnection();
//            pre = connect.prepareStatement(query);
//            pre.setString(1, userID);
//            re = pre.executeQuery();
//            while (re.next()) {
//                return new UserDTO(re.getString(1), re.getString(2), re.getString(3), re.getString(4));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }

    public UserDTO login(String userID, String pass) {
        String query = "   SELECT [userID]\n"
                + "      ,[fullName]\n"
                + "      ,[roleID]\n"
                + "      ,[password]\n"
                + "  FROM [FoodManagement].[dbo].[tblUsers]\n"
                + "  where userID LIKE ? and password LIKE ?";
        try {
            connect = new DBContext().getConnection();
            pre = connect.prepareStatement(query);
            pre.setString(1, userID);
            pre.setString(2, pass);
            re = pre.executeQuery();
            while (re.next()) {
                return new UserDTO(re.getString(1), re.getString(2), re.getString(3), re.getString(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    
}
