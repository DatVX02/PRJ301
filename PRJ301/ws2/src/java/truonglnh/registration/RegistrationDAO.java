/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truonglnh.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import truonglnh.utils.DBHelper;

/**
 *
 * @author lnhtr
 */
public class RegistrationDAO implements Serializable {

    private List<RegistrationDTO> registrationList;

    public List<RegistrationDTO> getRegistrationList() {
        return registrationList;
    }

    public void showInfo() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect db
            con = DBHelper.getConnection();
            // kt connection
            if (con != null) {

                //2. write Sql
                String sql = "Select ID, name, role, className "
                        + " From registration ";

                //3. create Statement
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                //5. process result
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String role = rs.getString("role");
                    String className = rs.getString("className");
                    

                    RegistrationDTO dto = new RegistrationDTO(ID, name, role, className);
                    if (this.registrationList == null) {
                        this.registrationList = new ArrayList<>();
                    }//end product list had not existed
                    this.registrationList.add(dto);

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
    
    public boolean createResgitration(RegistrationDTO  dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = DBHelper.getConnection();
            //kt connection
            if (con != null) {

                //2. Write SQL
                String sql = "Insert into registration("
                        + "ID, name, role, className"
                        + ") Values("
                        + "?,?,?,?"
                        + ") ";
                //3. Create Statement OBj
                stm = con.prepareStatement(sql); // nap cau lenh lan dau va duy nhat
                stm.setString(1, dto.getId());
                stm.setString(2, dto.getName());
                stm.setString(3, dto.getRole());
                stm.setString(4, dto.getClassName());

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
    
    public boolean deleteRegistration(String pk) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = DBHelper.getConnection();
            //kt connection
            if (con != null) {

                //2. Write SQL
                String sql = " Delete From registration "
                        + " Where ID = ? ";
                //3. Create Statement OBj
                stm = con.prepareStatement(sql); // nap cau lenh lan dau va duy nhat
                stm.setString(1, pk);

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
