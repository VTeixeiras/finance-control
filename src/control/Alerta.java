package control;

import javax.swing.JOptionPane;

public class Alerta {
    
    public static void msg(String titulo, String mensagem, int tipo) {
        
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
        
    }
    
}
