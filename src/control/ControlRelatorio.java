package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControlRelatorio {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql = "SELECT * FROM lancamentos WHERE data BETWEEN ? AND ? AND id_empresa = ? ORDER BY tipo asc, data asc";
    private Double totalCredito = 0.0;
    private Double totalDebito = 0.0;

    public ResultSet getRelLancamentos(Date de, Date ate, int empresa) {

        conn = Conexao.open();

        try {
            java.sql.Date deSQL = new java.sql.Date(de.getTime());
            java.sql.Date ateSQL = new java.sql.Date(ate.getTime());

            ps = conn.prepareStatement(sql);
            ps.setDate(1, deSQL);
            ps.setDate(2, ateSQL);
            ps.setInt(3, empresa);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlRelatorio \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }

    }

    /**
     *
     * @param de
     * @param ate
     * @param empresa
     * @return
     */
    public Double[] getTotais(Date de, Date ate, int empresa) {

        conn = Conexao.open();

        //Posição 0 -> Crédito
        //Posição 1 -> Débito
        Double totais[] = new Double[2];
        totais[0] = totais[1] = 0.0;

        try {
            java.sql.Date deSQL = new java.sql.Date(de.getTime());
            java.sql.Date ateSQL = new java.sql.Date(ate.getTime());

            ps = conn.prepareStatement(sql);
            ps.setDate(1, deSQL);
            ps.setDate(2, ateSQL);
            ps.setInt(3, empresa);
            rs = ps.executeQuery();


            while (rs.next()) {
                if (rs.getString("tipo").equals("Débito")) {
                    totais[1] += rs.getDouble("valor");

                } else {
                    totais[0] += rs.getDouble("valor");
                }
            }

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlRelatorio \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

            return null;

        }

        return totais;
        
    }
}
