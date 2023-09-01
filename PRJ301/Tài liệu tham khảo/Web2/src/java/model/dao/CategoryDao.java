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
import mylib.DBUtil;

/**
 *
 * @author user
 */
public class CategoryDao {
    //ham nay de connect db va lay all cagories co status =1
    //tra ve cac Categories
    public static ArrayList<Category> getCategories(int status)  throws Exception{
        //connect DB        
        ArrayList<Category> list=new ArrayList<>();
        Connection cn=DBUtil.makeConnection();
        if(cn!=null){
            String s = "select CateId,CateName,Status\n"
                    + "from dbo.Categories\n"
                    + "where Status=?";
            PreparedStatement pst=cn.prepareStatement(s);
            pst.setInt(1, status);
            ResultSet kq=pst.executeQuery();
            if(kq!=null){
                while(kq.next()){
                    int a=kq.getInt("CateId");
                    String b=kq.getString("CateName");
                    int c= kq.getInt("Status");
                    Category cate=new Category(a, b, c);
                    list.add(cate);
                }
            }
            cn.close();
        }
        return list;
    }
    
    
    //ham nay de sua thong tin 1 dong category
    public static int updateCategory(int id, String catename, int status) throws Exception{
        int kq=0;
        Connection cn=DBUtil.makeConnection();
        if(cn!=null){
            String s = "UPDATE dbo.Categories\n"
                    + "set CateName=?, Status=?\n"
                    + "where CateId=?";
            PreparedStatement pst=cn.prepareStatement(s);
            pst.setString(1, catename);
            pst.setInt(2, status);
            pst.setInt(3, id);
            kq=pst.executeUpdate();
            cn.close();
        }
        return kq;
    }
    
    
    
}
