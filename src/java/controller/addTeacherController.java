/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import da.LoginDA;
import da.TeacherDA;
import domain.Login;
import domain.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmad Mahyudi
 */
@WebServlet(name = "addTeacherController", urlPatterns = {"/addTeacherController"})
public class addTeacherController extends HttpServlet {

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
           
            //int loginId = Integer.parseInt(request.getParameter("loginId"));
            String teacherIC = request.getParameter("teacherIC");
            String teacherName = request.getParameter("teacherName");
            String teacherPosition = request.getParameter("teacherPosition");
            String teacherContact = request.getParameter("teacherContact");
            String className = request.getParameter("className");
            String loginPassword = request.getParameter("loginPassword");
            out.println("\n"+loginPassword);
            
            try {
                Login L = LoginDA.authenticateLogin(loginPassword);
                out.println("Login id : " + L.getLoginId());
                Teacher T = TeacherDA.authenticateTeacher(teacherName,teacherIC,teacherPosition,teacherContact,className,L.getLoginId());
                out.println("Teacher IC : " + T.getTeacherIC());
                
                if(T==null)
                {
                    out.println("Unsuccessfull!");
                    response.sendRedirect("addTeacherAdmin.jsp");
                }
                else
                {
                    out.println("correct");
                   // request.getSession().setAttribute("teacherId",loginId);
                    request.getSession().setAttribute("teacherPosition",T.getTeacherPosition());
                    //request.setAttribute("teacherId",T.getTeacherId());
                    
                        //request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
                        //request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
                    response.sendRedirect("homeAdmin.jsp");
                    
                    //response.sendRedirect("homeStaff.jsp");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
