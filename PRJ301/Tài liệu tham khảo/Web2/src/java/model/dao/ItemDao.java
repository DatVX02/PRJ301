/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.dto.Category;
import model.dto.Item;
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class ItemDao {
    //ham nay de lay all items dua vao ma loai
    public static ArrayList<Item> getItems(int maloai) throws Exception{
        ArrayList<Item> kq=new ArrayList<>();
        Connection cn=DBUtil.makeConnection();
        if(cn!=null){
            String s = "select ItemId,ItemName,Price,CateId\n"
                    + "from dbo.Items\n"
                    + "where CateId=?";
            PreparedStatement pst=cn.prepareStatement(s);
            pst.setInt(1, maloai);
            ResultSet rs=pst.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    int a=rs.getInt("ItemId");
                    String b=rs.getString("ItemName");
                    int c=rs.getInt("Price");
                    int d=rs.getInt("CateId");
                    //lay catename dua vao cateid(d)
                    s = "select CateId,CateName,Status\n"
                            + "from dbo.Categories\n"
                            + "where CateId=?";
                    pst=cn.prepareStatement(s);
                    pst.setInt(1, d);
                    ResultSet tmp=pst.executeQuery();
                    if(tmp!=null && tmp.next()){
                        int cateid=tmp.getInt("CateId");
                        String catename=tmp.getString("CateName");
                        int status=tmp.getInt("Status");
                        Category cate=new Category(cateid, catename, status);
                        Item it=new Item(a, b, c, cate);
                        kq.add(it);
                    }
                    
                }
            }
            cn.close();
        }
        return kq;
    }
}
