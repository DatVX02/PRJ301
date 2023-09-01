/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truonglnh.airplane;

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
public class AirplaneDAO implements Serializable{
    private List<AirplaneDTO> airplaneList;

    public List<AirplaneDTO> getAirplaneList() {
        return airplaneList;
    }
    
     public void searchFlight(String keyword) throws SQLException, /*ClassNotFoundException*/ NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Connect DB
            con = DBHelper.getConnection();
            //kt connection
            if (con != null) {

                //2. Write SQL
                String sql = " Select ID, flightNumber, destination, departureAttributesTime, status "
                        + " From airplane "
                        + " Where flightNumber LIKE ? ";
                //3. Create Statement OBj
                stm = con.prepareStatement(sql); // nap cau lenh lan dau va duy nhat
                //4. xecute statement Obj to get result rs
                stm.setString(1, "%" + keyword + "%");
//                stm.setString(1, keyword );

                rs = stm.executeQuery();

                //5. Process result
                //nhieu dong while
                while (rs.next()) {
                    // lay cot vi luoon chon dung cot
                    String id = rs.getString("ID");
                    String flightNumber = rs.getString("flightNumber");
                    String destination = rs.getString("destination");
                    String dat = rs.getString("departureAttributesTime");
                    String status = rs.getString("status");

                    AirplaneDTO dto = new AirplaneDTO(id, flightNumber, destination, dat, status);
                    if (this.airplaneList == null) {
                        this.airplaneList = new ArrayList<>();
                    }//end account list had not existed
                    this.airplaneList.add(dto);
                }//end rs has not reached EOF
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
}
