/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.models.User;
import pe.utils.DAO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "login.jsp";
    private static final String ADMIN = "admin.jsp";
    private static final String COMESTICLIST = "comesticList.jsp";
    private static final String COMESTICADD = "addComestic.jsp";
    private static final String REGISTRATION = "registration.jsp";
    private static final String COMESTICDETAIL = "comesticDetail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                String username = request.getParameter("userid");
                String password = request.getParameter("password");
                DAO dao = new DAO();
                User currentUser = dao.login(username, password);
                if (currentUser != null) {
                    request.setAttribute("currentUser", currentUser);
                    url = COMESTICLIST;
                } else {
                    request.setAttribute("error", "Incorrect User ID or Email or Password ");
                    url = LOGIN;
                }
            }
            if (action.equals("Logout")) {
                HttpSession session = request.getSession();
                session.removeAttribute("currentUser");
                session.invalidate();
                url = LOGIN;
            }
            if (action.equals("Registration")) {
                url = REGISTRATION;
            }
            if (action.equals("create")) {
                DAO dao = new DAO();
                boolean ok = true;
                String fullName = request.getParameter("fullName");
                String userID = request.getParameter("userID");
                if (dao.doesExistUser(userID)) {
                    ok = false;
                    request.setAttribute("errorCreate", "User ID or Email has used already");
                    url = REGISTRATION;
                }
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                if (ok == true) {
                    dao.create(fullName, userID, email, password);
                    url = LOGIN;

                }
            }
            if (action.equals("AddDirectory")) {
                url = COMESTICADD;
            }
            if (action.equals("AddComestic")) {
                DAO dao = new DAO();
                boolean ok = true;
                String id = request.getParameter("id");
                if (isValidId(id)) {

                } else {
                    ok = false;
                    request.setAttribute("error", "validation is not satisfied");
                }
                String name = request.getParameter("name");
                if (dao.doesExistName(name)) {
                    ok = false;
                    request.setAttribute("error", "Name is duplicated!");
                }
                String description = request.getParameter("description");
                double price = 0;
                if (!request.getParameter("price").isEmpty()) {
                    price = Double.parseDouble(request.getParameter("price"));
                }
                int size = 0;
                if (!request.getParameter("size").isEmpty()) {
                    size = Integer.parseInt(request.getParameter("size"));
                }
                if (id.isEmpty() || name.isEmpty() || description.isEmpty() || price == 0 || size == 0) {
                    ok = false;
                    request.setAttribute("error", "validation is not satisfied");
                }
                if (ok == true) {
                    dao.addComestic(id, name, description, price, size);
                    request.setAttribute("success", "insert data complete");
                    url = COMESTICLIST;
                } else {
                    url = COMESTICADD;
                }
            }
            if (action.equals("Delete")) {
                String id = request.getParameter("id");
                DAO dao = new DAO();
                dao.deleteComestic(id);
                url = COMESTICLIST;
            }
            if (action.equals("Edit")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                double price = Double.parseDouble(request.getParameter("price"));
                int size = Integer.parseInt(request.getParameter("size"));
                DAO dao = new DAO();
                dao.updateComestic(id, name, description, price, size);
                url = COMESTICDETAIL;
            }

            if (action.equals("UpdateComestic")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                double price = Double.parseDouble(request.getParameter("price"));
                int size = Integer.parseInt(request.getParameter("size"));

                DAO dao = new DAO();
                dao.updateComestic(id, name, description, price, size);

                url = COMESTICLIST;
            }
            if (action.equals("Search")) {
                String keyword = request.getParameter("searchName");
                DAO dao = new DAO();
                if (keyword.equals("")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("comist", dao.getAllComestic());
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("comist", dao.getComestic(keyword));
                }

                url = COMESTICLIST;
            }

        } catch (Exception e) {
            log("Error at MainController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    public static boolean isValidId(String id) {
        String pattern = "C-\\d{3}";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(id);
        return matcher.matches();
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
