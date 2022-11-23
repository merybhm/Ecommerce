/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Admin;
import entities.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import service.AdminService;
import service.ClientService;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
@WebServlet(name = "InscriptionUser", urlPatterns = {"/InscriptionUser"})
public class InscriptionClient extends HttpServlet {
private static final long serialVersionUID = 1L;
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
          ClientService cs = new ClientService();
     
    
        
   
      
         Session s =HibernateUtil.getSession();
      
            String email = request.getParameter("email");
            String password = request.getParameter("password");
              String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int tel=Integer.parseInt(request.getParameter("tel"));
            String adresse = request.getParameter("adresse");
            
             Client clt=new Client(nom, prenom, tel, adresse, email, password);
              cs.create(clt);
       /*s.beginTransaction();
        s.save(clt);
        s.getTransaction().commit();*/
        request.setAttribute("msg", "INSCRIT AVEC SUCCES!");
     // request.getRequestDispatcher("login.html").forward(request,response);
          response.sendRedirect("login.html");
 
        
      
  
    
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
