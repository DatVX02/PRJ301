/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.food.BookDAO;
import pe.food.BookDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UpdateBookServlet", urlPatterns = {"/UpdateBook"})
public class UpdateBookServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateBookServlet at " + request.getContextPath() + "</h1>");
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
            String bookId = request.getParameter("id");
            String bookName = request.getParameter("bookName");
            String description = request.getParameter("description");
            int price = Integer.parseInt(request.getParameter("price"));
              BookDTO updatedBook = new BookDTO(bookId, bookName, description, price, true);

            // Cập nhật thông tin món ăn trong CSDL
            BookDAO bookDAO = new BookDAO();
            boolean isSuccess = true;
        try {

          bookDAO.updateBook(updatedBook);

            if (isSuccess) {
                // Chuyển hướng về trang danh sách món ăn sau khi cập nhật thành công
                response.sendRedirect("admin.jsp");
            } else {
                // Xử lý trường hợp cập nhật thất bại
                String errorMessage = "Failed to update book information.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("editBook.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý trường hợp lỗi
            e.printStackTrace();
            String errorMessage = "An error occurred while updating book information.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("editBook.jsp").forward(request, response);
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
