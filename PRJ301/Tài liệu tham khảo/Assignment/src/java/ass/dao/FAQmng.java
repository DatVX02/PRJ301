/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.dao;

import ass.dto.FAQ;
import ass.dto.Item;
import ass.utils.DBsql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class FAQmng {
    public static void main(String[] args) {
        System.out.println(getList("1"));
    }

    public static LinkedList<FAQ> getList(String ItemId) {
        try {
            Connection conn = DBsql.SQLserver();
            LinkedList<FAQ> list = new LinkedList<>();
            String sql = "SELECT * FROM FAQ WHERE ItemId = " + ItemId;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new FAQ(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
