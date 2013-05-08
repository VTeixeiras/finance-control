package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelUsuario;

public class ControlUsuario {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sqlValida = "SELECT * FROM usuarios WHERE usuario = ?";
    private String sqlInsert = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
    private String sqlListar = "SELECT * FROM usuarios";
    private String sqlDelete = "DELETE FROM usuarios WHERE id = ?";

    public void insere(ModelUsuario m) {

        if (validaUsuario(m)) {
            Alerta.msg("Aviso...", "O USUÁRIO já está cadastrado!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlInsert);
                ps.setString(1, m.getUsuario());
                ps.setString(2, m.getSenha());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "USUÁRIO cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlUsuario \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaUsuario(ModelUsuario m) {

        conn = Conexao.open();
        int cont = 0;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setString(1, m.getUsuario());

            rs = ps.executeQuery();

            while (rs.next()) {
                cont++;
            }

            if (cont >= 1) {
                return true;

            } else {
                return false;

            }

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLogin \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }

    }
    
    public ResultSet listaUsuarios() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlUsuario \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        } 
        
    }
    
    public void excluir(int cod) {
        
        conn = Conexao.open();
        
        try {
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, cod);
            ps.executeUpdate();

            Alerta.msg("Informação...", "USUÁRIO excluído com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlUsuario \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } 
        
    }
    
}
