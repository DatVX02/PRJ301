/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truonglnh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import truonglnh.registration.RegistrationDAO;
import truonglnh.registration.RegistrationDTO;
import truonglnh.utils.MyAppConstants;

/**
 *
 * @author lnhtr
 */
@WebServlet(name = "CreateNewRegistrationServlet", urlPatterns = {"/CreateNewRegistrationServlet"})
public class CreateNewRegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(MyAppConstants.ex2Features.SHOW_REGISTRATION_ACTION);
        String ID = request.getParameter("txtID");
        String name = request.getParameter("txtName");
        String role = request.getParameter("txtRole");
        String className = request.getParameter("txtClassName");
        try {
            RegistrationDAO dao = new RegistrationDAO();
            RegistrationDTO dto = new RegistrationDTO(ID, name, role, className);
            dao.createResgitration(dto);
            request.setAttribute("CREATE_REGISTRATION", dto);
            
        }catch (SQLException ex) {
            log("CreateNewRegistration _ SQL_" + ex.getMessage());
        } catch (NamingException ex) {
            log("CreateNewRegistration _ Naming" + ex.getMessage());
            
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
