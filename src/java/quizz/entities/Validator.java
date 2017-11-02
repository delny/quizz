/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a.delgado
 */
public class Validator {
    
    private Validator(){
        System.out.println("Ce message ne peut pas s'afficher !");
    }
    
    public static int countGoodAnswers(List<String> answers){

        List<String> rightAnswers = new ArrayList<>();
        
        rightAnswers.add("3");
        rightAnswers.add("4");
        rightAnswers.add("2");
        rightAnswers.add("3");
        rightAnswers.add("4");
        rightAnswers.add("2");
        rightAnswers.add("5");
        rightAnswers.add("57");
        rightAnswers.add("1");
        rightAnswers.add("4");
        
        int countGoodAnswers = 0;
        int i=0;
        for(String answer : answers){
            if(answer.equals(rightAnswers.get(i))){
                countGoodAnswers++;
            }
            i++;
        }
        
        System.out.println("Nombres de bonnes reponses : "+countGoodAnswers);
        
        return countGoodAnswers;
    }
}
