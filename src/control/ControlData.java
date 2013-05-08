package control;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class ControlData {

    //Retorna a data no formato "JAVA.UTIL.DATE" no formato do banco de dados
    public Date userToDB(String dataString) {

        java.util.Date dataUtil = null;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataUtil = f.parse(dataString);
            
        } catch (ParseException ex) {
            Alerta.msg("Erro...", "Erro ao fazer conversão de data! \nLocal: ControlData \n"
                    + "Erro: " + ex.getMessage().toString(), JOptionPane.ERROR_MESSAGE);
            
        }
                
        return dataUtil;

    }
    
}