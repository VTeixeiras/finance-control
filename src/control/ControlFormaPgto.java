package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelFormaPgto;

public class ControlFormaPgto {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private List<ModelFormaPgto> list = new ArrayList<>();
    
    private String sqlValida = "SELECT * FROM forma_pagamento WHERE tipo = ?";
    private String sqlInsert = "INSERT INTO forma_pagamento (tipo) VALUES (?)";
    private String sqlListar = "SELECT * FROM forma_pagamento ORDER BY tipo ASC";
    private String sqlDelete = "DELETE FROM forma_pagamento WHERE id = ?";
    private String sqlAltera = "UPDATE forma_pagamento SET tipo = ? WHERE id = ?";
    
    public void insere(ModelFormaPgto m) {

        if (validaForma(m)) {
            Alerta.msg("Aviso...", "Esta FORMA DE PAGAMENTO já está cadastrada!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlInsert);
                ps.setString(1, m.getTipo());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "FORMA DE PAGAMENTO cadastrada com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFormaPgto \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                
            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaForma(ModelFormaPgto m) {

        conn = Conexao.open();
        int cont = 0;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setString(1, m.getTipo());

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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFormaPgto \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }

    }
    
    public void altera(ModelFormaPgto m) {
        if (validaForma(m)) {
            Alerta.msg("Aviso...", "Esta FORMA DE PAGAMENTO já está cadastrada!", JOptionPane.WARNING_MESSAGE);
            
        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlAltera);
                ps.setString(1, m.getTipo());
                ps.setInt(2, m.getCod());
                ps.executeUpdate();                
                
                Alerta.msg("Informação...", "FORMA DE PAGAMENTO alterada com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFormaPgto \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }
    }
    
    public ResultSet listFormaPgtoRs() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFormaPgto \nErro: "
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

            Alerta.msg("Informação...", "FORMA DE PAGAMENTO excluída com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFormaPgto \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } 
        
    }
    
    public List<ModelFormaPgto> listFormaPgtoList() {
        
        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            while(rs.next()) {
                ModelFormaPgto m = new ModelFormaPgto();
                m.setCod(rs.getInt("id"));
                m.setTipo(rs.getString("tipo"));
                
                list.add(m);
            }
            
            return list;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlFormaPgto \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        } 
        
    }
    
}
