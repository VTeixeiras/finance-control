package view;

import control.Alerta;
import control.ControlBanco;
import control.ControlContas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelBanco;
import model.ModelConta;

public class ViewContas extends javax.swing.JFrame {

    public ViewContas() {
        initComponents();
    }

    DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Código", "Titular", "Agência", "N° Conta", "Banco"});
    ResultSet rs;
    
    private int cod;
    private boolean ativo = true; 
    private List<ModelBanco> listBanco = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumConta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbBanco = new javax.swing.JComboBox();
        btnNovoBanco = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContas = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Conta"));

        jLabel1.setText("Nome do Titular");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok_16x16.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Agência");

        jLabel3.setText("N° Conta");

        jLabel4.setText("Banco");

        btnNovoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/novo_16x16.png"))); // NOI18N
        btnNovoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar))
                    .addComponent(txtNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 98, Short.MAX_VALUE))
                            .addComponent(txtAgencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovoBanco)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNovoBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbBanco)
                    .addComponent(txtNumConta)
                    .addComponent(txtAgencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contas Cadastradas"));

        tbContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Titular", "Agência", "N° Conta", "Banco"
            }
        ));
        jScrollPane1.setViewportView(tbContas);
        tbContas.getColumnModel().getColumn(1).setPreferredWidth(300);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar_16x16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok_16x16.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar_16x16.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir_16x16.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir)
                        .addComponent(btnEditar)
                        .addComponent(btnSalvar))
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void criaTabela() {
        tbContas.setModel(modelo);
        tbContas.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void preencheTabela() {
        modelo.setNumRows(0);

        ControlContas c = new ControlContas();
        ControlBanco cb = new ControlBanco();
        rs = c.listResultSet();

        try {

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("titular"), rs.getObject("agencia"), rs.getObject("conta"), 
                              (Object) cb.idParaNome(Integer.parseInt(String.valueOf(rs.getObject("id_banco"))))});
            }

        } catch (SQLException ex) {
            Alerta.msg("Erro...", "Erro de SQL! \nLocal: ViewContas \nErro: " + ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE);

        }
    }
     
    private void preencheBanco() {
        ControlBanco c = new ControlBanco();
        int i = 0;
        listBanco = c.list();
        
        cbBanco.removeAllItems();
        
        while(i < listBanco.size()) {
            cbBanco.addItem(listBanco.get(i).getBanco());
            i++;
        }
    }
    
    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome = txtNome.getText().toUpperCase();
        String agencia = txtAgencia.getText().toUpperCase();
        String numConta = txtNumConta.getText().toUpperCase();
        int idBanco = listBanco.get(cbBanco.getSelectedIndex()).getId();
        
        if (nome.trim().equals("")) {
            Alerta.msg("Aviso...", "O campo NOME não pode ficar em branco!", JOptionPane.WARNING_MESSAGE);

        } else if(agencia.trim().equals("")) {
            Alerta.msg("Aviso...", "O campo AGÊNCIA não pode ficar em branco!", JOptionPane.WARNING_MESSAGE);
            
        } else if(numConta.trim().equals("")) {
            Alerta.msg("Aviso...", "O campo N° CONTA não pode ficar em branco!", JOptionPane.WARNING_MESSAGE);
        } else {
            ModelConta m = new ModelConta();
            m.setTitular(nome);
            m.setAgencia(agencia);
            m.setConta(numConta);
            m.setId_banco(idBanco);

            ControlContas c = new ControlContas();
            c.insere(m);

            txtNome.setText("");
            txtAgencia.setText("");
            txtNumConta.setText("");
            txtNome.requestFocus();
            preencheTabela();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText().toUpperCase();
        String agencia = txtAgencia.getText().toUpperCase();
        String numConta = txtNumConta.getText().toUpperCase();
        int idBanco = listBanco.get(cbBanco.getSelectedIndex()).getId();
        
        if (nome.trim().equals("")) {
            Alerta.msg("Aviso...", "O campo NOME não pode ficar em branco!", JOptionPane.WARNING_MESSAGE);

        } else if(agencia.trim().equals("")) {
            Alerta.msg("Aviso...", "O campo AGÊNCIA não pode ficar em branco!", JOptionPane.WARNING_MESSAGE);
            
        } else if(numConta.trim().equals("")) {
            Alerta.msg("Aviso...", "O campo N° CONTA não pode ficar em branco!", JOptionPane.WARNING_MESSAGE);
            
        } else {
            ModelConta m = new ModelConta();
            m.setTitular(nome);
            m.setAgencia(agencia);
            m.setConta(numConta);
            m.setId_banco(idBanco);

            ControlContas c = new ControlContas();
            c.altera(m);

            txtNome.setText("");
            txtAgencia.setText("");
            txtNumConta.setText("");
            txtNome.requestFocus();
            preencheTabela();

            btnCadastrar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnEditar.setEnabled(true);
            btnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tbContas.getSelectedRow();
        ativo = false;

        if (linha == -1) {
            Alerta.msg("Aviso...", "Selecione um registro para ser alterado!", JOptionPane.WARNING_MESSAGE);

        } else {

            btnCadastrar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnEditar.setEnabled(false);
            btnSalvar.setEnabled(true);

            cod = Integer.parseInt(String.valueOf(tbContas.getValueAt(linha, 0)));
            String nome = String.valueOf(tbContas.getValueAt(linha, 1));
            String agencia = String.valueOf(tbContas.getValueAt(linha, 2));
            String numConta = String.valueOf(tbContas.getValueAt(linha, 3));
                        
            txtNome.setText(nome);
            txtAgencia.setText(agencia);
            txtNumConta.setText(numConta);

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tbContas.getSelectedRow();

        if (linha == -1) {
            Alerta.msg("Aviso...", "Selecione um registro para ser excluído!", JOptionPane.WARNING_MESSAGE);

        } else {

            int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este registro?", "Pergunta...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resp == 0) {

                int codigo = Integer.parseInt(String.valueOf(tbContas.getValueAt(linha, 0)));

                ControlContas c = new ControlContas();
                c.excluir(codigo);

                preencheTabela();
            }

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        criaTabela();
        preencheTabela();
        preencheBanco();
    }//GEN-LAST:event_formWindowOpened

    private void btnNovoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoBancoActionPerformed
        ViewBanco v = new ViewBanco();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_btnNovoBancoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencheBanco();
    }//GEN-LAST:event_formWindowGainedFocus

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewContas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovoBanco;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbBanco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbContas;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumConta;
    // End of variables declaration//GEN-END:variables
}
