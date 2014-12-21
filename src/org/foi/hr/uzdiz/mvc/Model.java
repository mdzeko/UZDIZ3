/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.mvc;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.hr.uzdiz.composite.ConcreteDirectory;
import org.foi.hr.uzdiz.composite.ConcreteFile;
import org.foi.hr.uzdiz.composite.FSElementAbstract;
import org.foi.hr.uzdiz.help.ChangeDetector;
import org.foi.hr.uzdiz.help.Constants;
import org.foi.hr.uzdiz.memento.MementoCaretaker;
import org.foi.hr.uzdiz.memento.StructureMemento;
import org.foi.hr.uzdiz.zadaca_3.mdzeko.mdzeko_zadaca_3;

/**
 *
 * @author Miso
 */
public class Model {
    View view;
    
    public File readDir;
    int threadOffset;
    File outputFile;
    public ConcreteDirectory fileTreeComposite;
    public int dirsNum;
    public int filesNum;
    
    MementoCaretaker caretaker;
    
    ChangeDetector changeThread;
    
    int numOfDirs, numOfFiles;
    
    private static int indent = 0;
    
    public void setView(View v){
        this.view = v;
    }
    /**
     * Parsira parametre s komandne linije
     * @param args
     * @return @true ako su parametri valjani, inale @false
     */
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
            Constants.WRITE_OUTPUT_FILE = true;
            Constants.OUTPUT_FILE = outputFile;
        }
        view.updateOutput(Constants.CMD_ARGS_VALID);
        return true;
    }
    
    public void buildHierarchy(){
        fileTreeComposite = buildFileTree(readDir);
        fileTreeComposite.size = getDirSizes(fileTreeComposite.content);
    }
    
    public ConcreteDirectory buildFileTree(File root){
        ConcreteDirectory dir = new ConcreteDirectory(root);
        dir.indentLevel = indent;
        indent++;
        for(File f : root.listFiles()){
            if(f.isFile()){
                ConcreteFile file = new ConcreteFile(f);
                file.indentLevel = indent;
                dir.content.add(file);
                numOfFiles++;
            }
            else if(f.isDirectory()){
                numOfDirs++;
                dir.content.add(buildFileTree(f));
            }
        }
        indent--;
        return dir;
    }
    
    public int getDirSizes(List<FSElementAbstract> list){
        int size = 0;
        for(FSElementAbstract elem : list){
            if(elem instanceof ConcreteDirectory){
                size = ((ConcreteDirectory) elem).content.size();
                elem.size = size;
                getDirSizes(((ConcreteDirectory) elem).content);
            }
        }
        return size;
    }
    
    public void printNumberOfElements(){
        view.updateOutput(Constants.NUMBER_OF + Constants.TYPE_DIR + "a: " + numOfDirs);
        view.updateOutput(Constants.NUMBER_OF + Constants.TYPE_FILE + ": " + numOfFiles);
    }
    
    public void printFileStructure(){
        fileTreeComposite.ls();
        view.updateOutput("");
    }
    
    public void startThread(){
        caretaker = new MementoCaretaker();
        caretaker.addMemento(saveToMemento());
        if(!changeThread.isAlive()){
            changeThread = new ChangeDetector(this);
            changeThread.start();
        }
    }
    
    public void stopThread(){
        if(changeThread.isAlive())
            changeThread.interrupt();
    }
    
    public StructureMemento saveToMemento(){
        return new StructureMemento(fileTreeComposite);
    }
    
    public void restoreFromMemento(StructureMemento memento){
        fileTreeComposite = (ConcreteDirectory) memento.getSavedState();
    }
    
    public void compareStates(ConcreteDirectory savedState, ConcreteDirectory currentState){
    }
    
    public void reloadState(int index){
        if(caretaker != null){
            fileTreeComposite = (ConcreteDirectory) caretaker.getStructureMemento(index).getSavedState();
        }
    }
    
}
