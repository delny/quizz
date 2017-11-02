/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quizz.dao.DaoFactory;
import quizz.entities.File;
import quizz.entities.Player;
import quizz.entities.Validator;

/**
 *
 * @author a.delgado
 */
@WebServlet(name = "Validate", urlPatterns = {"/Validate"})
public class Validate extends HttpServlet {
    
    private Map<String,String> erreurs;

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
        response.sendRedirect("validate.jsp");
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
        request.getSession().setAttribute("player", null);
        request.getSession().setAttribute("formError", null);
        response.sendRedirect("index.jsp");
        
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
        //regle probleme lié à utf-8
        request.setCharacterEncoding( "UTF-8" );
  
        //on crée le player à l'aide de la requete
        Player player = createPlayer(request);
        
        //verification des infos
        try{
            //on valide les informations
            validationInformations(player);

            //on crée le document avec la requete
            File document = createDocument(request);

            //assignation nom généré dans Player
            player.setDocName(document.getName());

            if(!erreurs.isEmpty()){
                String error = erreurs.get("doc");
                request.getSession().setAttribute("formError", error);
                response.sendRedirect("index.jsp");
            } else{
                //ajout dans BDD
                DaoFactory.getPlayerDAO().create(player);
                processRequest(request, response);
            }
        }catch(Exception e){
            request.getSession().setAttribute("formError", e.getMessage());
            response.sendRedirect("index.jsp");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet qui valide (ou pas) la participation";
    }// </editor-fold>

    /**
     * Traitement document
     */
    private File createDocument(HttpServletRequest request){
        //creation manager
        UploadFile uf = new UploadFile();
        
        //on recupere les erreur
        erreurs = uf.getErreurs();
        
        return uf.SaveFile(request);
    }
    
    /**
     * Créer le player avec la requete
     * @param request
     * @return Player
     */
    private Player createPlayer(HttpServletRequest request){
        //on recupere les infos
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String howKnow = (request.getParameter("howknow")==null)? "sans" : request.getParameter("howknow");
        String why = (request.getParameter("why")==null) ? "sans" : request.getParameter("why");
        
        //creation player et mise en session
        Player player = new Player(firstName, lastName, email, phone,howKnow.trim(),why.trim(),0);
        request.getSession().setAttribute("player", player);
        
        //recuperation des reponses
        List<String> answers = new ArrayList<>();
        String answer;
        for(int i = 1;i<=10;i++){
            answer = request.getParameter("question"+i);
            answers.add(answer);
        }
        
        //on calcule le nombre de bonnes réponses et on set au player
        int nbGoodAnswers = Validator.countGoodAnswers(answers);
        player.setNbGoodAnswers(nbGoodAnswers);
        
        //retourne le player ainsi crée
        return player;
    }
    
    /**
    * Valide l'adresse mail saisie.
    */
    private void validationInformations(Player player) throws Exception {
        validationName(player.getFirstName());
        validationName(player.getLastName());
        validationEmail(player.getEmail());
        if(DaoFactory.getPlayerDAO().isExist(player.getEmail())){
            throw new Exception("Cet Email a déjà été utilisé");
        }
        validationPhone(player.getPhone());
    }
    
    /**
    * Valide l'adresse mail saisie.
    */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    
    /**
    * Valide le nom et/ou le prenom.
    */
   private void validationName( String name ) throws Exception {
       if(name != null){
           if(name.trim().length()<2){
               throw new Exception("Le nom et/ou prénom n'est pas correct");
           }
       } else {
           throw new Exception("Le nom et/ou prénom n'est pas correct.");
       }
   }
   
   /**
    * Valide le téléphone.
    */
   private void validationPhone( String phone ) throws Exception {
       if(phone != null){
           if(phone.length()!=10){
               throw new Exception("Le téléphone n'est pas correct");
           }
           if(!phone.startsWith("0")){
               throw new Exception("Le téléphone n'est pas correct");
           }
       } else {
           throw new Exception("Le téléphone n'est pas correct");
       }
   }
   
}
