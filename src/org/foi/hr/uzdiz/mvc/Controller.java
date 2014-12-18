/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.mvc;

import java.util.Scanner;

/**
 *
 * @author Miso
 */
public class Controller {
    Model model;
    View view;
    Scanner s;
    
    public Controller(String[] args, Model model, View view){
        this.model = model;
        this.view = view;
        s = new Scanner(System.in);
        if(model.parseData(args))
            displayInterface();
    }
    
    private void displayInterface(){
        String input;
        do{
            view.printMenu();
            input = s.next();
            if(input.matches("[0-9]"))
            switch(Integer.parseInt(input)){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }while(!input.equals("Q"));
        
    }
}
