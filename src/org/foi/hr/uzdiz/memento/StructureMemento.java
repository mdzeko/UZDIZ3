/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.memento;

import org.foi.hr.uzdiz.composite.FSElementAbstract;

/**
 *
 * @author Miso
 */
public class StructureMemento {
    private FSElementAbstract structure;
    
    public StructureMemento(FSElementAbstract structToSave){
        this.structure = structToSave;
    }
    
    public FSElementAbstract getSavedState(){
        return structure;
    }
}
