package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelNotas;

public class ControlNotas {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private String sqlValida = "SELECT * FROM notas WHERE num_nota = ?";
    private String sqlInsert = "INSERT INTO notas (num_nota, descricao, data_lanc, data_emis, data_venc, valor, "
            + "total_parcelas, status_pgto, parcela_corrente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String sqlListar = "SELECT * FROM notas ORDER BY num_nota ASC";
    private String sqlDelete = "DELETE FROM notas WHERE id = ?";
    private String sqlPagar = "";
    
    
    public void insere(ModelNotas m) {

        if (validaLancamento(m)) {
            Alerta.msg("Aviso...", "Esta NOTA já está cadastrada!", JOptionPane.WARNING_MESSAGE);

        } else {
            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlInsert);
                ps.setString(1, m.getNumNota());
                ps.setString(2, m.getDescricao());
                ps.setDate(3, new java.sql.Date(m.getDataLancamento().getTime()));
                ps.setDate(4, new java.sql.Date(m.getDataEmissao().getTime()));
                ps.setDate(5, new java.sql.Date(m.getDataVencimento().getTime()));
                ps.setDouble(6, m.getValor());
                ps.setInt(7, m.getTotalParcelas());
                ps.setInt(8, m.getStatusPagamento());
                ps.setInt(9, m.getParcelaCorrente());
                ps.executeUpdate();

                Alerta.msg("Informação...", "NOTA cadastrada com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlNotas \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaLancamento(ModelNotas m) {
        conn = Conexao.open();
        int cont = 0;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setString(1, m.getNumNota());

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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlNotas \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }
    }

    public ResultSet listaNotas() {

        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlNotas \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }

    }

    public ResultSet listaNotas(String sql) {

        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlNotas \nErro: "
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

            Alerta.msg("Informação...", "NOTA excluído com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlNotas \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }

    }
    
    /* Método ainda nao utilizado */
    public void pagar(int cod) {

        if (validaPagamento(cod)) {
            
            conn = Conexao.open();
            String status = "PAGO";

            try {
                ps = conn.prepareStatement(sqlPagar);
                ps.setString(1, status);
                ps.setInt(2, cod);
                ps.executeUpdate();

                Alerta.msg("Informação...", "CONTA paga com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLancamentos \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            }
            
        } else {
            Alerta.msg("Aviso...", "A CONTA já está paga!", JOptionPane.WARNING_MESSAGE);
        }

    }
    /* Método ainda nao utilizado */
    private boolean validaPagamento(int cod) {

        conn = Conexao.open();
        int cont = 0;
        String s = "À PAGAR";
        boolean status = true;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setInt(1, cod);

            rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getString("status").equals(s)) {
                    status = false;

                } else {
                    status = true;

                }

            }

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLancamentos \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            status = true;

        } finally {
            Conexao.close(conn);
        }

        return status;

    }
    
}
