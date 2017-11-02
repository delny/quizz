/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a.delgado
 */
@WebServlet(name = "Download", urlPatterns = {"/tmp/*"})
public class Download extends HttpServlet {
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10 ko

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
            out.println("<title>Servlet Download</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Download at " + request.getContextPath() + "</h1>");
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
        //recuperation du chemin depuis el web.xml
        String chemin = this.getServletConfig().getInitParameter("chemin");
        
        //recuperation du fichier demandé
        String fileAsk = request.getPathInfo();
        
        
        //on verifie qu'un fichier e bien été demandé
        if(fileAsk==null || "/".equals(fileAsk)){
            System.out.println("Aucun fichier n'est demandé !");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        fileAsk = URLDecoder.decode(fileAsk,"UTF-8");
        File fichier = new File(chemin, fileAsk);
        //on verifie que le fichier existe bien
        if(!fichier.exists()){
            System.out.println("Le fichier demandé n'existe pas !"+ fichier.getAbsolutePath());
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        //on recupere le type de fichier
        String type = getServletContext().getMimeType(fichier.getName());
        
        //si type vaut null on met un type par defaut
        if (type==null){
            System.out.println("type par défaut");
            type = "application/octet-stream";
        }
        
        //on initialise la reponse http
        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType(type);
        response.setHeader("Content-Length", String.valueOf(fichier.length()));
        response.setHeader("Content-Disposition", "attachment; filenale=\""+ fichier.getName() +"\"");
        
        /*
        * Envoi du fichier
        */
        //preparation des flux
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try{
            //ouvre les flux
            entree = new BufferedInputStream(new FileInputStream(fichier), DEFAULT_BUFFER_SIZE);
            sortie = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
            
            //lit le fichier
            System.out.println("toto est là");
            byte[] tampon = new byte[DEFAULT_BUFFER_SIZE];
            int longueur;
            while ( ( longueur= entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
            
        }finally{
            try{
                sortie.close();
            } catch(IOException e){
                
            }
            try{
                entree.close();
            } catch(IOException e){
                
            }
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
