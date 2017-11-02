/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quizz.dao.DaoFactory;
import quizz.entities.Player;

/**
 *
 * @author a.delgado
 */
@WebServlet(name = "Draw", urlPatterns = {"/Draw"})
public class Draw extends HttpServlet {
    
    private final int NBPARPAGES = 10;

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
        response.sendRedirect("draw.jsp");
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
        //recuperation de la page
        int page = (request.getParameter("page")==null)? 0 : Integer.parseInt(request.getParameter("page"));
        page = (page >1) ? page : 1;
        
        //recuperation des joueurs
        List<Player> allPlayers = DaoFactory.getPlayerDAO().findAll();
        
        //nombre de pages necessaires
        int nbPages = (int) Math.ceil((double)allPlayers.size()/NBPARPAGES);
        
        //mise en session
        request.getSession().setAttribute("players", DaoFactory.getPlayerDAO().findAllbyPage(page,NBPARPAGES));
        request.getSession().setAttribute("page", page);
        request.getSession().setAttribute("nbpages", nbPages);
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
        return "Servlet qui liste les participations";
    }// </editor-fold>

}
