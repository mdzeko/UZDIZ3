/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.composite;

import java.io.File;
import org.foi.hr.uzdiz.help.Constants;


/**
 *
 * @author Miso
 */
public class ConcreteFile extends FSElementAbstract{
    public ConcreteFile(File f){
        name = f.getName();
        type = Constants.TYPE_FILE;
        lastModifiedMillis = f.lastModified();
        size = f.length();
    }
    @Override
    public void ls() {
        System.out.println("Naziv: " + name + "\tTip: " + type + "\tVelicina: "+ size +"\tZadnja promjena: " + getReadableLastModified(lastModifiedMillis));
    }
    
}
