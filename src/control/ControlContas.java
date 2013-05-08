package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelConta;

public class ControlContas {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private List<ModelConta> list = new ArrayList<>();
    
    private String sqlValida = "SELECT * FROM conta WHERE conta = ?";
    private String sqlInsert = "INSERT INTO conta (titular, id_banco, agencia, conta) VALUES (?, ?, ?, ?)";
    private String sqlListar = "SELECT * FROM conta ORDER BY titular ASC";
    private String sqlDelete = "DELETE FROM conta WHERE id = ?";
    private String sqlAltera = "UPDATE conta SET titular = ?, id_banco = ?, agencia = ?, conta = ? WHERE id = ?";
    
    
    public void insere(ModelConta m) {

        if (validaContas(m)) {
            Alerta.msg("Aviso...", "Esta CONTA já está cadastrada!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlInsert);
                ps.setString(1, m.getTitular());
                ps.setInt(2, m.getId_banco());
                ps.setString(3, m.getAgencia());
                ps.setString(4, m.getConta());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "CONTA cadastrada com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlContas \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaContas(ModelConta m) {

        conn = Conexao.open();
        int cont = 0;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setString(1, m.getConta());

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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlContas \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }

    }
    
    public void altera(ModelConta m) {
        
        if (validaContas(m)) {
            Alerta.msg("Aviso...", "Esta CONTA já está cadastrada!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlAltera);
                ps.setString(1, m.getTitular());
                ps.setInt(2, m.getId_banco());
                ps.setString(3, m.getAgencia());
                ps.setString(4, m.getConta());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "CONTA alterada com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlContas \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }
    }
    
    public void excluir(int cod) {
        
        conn = Conexao.open();
        
        try {
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, cod);
            ps.executeUpdate();

            Alerta.msg("Informação...", "CONTA excluída com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlContas \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } 
        
    }
    
    public List<ModelConta> list() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            while(rs.next()) {
                ModelConta m = new ModelConta();
                m.setId(rs.getInt("id"));
                m.setConta(rs.getString("conta"));
                
                list.add(m);
            }
            
            return list;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlContas \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }     
    }
    
    public ResultSet listResultSet() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();
        
            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlContas \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }     
    }
    
}
