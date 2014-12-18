/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.mvc;

import org.foi.hr.uzdiz.help.Constants;

/**
 *
 * @author Miso
 */
public class View {
    String arrow = Constants.RIGHT_ARROW;
    public void updateOutput(String s){
        System.out.println(s);
    }
    
    public void printMenu(){
        System.out.println("\t\tIZBORNIK\n");
        System.out.println("1 " + arrow + " ispis ukupnog broja direktorija i datoteka u strukturi");
        System.out.println("2 " + arrow + " ispis sadržaja strukture direktorija i datoteka");
        System.out.println("3 " + arrow + " izvršavanje dretve");
        System.out.println("4 " + arrow + " prekid izvršavanja dretve");
        System.out.println("5 " + arrow + " ispis rednog broja i vremena spremljenih promjena stanja strukture");
        System.out.println("6 " + arrow + " postavljanje stanja strukture na promjenu broj n čime ono postaje novo trenutno stanje strukture");
        System.out.println("7 " + arrow + " uspoređivanje stanja strukture promjena broj n u odnosu na promjenu broj m");
        System.out.println("8 " + arrow + " postavljanje trenutnog stanja strukture kao početno stanje i odbacivanje svih prethodnih stanja");
        System.out.println("9 " + arrow + " dodana vlastita funkcionalnost");
        System.out.println("Q " + arrow + " prekid rada programa.");
        System.out.print("\n\nOpcija: ");
    }
}
