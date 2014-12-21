/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.memento;

import java.util.ArrayList;
import java.util.List;
import org.foi.hr.uzdiz.composite.FSElementAbstract;

/**
 *
 * @author Miso
 */
public class MementoCaretaker {
    private List<StructureMemento> savedStates;
    
    public MementoCaretaker(){
        this.savedStates = new ArrayList<>();
    }
    public void addMemento(StructureMemento structure) {
        this.savedStates.add(structure);
    }
    
    public StructureMemento getStructureMemento(int index){
        return this.savedStates.get(index);
    }
}
