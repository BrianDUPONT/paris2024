/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sio.paris2024.servlet;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sio.paris2024.database.DaoPays;
import sio.paris2024.model.Pays;

/**
 *
 * @author zakina
 */
public class ServletPays extends HttpServlet {
    
    Connection cnx ;
            
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        
        System.out.println("SERVLKET CONTEXT=" + servletContext.getContextPath());
        cnx = (Connection)servletContext.getAttribute("connection"); 
        
        try {
            System.out.println("INIT SERVLET=" + cnx.getSchema());
        } catch (SQLException ex) {
            Logger.getLogger(ServletPays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            out.println("<title>Servlet ServletPays</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPays at " + request.getContextPath() + "</h1>");
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
        
        String url = request.getRequestURI();  
       
        // Récup et affichage les pays 
        if(url.equals("/paris2024/ServletPays/lister"))
        {              
            ArrayList<Pays> lesPays = DaoPays.getLesPays(cnx);
            request.setAttribute("aLesPays", lesPays);
            //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
           getServletContext().getRequestDispatcher("/vues/pays/listerPays.jsp").forward(request, response);
        }
        
        if(url.equals("/paris2024/ServletPays/consulter"))
        { 
            int idPays = Integer.parseInt((String)request.getParameter("idPays"));
            Pays p = DaoPays.getLesAthletesByPaysId(cnx, idPays);
            request.setAttribute("aPays", p);
            //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
           getServletContext().getRequestDispatcher("/vues/pays/consulterPays.jsp").forward(request, response);
        }    
        
    }
    
 }

