package control;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelStatus;

public class ControlStatus {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private List<ModelStatus> list = new ArrayList<>();
    
    private String sqlListar = "SELECT * FROM status_pgto ORDER BY id DESC";
    
    public List<ModelStatus> listaCb() {
        
        conn = Conexao.open();
        
        try {
            ps = conn.prepareStatement(sqlListar);
            rs = ps.executeQuery();

            while (rs.next()) {
                ModelStatus m = new ModelStatus();
                m.setCod(rs.getInt("id"));
                m.setStatus(rs.getString("status_pgto"));
                list.add(m);
            }

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ControlStatus \nErro: "
                    + ex.getMessage(), JOptionPane.ERROR_MESSAGE);


        } finally {
            Conexao.close(conn);
        }
        
        return this.list;
    }
    
}
