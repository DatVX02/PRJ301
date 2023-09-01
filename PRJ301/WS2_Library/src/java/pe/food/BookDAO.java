/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.models.User;
import pe.utils.DBUtils;

/**
 *
 * @author Hoa Doan
 */
public class BookDAO {

    public boolean addBook(String id, String name, String description, String price, boolean status) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        try {
            Connection connection = dbu.getConnection();
            String sql = "INSERT INTO [dbo].[tblComestic]\n"
                    + "           ([id]\n"
                    + "           ,[name]\n"
                    + "           ,[description]\n"
                    + "           ,[price]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, price);
            ps.setBoolean(5, status);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error insert");
        }
        return false;
    }

    public ArrayList<BookDTO> getALLBook() throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        ArrayList<BookDTO> list = new ArrayList<>();
        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[description]\n"
                    + "      ,[price]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[tblComestic]\n"
                    + "  where status = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookDTO dto = new BookDTO(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("price"), true);
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("Error list Book");
        }
        return list;
    }

    public boolean deleteBook(String bookID) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        try {
            Connection connection = dbu.getConnection();
            String sql = "DELETE FROM [dbo].[tblComestic]\n"
                    + "      WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bookID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error login");
        }
        return false;
    }

    public List<BookDTO> searchBook(String name) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        ArrayList<BookDTO> list = new ArrayList<>();
        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[description]\n"
                    + "      ,[price]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[tblComestic]\n"
                    + "  where name = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookDTO dto = new BookDTO(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("price"), true);
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("Error list Book");
        }
        return list;
    }

    public boolean updateBook(BookDTO updatedBook) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        try {
            Connection connection = dbu.getConnection();
            String sql = "UPDATE [dbo].[tblComestic]\n"
                    + "   SET [id] = ?\n"
                    + "      ,[name] = ?\n"
                    + "      ,[description] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[status] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, updatedBook.getId());
            ps.setString(2, updatedBook.getName());
            ps.setString(3, updatedBook.getDescription());
            ps.setInt(4, updatedBook.getPrice());
            ps.setBoolean(5, updatedBook.isStatus());
            ps.setString(6, updatedBook.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error insert");
        }
        return false;
    }

    public BookDTO getBookById(String bookId) throws ClassNotFoundException {
        DBUtils dbu = new DBUtils();
        BookDTO list = new BookDTO();
        try {
            Connection connection = dbu.getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[description]\n"
                    + "      ,[price]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[tblComestic]\n"
                    + "  where id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bookId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list = new BookDTO(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("price"), true);
            }
        } catch (SQLException e) {
            System.out.println("Error list Book");
        }
        return list;
    }

}
