package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelEmpresa;

public class ControlEmpresa {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private List<ModelEmpresa> listEmpresas = new ArrayList<>();
    
    private String sqlValida = "SELECT * FROM empresas WHERE nome = ?";
    private String sqlInsert = "INSERT INTO empresas (nome) VALUES (?)";
    private String sqlListar = "SELECT * FROM empresas ORDER BY nome ASC";
    private String sqlDelete = "DELETE FROM empresas WHERE id = ?";
    private String sqlAltera = "UPDATE empresas SET nome = ? WHERE id = ?";
    
    public void insere(ModelEmpresa m) {

        if (validaEmpresa(m)) {
            Alerta.msg("Aviso...", "Esta EMPRESA já está cadastrada!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlInsert);
                ps.setString(1, m.getNome());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "EMPRESA cadastrada com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlEmpresa \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaEmpresa(ModelEmpresa m) {

        conn = Conexao.open();
        int cont = 0;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setString(1, m.getNome());

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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlEmpresa \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }

    }
    
    public void altera(ModelEmpresa m) {
        if (validaEmpresa(m)) {
            Alerta.msg("Aviso...", "Esta EMPRESA já está cadastrada!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlAltera);
                ps.setString(1, m.getNome());
                ps.setInt(2, m.getCod());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "EMPRESA alterada com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlEmpresa \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }
    }
    
    public ResultSet listaEmpresa() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlEmpresa \nErro: "
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

            Alerta.msg("Informação...", "EMPRESA excluída com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlEmpresa \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } 
        
    }
    
    public List<ModelEmpresa> listEmpresas() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            while(rs.next()) {
                ModelEmpresa m = new ModelEmpresa();
                m.setCod(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                
                listEmpresas.add(m);
            }
            
            return listEmpresas;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlEmpresa \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        } 
        
    }
    
}
