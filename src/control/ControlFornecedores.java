package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelFornecedores;

public class ControlFornecedores {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private List<ModelFornecedores> list = new ArrayList<>();
    
    private String sqlValida = "SELECT * FROM fornecedores WHERE nome = ?";
    private String sqlInsert = "INSERT INTO fornecedores (nome, endereco, telefone) VALUES (?, ?, ?)";
    private String sqlListar = "SELECT * FROM fornecedores ORDER BY nome ASC";
    private String sqlDelete = "DELETE FROM fornecedores WHERE id = ?";
    private String sqlAltera = "UPDATE fornecedores SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
    
    public void insere(ModelFornecedores m) {

        if (validaFornecedor(m)) {
            Alerta.msg("Aviso...", "Este FORNECEDOR já está cadastrado!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlInsert);
                ps.setString(1, m.getNome());
                ps.setString(2, m.getEndereco());
                ps.setString(3, m.getTelefone());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "FORNECEDOR cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFornecedores \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaFornecedor(ModelFornecedores m) {

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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFornecedores \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }

    }
    
    public void altera(ModelFornecedores m) {
        
        if (validaFornecedor(m)) {
            Alerta.msg("Aviso...", "Este FORNECEDOR já está cadastrado!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlAltera);
                ps.setString(1, m.getNome());
                ps.setString(2, m.getEndereco());
                ps.setString(3, m.getTelefone());
                ps.setInt(4, m.getCod());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "FORNECEDOR alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFornecedor \nErro: "
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

            Alerta.msg("Informação...", "FORNECEDOR excluído com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFornecedores \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } 
        
    }
    
    public List<ModelFornecedores> list() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            while(rs.next()) {
                ModelFornecedores m = new ModelFornecedores();
                m.setCod(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                
                list.add(m);
            }
            
            return list;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFornecedores \nErro: "
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
    
    public ResultSet listResultSet(String sql) {

        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFornecedores \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }

    }
}
