package financecontrol;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.ViewLogin;

public class Main {

    public static void main(String[] args) {
        
        try {  
            try {  
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        } catch (IllegalAccessException e) {  
            // TODO  
        } catch (ClassNotFoundException e) {  
            // TODO  
        } catch (InstantiationException e) {  
            // TODO  
        }  
        
        ViewLogin v = new ViewLogin();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        
    }
}
