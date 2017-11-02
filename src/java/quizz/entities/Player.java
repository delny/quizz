/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author a.delgado
 */
@Entity
public class Player implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String howKnow;
    private String why;
    
    //nom du fichier généré aléatoirement
    private String docName;
    
    //nombre de bonnes réponses
    private int nbGoodAnswers;

    public Player() {
    }

    public Player(String firstName, String lastName, String email, String phone, String howKnow, String why, int nbGoodAnswers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.howKnow = howKnow;
        this.why = why;
        this.nbGoodAnswers = nbGoodAnswers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHowKnow() {
        return howKnow;
    }

    public void setHowKnow(String howKnow) {
        this.howKnow = howKnow;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getNbGoodAnswers() {
        return nbGoodAnswers;
    }

    public void setNbGoodAnswers(int nbGoodAnswers) {
        this.nbGoodAnswers = nbGoodAnswers;
    }

    
    
}
