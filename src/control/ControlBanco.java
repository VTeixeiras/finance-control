package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelBanco;

public class ControlBanco {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private List<ModelBanco> listBanco = new ArrayList<>();
    
    private String sqlValida = "SELECT * FROM banco WHERE nome = ?";
    private String sqlInsert = "INSERT INTO banco (nome) VALUES (?)";
    private String sqlListar = "SELECT * FROM banco ORDER BY nome ASC";
    private String sqlDelete = "DELETE FROM banco WHERE id = ?";
    private String sqlAltera = "UPDATE banco SET nome = ? WHERE id = ?";
    private String sqlIdParaTexto = "SELECT nome FROM banco WHERE id = ?";

    public void insere(ModelBanco m) {

        if (validaBanco(m)) {
            Alerta.msg("Aviso...", "Este BANCO já está cadastrada!", JOptionPane.WARNING_MESSAGE);

        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlInsert);
                ps.setString(1, m.getBanco());
                ps.executeUpdate();

                Alerta.msg("Informação...", "BANCO cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlBanco \nErro: "
                        + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            } finally {
                Conexao.close(conn);
            }

        }

    }

    private boolean validaBanco(ModelBanco m) {

        conn = Conexao.open();
        int cont = 0;

        try {
            ps = conn.prepareStatement(sqlValida);
            ps.setString(1, m.getBanco());

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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlBanco \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return true;

        } finally {
            Conexao.close(conn);
        }

    }

    public void altera(ModelBanco m) {
        if (validaBanco(m)) {
            Alerta.msg("Aviso...", "Este BANCO já está cadastrada!", JOptionPane.WARNING_MESSAGE);

        } else {

            conn = Conexao.open();

            try {
                ps = conn.prepareStatement(sqlAltera);
                ps.setString(1, m.getBanco());
                ps.setInt(2, m.getId());
                ps.executeUpdate();

                Alerta.msg("Informação...", "BANCO alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlBanco \nErro: "
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

            Alerta.msg("Informação...", "BANCO excluído com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlBanco \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }

    }

    public List<ModelBanco> list() {

        conn = Conexao.open();

        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            while (rs.next()) {
                ModelBanco m = new ModelBanco();
                m.setId(rs.getInt("id"));
                m.setBanco(rs.getString("nome"));

                listBanco.add(m);
            }

            return listBanco;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlBanco \nErro: "
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
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlBanco \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }
    }

    public String idParaNome(int cod) {
        conn = Conexao.open();
        String nome = "ERRO";

        try {
            ps = conn.prepareStatement(sqlIdParaTexto);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            while(rs.next()) {
                nome = rs.getString("nome");
            }

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlBanco \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } 
        
        return nome;
    }
}
