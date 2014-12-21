/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.composite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.foi.hr.uzdiz.help.Constants;

/**
 *
 * @author Miso
 */
public class ConcreteDirectory extends FSElementAbstract{
    File dir;
    public List<FSElementAbstract> content;
    public ConcreteDirectory(File dir){
        content = new ArrayList();
        this.dir = dir;
        name = dir.getName();
        type = Constants.TYPE_DIR;
        lastModifiedMillis = dir.lastModified();
    }
    
    public void addChild(FSElementAbstract element){
        this.content.add(element);
    }

    @Override
    public void ls() {
        System.out.println(Constants.COLLAPSE + " Naziv: " + name + "\tTip: " + type + "\tVelicina: "+ size +"\tZadnja promjena: " + getReadableLastModified(lastModifiedMillis));
        for(FSElementAbstract elem : content){
            for(int i = 0; i < elem.indentLevel; i++){
                System.out.print(Constants.VERTICAL_BARS + "\t");
            }
            elem.ls();
            if(elem instanceof ConcreteDirectory)
                System.out.println(Constants.VERTICAL_BARS);
        }
    }
}
