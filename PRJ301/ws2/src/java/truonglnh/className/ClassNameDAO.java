/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truonglnh.className;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import truonglnh.registration.RegistrationDTO;
import truonglnh.utils.DBHelper;

/**
 *
 * @author lnhtr
 */
public class ClassNameDAO implements Serializable{
    private List<ClassNameDTO> listClassName;

    public List<ClassNameDTO> getListClassName() {
        return listClassName;
    }


    
    
    public void listClassName() throws SQLException, NamingException{
       Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect db
            con = DBHelper.getConnection();
            // kt connection
            if (con != null) {

                //2. write Sql
                String sql = "Select className "
                        + " From className ";

                //3. create Statement
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                //5. process result
                while (rs.next()) {                
                    String className = rs.getString("className");
                    

                    ClassNameDTO dto = new ClassNameDTO(className);
                    if (this.listClassName == null) {
                        this.listClassName = new ArrayList<>();
                    }//end product list had not existed
                    this.listClassName.add(dto);

                }// end rs has not reached EOF
            }//end connection has existed

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }  
    }
    
    public boolean createClassName(String name) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = DBHelper.getConnection();
            //kt connection
            if (con != null) {

                //2. Write SQL
                String sql = "Insert into className("
                        + "className"
                        + ") Values("
                        + "?"
                        + ") ";
                //3. Create Statement OBj
                stm = con.prepareStatement(sql); // nap cau lenh lan dau va duy nhat

                stm.setString(1, name);

                //4. execute statement Obj to get result rs
                int effectRow = stm.executeUpdate();

                //5. Process result
                if (effectRow > 0) {
                    result = true;
                }
            }//end connection has existed
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
