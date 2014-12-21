/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.hr.uzdiz.help;

import java.io.File;

/**
 *
 * @author Miso
 */
public class Constants {
    public static final String NUM_ARGS_ERROR = "Krivi broj argumenata!";
    public static final String OUTPUT_FILE_ERROR = "Izlazna datoteka je pogrešno zadana!";
    public static final String SECOND_ARG_ERROR = "Argument ciklusa dretve nije prirodan broj";
    public static final String ROOT_NOT_DIR_ERROR = "Putanja ne vodi do direktorija";
    public static final String HIERARCHY_ERROR = "Pogreška kod izrade hijerarhije";
    
    public static final String CMD_ARGS_VALID = "Argumenti komandne linije su valjani";
    public static final String RIGHT_ARROW = "\u21D2";
    public static final String VERTICAL_BARS = "\uFE33";
    public static final String COLLAPSE = "\u229F";
    
    public static final String TYPE_FILE = "datoteka";
    public static final String TYPE_DIR = "direktorij";
    public static final String NUMBER_OF = "Broj ";
    
    public static boolean WRITE_OUTPUT_FILE = false;
    public static File OUTPUT_FILE;
    
    public static int indentLevel = 0;
}
