/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import quizz.entities.File;

/**
 *
 * @author a.delgado
 */
public class UploadFile {
    private static final int TAILLE_TAMPON = 10240; //10ko
    
    private String resultat;
    private Map<String,String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public File SaveFile(HttpServletRequest request){
        // chemin d'enregistrement du fichier
        String chemin = "c:/Users/a.delgado/Documents/NetBeansProjects/quizz/web/tmp/";
        
        //initialisation du fichier
        File fichier = new File();
        
        /*
        * Récuperation du doc avec getPart
        */
        String fileName = null;
        InputStream fileContent = null;
        try{
            Part part = request.getPart("doc");
            
            //one recupere le nom pour verifier que c'est bien un type file
            fileName = getNomFichier(part);
            
            //on verifie que c'est bien un pdf
            if(!fileName.endsWith(".pdf")){
                setErreur("Le type de document n'est pas supporté");
            }
            
            //on génère un nom aléatoire unqiue pour chaque joueur
            String randomName = generateString();
            fileName = randomName+".pdf";
            
            if (fileName !=null && !fileName.isEmpty()){
                //correction pour internet explorer
                fileName = fileName.substring( fileName.lastIndexOf( '/' ) + 1 ).substring( fileName.lastIndexOf( '\\' ) + 1 );
                
                //on recupere le contenu du fichier
                fileContent = part.getInputStream();
            }
        }catch(IllegalStateException e){
            //doc trop volumineux
            e.printStackTrace();
            setErreur("Le document est trop volumineux");
        }catch(IOException e){
            // erreur au niveau du repertoire -- inexistant, droit d'accès
            e.printStackTrace();
            setErreur("Erreur du serveur");
        }catch(ServletException e){
            e.printStackTrace();
            setErreur("Erreur de requete");
        }
        
        // si aucune erreurs n'est survenu, on continue
        if(erreurs.isEmpty()){
            //validation du fichier avec la methode dédié
            try{
                validationFile(fileName, fileContent);
            } catch(Exception e){
                setErreur(e.getMessage());
            }
            //on set le nom
            fichier.setName(fileName);
        }
        
        //si aucune errreur n'ests survnenu, on continue encore
        if (erreurs.isEmpty()){
            //ecriture du fichier sur le disque
            try{
                writeFile(fileContent, fileName, chemin);
            }catch(Exception e){
                setErreur("Erreur d'écriture sur le disque");
            }
        }
        
        //assignation du resultat final
        if (erreurs.isEmpty()){
            resultat = "Victoire";
            System.out.println("tout s'est bien passée");
        } else{
            resultat = "Echec";
            System.out.println("Nous avons un probleme mais ou ?");
        }
        
        return fichier;
    }
    
    /*
    * Valide le fichier envoyé
    */
    private void validationFile(String fileName, InputStream fileContent) throws Exception{
        if(fileName==null || fileContent==null){
            throw new Exception("Vous devez joindre le document demandé");
        }
    }
    
    /*
    * Ajoute un message d'erreur
    */
    private void setErreur(String message){
        erreurs.put("doc", message);
    }
    
    /*
    * Retourne le contenu d'un champ, null si le champ est vide
    */
    private String getValueChamp(HttpServletRequest request,String nomChamp){
        String valeur = request.getParameter(nomChamp);
        if (valeur==null || valeur.trim().length()==0){
            return null;
        }
        return valeur;
    }
    
    /* 
     * Méthode utilitaire qui a pour unique but d'analyser l'en-tête "content-disposition",
     * et de vérifier si le paramètre "filename"  y est présent. Si oui, alors le champ traité
     * est de type File et la méthode retourne son nom, sinon il s'agit d'un champ de formulaire 
     * classique et la méthode retourne null. 
     */
    private static String getNomFichier( Part part ) {
        if(part==null){
            return null;
        }

        /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            /* Recherche de l'éventuelle présence du paramètre "filename". */
            if ( contentDisposition.trim().startsWith("filename") ) {
                /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier. */
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        /* Et pour terminer, si rien n'a été trouvé... */
        return null;
    }
    
    /*
    * Méthode qui va écrire dans  le fichier sur le disque avec en paramètre le fichier et le chemin
    * méthode appélé dans un try catch d"ou le throw exception
    */
    private void writeFile(InputStream fileContent, String fileName, String chemin) throws Exception{
        //prepare les flux entrée et sorties
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try{
            //assigne les flux
            entree = new BufferedInputStream(fileContent, TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new java.io.File(chemin + fileName)), TAILLE_TAMPON);
            System.out.println("on écrit normalement e tel endroit "+chemin+fileName);
            
            //lit le fichier
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur = 0;
            while ((longueur = entree.read(tampon)) > 0){
                sortie.write(tampon, 0, longueur);
            }
        } finally{
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
    
    /*
    * Méthode qui génère un chaine alétoire de 24 caractères
    */
    private String generateString(){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int charLength = chars.length();
        StringBuilder  pass = new StringBuilder (charLength);
        for(int i=0; i <24;i++){
            int j = (int) (Math.random() * charLength);
            pass.append(chars.charAt(j));
        }
        
        return pass.toString();
    }
}
