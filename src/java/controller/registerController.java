/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import da.StudentDA;
import da.ParentDA;
import da.RegisterDA;
import domain.Student;
import domain.Parent;
import domain.Registration;
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
@WebServlet(name = "registerController", urlPatterns = {"/registerController"})
public class registerController extends HttpServlet {

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
            int loginId = Integer.parseInt(request.getParameter("loginId"));
            
            String studName = request.getParameter("studName");
            String studIC = request.getParameter("studIC");
            String studBirthCertificate = request.getParameter("studBirthCertificate");
            String studGender = request.getParameter("studGender");
            int studAge = Integer.parseInt(request.getParameter("studAge"));
            
            
            String parentAddress = request.getParameter("parentAddress");
            
            String fatherName = request.getParameter("fatherName");
            String fatherIC = request.getParameter("fatherIC");
            String fatherContactNum = request.getParameter("fatherContactNum");
            String fatherOccupation = request.getParameter("fatherOccupation");
            String fatherOccupAddress = request.getParameter("fatherOccupAddress");
            
            String motherName = request.getParameter("motherName");
            String motherIC = request.getParameter("motherIC");
            String motherContactNum = request.getParameter("motherContactNum");
            String motherOccupation = request.getParameter("motherOccupation");
            String motherOccupAddress = request.getParameter("motherOccupAddrsess");
            
            try {
                //out.println(motherName);
                Parent P = ParentDA.authenticateParent(parentAddress,fatherName,fatherIC,fatherContactNum,fatherOccupation,fatherOccupAddress,motherName,motherIC,motherContactNum,motherOccupation,motherOccupAddress,1);
               // out.println(P.getMotherName());
                //out.println(motherName);
                Student S = StudentDA.authenticateStudent(studName,studIC,studAge,studGender,studBirthCertificate,P.getParentId(),1);
                //out.println(S.getStudName());
                Registration R = RegisterDA.authenticateRegistration(S.getStudId());
                //out.println(R.getRegistrationDate());
                //out.println(R.getRegistrationId());
                if(R==null)
                {
                    out.println("Unsuccessfull Registration!");
                }
                else 
                if(loginId==0)
                {
                    out.println("Successful!");
                    response.sendRedirect("register.jsp");
                }
                else
                if(loginId>8)
                {
                    out.println("Successful!");
                    response.sendRedirect("register2.jsp");
                }
                else 
                {
                    out.println("Successful!");
                    response.sendRedirect("register2Admin.jsp");
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
