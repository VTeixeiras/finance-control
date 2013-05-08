package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelLogin;

public class ControlLogin {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private String sqlValida = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
    private int codUsuarioAtivo = 6969;
    
    public boolean validaLogin(ModelLogin m) {
        
        conn = Conexao.open();
        int cont = 0;
        
        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setString(1, m.getUsuario());
            ps.setString(2, m.getSenha());
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                codUsuarioAtivo = rs.getInt("id");
                cont++;
            }
                        
            if(cont == 1) {
                return true;
                
            } else {
                return false;
                
            }
            
        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLogin \nErro: " +
                        ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            
            return false;
            
        } finally {
            Conexao.close(conn);
            
        }
        
        
        
    }
    
    public int getCodUsuarioAtivo() {
        return this.codUsuarioAtivo;
    }
}
