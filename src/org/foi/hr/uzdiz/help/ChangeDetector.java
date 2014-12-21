/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.help;

import org.foi.hr.uzdiz.composite.ConcreteDirectory;
import org.foi.hr.uzdiz.mvc.Model;

/**
 *
 * @author Miso
 */
public class ChangeDetector extends Thread{
    Model model;
    ConcreteDirectory state;
    public ChangeDetector(Model m){
        this.model = m;
    }

    @Override
    public void interrupt() {
        super.interrupt(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Thread interrupted");
    }

    @Override
    public void run() {
        state = model.buildFileTree(model.readDir);
        state.size = model.getDirSizes(state.content);
        model.compareStates(model.fileTreeComposite, state);
    }

    @Override
    public synchronized void start() {
        super.start();
        System.out.println("Thread started");
    }
}
