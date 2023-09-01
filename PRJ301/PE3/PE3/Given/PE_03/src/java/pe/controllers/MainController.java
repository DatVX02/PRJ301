/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.food.FoodDAO;
import pe.models.User;
import pe.utils.DAO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String LOGIN = "login.jsp";
    private static final String ADMIN = "admin.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");

            if (action != null && action.equals("login")) {
                String username = request.getParameter("userID");
                String password = request.getParameter("password");
                DAO dao = new DAO();
                User currentUser = dao.login(username, password);
                if (currentUser != null && currentUser.getRoleID().equals("AD")) {
                    HttpSession session = request.getSession(false);
                    session.setAttribute("currentUser", currentUser);
                    url = ADMIN;
                } else {
                    request.setAttribute("error", "Incorrect UserID or Password");
                    url = LOGIN;
                }
            } else if (action != null && action.equals("logout")) {
                HttpSession session = request.getSession();
                session.invalidate();
                url = LOGIN;
            } else if (action != null && action.equals("Save")) {
                String id = request.getParameter("txtID");
                String name = request.getParameter("txtName");
                String description = request.getParameter("txtDescription");
                String price = request.getParameter("txtprice");
                String cookingtime = request.getParameter("txtcooking");
                FoodDAO dao = new FoodDAO();
                dao.addFood(id, name, description, price, cookingtime, true);
                url = ADMIN;
            }
        } catch (Exception e) {
            log("Error at MainController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
