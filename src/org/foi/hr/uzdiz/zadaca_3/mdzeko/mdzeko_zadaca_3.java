package org.foi.hr.uzdiz.zadaca_3.mdzeko;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.hr.uzdiz.mvc.Controller;
import org.foi.hr.uzdiz.mvc.Model;
import org.foi.hr.uzdiz.mvc.View;

/**
 *
 * @author miso
 */
public class mdzeko_zadaca_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View view = new View();
        
        Model model = new Model();
        model.setView(view);
        
        Controller ctrl = new Controller(args, model, view);
    }
    
}
