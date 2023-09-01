/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.dao;

import ass.dto.Categorie;
import ass.dto.Item;
import ass.utils.DBsql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class ItemMng {

    public static void main(String[] args) {
        updateItem(new Item("1", "sos", 1, "1"));
    }

    public static LinkedList<Item> getList() {
        try {
            Connection conn = DBsql.SQLserver();
            LinkedList<Item> list = new LinkedList<>();
            String sql = "SELECT * FROM Items";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void updateItem(Item item) {
        try {
            Connection conn = DBsql.SQLserver();
            LinkedList<Item> list = new LinkedList<>();
            String sql = "UPDATE Items "
                    + "SET"
                    + " ItemName = '" + item.getItemName() + "'"
                    + ", Price = " + item.getPrice()
                    + ", CateId = " + item.getCateId()
                    + " WHERE ItemId = " + item.getItemId();
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Item getItem(String ItemId) {
        try {
            Connection conn = DBsql.SQLserver();
            String sql = "SELECT * FROM Items WHERE ItemId=" + ItemId;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                return new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static String getCateName(String CateId) {
        try {
            Connection conn = DBsql.SQLserver();
            String sql = "SELECT CateName FROM Categories WHERE CateId=" + CateId;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static LinkedList<Categorie> getCateList() {
        try {
            Connection conn = DBsql.SQLserver();
            LinkedList<Categorie> list = new LinkedList<>();
            String sql = "SELECT * FROM Categories";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Categorie(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
