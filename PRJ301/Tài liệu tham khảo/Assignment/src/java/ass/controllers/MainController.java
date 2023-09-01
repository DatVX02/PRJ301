/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ass.controllers;

import ass.dao.ItemMng;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    private final String INDEX = "index.html";
    private final String ITEMS_VIEW = "ItemsView";
    private final String ITEMS_UPDATE_PAGE = "itemUpdatePage.jsp";
    private final String ITEMS_UPDATE = "UpdateItem";
    private final String FAQ_PAGE = "FAQpage";
    private final String FAQ_VIEW = "FAQview.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = INDEX;

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "itemsview":
                    url = ITEMS_VIEW;
                    break;
                case "editItem":
                    String itemId = request.getParameter("itemid");
                    request.setAttribute("Item", ItemMng.getItem(itemId));
                    request.setAttribute("ListCate", ItemMng.getCateList());
                    url = ITEMS_UPDATE_PAGE;
                    break;
                case "updateItem":
                    url = ITEMS_UPDATE;
                    break;
                case "faqpage":
                    url = FAQ_PAGE;
                    break;
                case "faqview":
                    url = FAQ_VIEW;
                    break;
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
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
