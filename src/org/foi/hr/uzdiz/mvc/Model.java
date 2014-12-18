/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.mvc;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.hr.uzdiz.help.Constants;
import org.foi.hr.uzdiz.zadaca_3.mdzeko.mdzeko_zadaca_3;

/**
 *
 * @author Miso
 */
public class Model {
    View view;
    
    File readDir;
    int threadOffset;
    File outputFile;
    
    int numOfDirs, numOfFiles;
    
    public void setView(View v){
        this.view = v;
    }
    public boolean parseData(String[] args){
        if(view == null) return false;
        if(args.length < 2){
                view.updateOutput(Constants.NUM_ARGS_ERROR);
                return false;
            }
        int argNum = args.length;
        readDir = new File(args[0]);
        if(!readDir.isDirectory()){
            view.updateOutput(Constants.ROOT_NOT_DIR_ERROR);
            return false;
        }
        try{
            threadOffset = Integer.parseInt(args[1]);
        }catch(NumberFormatException e){
            view.updateOutput(Constants.SECOND_ARG_ERROR + " " + e);
            return false;
        }
        if(argNum == 3){
            outputFile = new File(args[2]);
            if(!outputFile.isDirectory() && !outputFile.exists()){
                try {
                    outputFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(mdzeko_zadaca_3.class.getName()).log(Level.SEVERE, null, ex);
                    view.updateOutput(Constants.OUTPUT_FILE_ERROR);
                    return false;
                }
            }
            else if(!outputFile.isFile()){
                view.updateOutput(Constants.OUTPUT_FILE_ERROR);
                return false;
            }
        }
        view.updateOutput(Constants.CMD_ARGS_VALID);
        return true;
    }
    
}
