/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.composite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Apstraktna klasa za kompozitni element
 * @author Miso
 */
public abstract class FSElementAbstract {
    String name;
    String type;
    long lastModifiedMillis;
    public long size;
    public int indentLevel = 0;
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }
    
    public long getLastModified(){
        return lastModifiedMillis;
    }
    
    public long getSize(){
        return size;
    }
    
    public String getReadableLastModified(long millis){
        Date date = new Date(millis);
        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss");
        return formatter.format(date);
    }
    public abstract void ls();
}