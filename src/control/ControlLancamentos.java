package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;
import model.ModelLancamento;

public class ControlLancamentos {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private String sqlValida = "SELECT * FROM lancamentos WHERE num_cheque = ?";
    private String sqlInsert = "INSERT INTO lancamentos (data, num_cheque, valor, id_empresa, descricao, tipo, status) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private String sqlListar = "SELECT * FROM lancamentos ORDER BY id DESC";
    private String sqlDelete = "DELETE FROM lancamentos WHERE id = ?";
    private String sqlPagar = "UPDATE lancamentos SET status = ? WHERE id = ?";
    private String sqlValidaPagamento = "SELECT status FROM lancamentos WHERE id = ?";

    public void insere(ModelLancamento m) {

        if (validaLancamento(m)) {
            Alerta.msg("Aviso...", "Este N° DE CHEQUE já está cadastrado!", JOptionPane.WARNING_MESSAGE);

        } else {
            conn = Conexao.open();

            try {
                Date data = new Date(m.getData().getTime());
                ps = conn.prepareStatement(sqlInsert);
                ps.setDate(1, new java.sql.Date(data.getTime()));
                ps.setInt(2, m.getNumCheque());
                ps.setDouble(3, m.getValor());
                ps.setInt(4, m.getIdEmpresa());
                ps.setString(5, m.getDescricao());
                ps.setString(6, m.getTipo());
                ps.setString(7, m.getStatus());

                ps.executeUpdate();

                Alerta.msg("Informação...", "LANÇAMENTO cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLancamento \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaLancamento(ModelLancamento m) {
        conn = Conexao.open();
        int cont = 0;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setInt(1, m.getNumCheque());

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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLancamentos \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }
    }

    public ResultSet listaLancamentos() {

        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLancamentos \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }

    }

    public ResultSet listaLancamentos(String sql) {

        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLancamentos \nErro: "
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

            Alerta.msg("Informação...", "LANÇAMENTO excluído com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlLancamentos \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }

    }

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
