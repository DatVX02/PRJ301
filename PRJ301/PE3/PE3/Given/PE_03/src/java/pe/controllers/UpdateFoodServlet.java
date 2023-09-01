/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.food.FoodDAO;
import pe.food.FoodDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UpdateFoodServlet", urlPatterns = {"/UpdateFood"})
public class UpdateFoodServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateFoodServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateFoodServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            String foodId = request.getParameter("id");
            String foodName = request.getParameter("foodName");
            String description = request.getParameter("description");
            int price = Integer.parseInt(request.getParameter("price"));
            int cookingTime = Integer.parseInt(request.getParameter("cookingTime"));
              FoodDTO updatedFood = new FoodDTO(foodId, foodName, description, price, cookingTime, true);

            // Cập nhật thông tin món ăn trong CSDL
            FoodDAO foodDAO = new FoodDAO();
            boolean isSuccess = true;
        try {

          foodDAO.updateFood(updatedFood);

            if (isSuccess) {
                // Chuyển hướng về trang danh sách món ăn sau khi cập nhật thành công
                response.sendRedirect("admin.jsp");
            } else {
                // Xử lý trường hợp cập nhật thất bại
                String errorMessage = "Failed to update food information.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("editFood.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý trường hợp lỗi
            e.printStackTrace();
            String errorMessage = "An error occurred while updating food information.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("editFood.jsp").forward(request, response);
        }
        
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
