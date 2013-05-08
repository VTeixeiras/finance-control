package conexao;

import control.Alerta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    //Atributos da Classe
    private static String url = "jdbc:mysql://localhost:3306/financecontrol";
    private static String user = "root";
    private static String password ="";
    private static Connection conn = null;
    
    
    //Método para executar a conexão com o Banco de Dados
    public static Connection open()
    {
        Conexao c = new Conexao();
        try {
            //Classe de Conexão com o PostgreSQL
            Class.forName("org.gjt.mm.mysql.Driver");
            
            try {
                //Realizar a Conexão com o BD.
                conn = DriverManager.getConnection(url, user, password);
                
            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: Conexao \nErro: " + ex.getMessage(), 
                    JOptionPane.ERROR_MESSAGE);
                
            } 
            
        } catch (ClassNotFoundException ex) {
            Alerta.msg("Erro...", "Não foi possível encontrar a classe de conexão! \nLocal: Conexao", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return conn;
    }
    
    public static void close(Connection c) {
        if(conn != null) {
            try {
                c.close();
            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Não foi possível fechar a conexao com o banco de dados! \nLocal: Conexao", 
                        JOptionPane.ERROR_MESSAGE);
                
            } catch (Exception ex) {
                Alerta.msg("Erro...", "Não foi possível fechar a conexao com o banco de dados! \nLocal: Conexao \nErro: " +
                        ex.getMessage().toString(), JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }
        
}

