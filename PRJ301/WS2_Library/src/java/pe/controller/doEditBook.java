/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "doEditBook", urlPatterns = {"/EditBook"})
public class doEditBook extends HttpServlet {

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
            out.println("<title>Servlet doEditBook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doEditBook at " + request.getContextPath() + "</h1>");
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
        String bookId = request.getParameter("id");
        BookDAO bookDAO = new BookDAO();
        BookDTO bookDTO = null;
        try {
            bookDTO = bookDAO.getBookById(bookId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(doEditBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (bookDTO != null) {
            // Gửi thông tin của món ăn vào request để hiển thị trên form sửa
            request.setAttribute("bookId", bookDTO.getId());
            request.setAttribute("bookName", bookDTO.getName());
            request.setAttribute("description", bookDTO.getDescription());
            request.setAttribute("price", bookDTO.getPrice());

            request.getRequestDispatcher("editBook.jsp").forward(request, response);
        } else {
            // Xử lý trường hợp món ăn không tồn tại
            String errorMessage = "Book with ID " + bookId + " does not exist.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
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
