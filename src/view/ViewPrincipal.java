package view;

public class ViewPrincipal extends javax.swing.JFrame {

    public int codUserAtivo;
    
    public ViewPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnEmpresas = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnLancCredito = new javax.swing.JButton();
        btnLancDebito = new javax.swing.JButton();
        btnPagConta = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnRelatorio = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnBackup = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        bmMenus = new javax.swing.JMenuBar();
        mnSistema = new javax.swing.JMenu();
        smBackup = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        smUsuarios = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        smSair = new javax.swing.JMenuItem();
        mnContasBancarias = new javax.swing.JMenu();
        smBanco = new javax.swing.JMenuItem();
        smConta = new javax.swing.JMenuItem();
        mnFornecedores = new javax.swing.JMenu();
        smFornecedores = new javax.swing.JMenuItem();
        mnEmpresas = new javax.swing.JMenu();
        smEmpresas = new javax.swing.JMenuItem();
        mnPagamentos = new javax.swing.JMenu();
        smNotas = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        smFormaPagamento = new javax.swing.JMenuItem();
        mnLancamentos = new javax.swing.JMenu();
        smServicos = new javax.swing.JMenu();
        smExcluirLancamento = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        smLancCredito = new javax.swing.JMenuItem();
        smLancDebito = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        smPagConta = new javax.swing.JMenuItem();
        mnRelatorios = new javax.swing.JMenu();
        smRelLancamentos = new javax.swing.JMenuItem();
        mnSobre = new javax.swing.JMenu();
        smSobrePrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finance Control");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 32));

        btnEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/empresas_32x32.png"))); // NOI18N
        btnEmpresas.setFocusable(false);
        btnEmpresas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpresas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresasActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEmpresas);
        jToolBar1.add(jSeparator4);

        btnLancCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/credito_32x32.png"))); // NOI18N
        btnLancCredito.setFocusable(false);
        btnLancCredito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLancCredito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLancCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancCreditoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLancCredito);

        btnLancDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/debito_32x32.png"))); // NOI18N
        btnLancDebito.setFocusable(false);
        btnLancDebito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLancDebito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLancDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancDebitoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLancDebito);

        btnPagConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pagar_conta_32x32.png"))); // NOI18N
        btnPagConta.setFocusable(false);
        btnPagConta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagConta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPagConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagContaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPagConta);
        jToolBar1.add(jSeparator5);

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/relatorio_32x32.png"))); // NOI18N
        btnRelatorio.setFocusable(false);
        btnRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRelatorio);
        jToolBar1.add(jSeparator6);

        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/backup_32x32.png"))); // NOI18N
        btnBackup.setFocusable(false);
        btnBackup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBackup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBackup);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sair_32x32.png"))); // NOI18N
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSair);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Licenciado para: Elisabeth Apda. F. de Castro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo_finance_control.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIcon)
                .addGap(155, 155, 155))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(lblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mnSistema.setText("Sistema");

        smBackup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        smBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/backup_16x16.png"))); // NOI18N
        smBackup.setText("Backup");
        smBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smBackupActionPerformed(evt);
            }
        });
        mnSistema.add(smBackup);
        mnSistema.add(jSeparator1);

        smUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        smUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/usuarios_16x16.png"))); // NOI18N
        smUsuarios.setText("Usuários");
        smUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smUsuariosActionPerformed(evt);
            }
        });
        mnSistema.add(smUsuarios);
        mnSistema.add(jSeparator2);

        smSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        smSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sair_16x16.png"))); // NOI18N
        smSair.setText("Sair");
        smSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smSairActionPerformed(evt);
            }
        });
        mnSistema.add(smSair);

        bmMenus.add(mnSistema);

        mnContasBancarias.setText("Contas Bancárias");

        smBanco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        smBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/banco_16x16.png"))); // NOI18N
        smBanco.setText("Banco");
        smBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smBancoActionPerformed(evt);
            }
        });
        mnContasBancarias.add(smBanco);

        smConta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        smConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/conta_banco_16x16.png"))); // NOI18N
        smConta.setText("Conta");
        smConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smContaActionPerformed(evt);
            }
        });
        mnContasBancarias.add(smConta);

        bmMenus.add(mnContasBancarias);

        mnFornecedores.setText("Fornecedores");

        smFornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        smFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fornecedores_16x16.png"))); // NOI18N
        smFornecedores.setText("Fornecedores");
        smFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smFornecedoresActionPerformed(evt);
            }
        });
        mnFornecedores.add(smFornecedores);

        bmMenus.add(mnFornecedores);

        mnEmpresas.setText("Empresas");

        smEmpresas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        smEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/empresas_16x16.png"))); // NOI18N
        smEmpresas.setText("Empresas");
        smEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smEmpresasActionPerformed(evt);
            }
        });
        mnEmpresas.add(smEmpresas);

        bmMenus.add(mnEmpresas);

        mnPagamentos.setText("Pagamentos e Notas");

        smNotas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        smNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/notas_16x16.png"))); // NOI18N
        smNotas.setText("Notas");
        smNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smNotasActionPerformed(evt);
            }
        });
        mnPagamentos.add(smNotas);
        mnPagamentos.add(separador);

        smFormaPagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        smFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/forma_pgto_16x16.png"))); // NOI18N
        smFormaPagamento.setText("Formas de Pagamento");
        smFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smFormaPagamentoActionPerformed(evt);
            }
        });
        mnPagamentos.add(smFormaPagamento);

        bmMenus.add(mnPagamentos);

        mnLancamentos.setText("Lançamentos");

        smServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/atencao_16x16.png"))); // NOI18N
        smServicos.setText("Serviços");

        smExcluirLancamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        smExcluirLancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir_lancamento_16x16.png"))); // NOI18N
        smExcluirLancamento.setText("Exclusão de Lançamentos");
        smExcluirLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smExcluirLancamentoActionPerformed(evt);
            }
        });
        smServicos.add(smExcluirLancamento);

        mnLancamentos.add(smServicos);
        mnLancamentos.add(jSeparator3);

        smLancCredito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        smLancCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/credito_16x16.png"))); // NOI18N
        smLancCredito.setText("Crédito");
        smLancCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smLancCreditoActionPerformed(evt);
            }
        });
        mnLancamentos.add(smLancCredito);

        smLancDebito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        smLancDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/debito_16x16.png"))); // NOI18N
        smLancDebito.setText("Débito");
        smLancDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smLancDebitoActionPerformed(evt);
            }
        });
        mnLancamentos.add(smLancDebito);
        mnLancamentos.add(jSeparator7);

        smPagConta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        smPagConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pagar_conta_16x16.png"))); // NOI18N
        smPagConta.setText("Pagar Conta");
        smPagConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smPagContaActionPerformed(evt);
            }
        });
        mnLancamentos.add(smPagConta);

        bmMenus.add(mnLancamentos);

        mnRelatorios.setText("Relatórios");

        smRelLancamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        smRelLancamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/relatorio_16x16.png"))); // NOI18N
        smRelLancamentos.setText("Lançamentos");
        smRelLancamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smRelLancamentosActionPerformed(evt);
            }
        });
        mnRelatorios.add(smRelLancamentos);

        bmMenus.add(mnRelatorios);

        mnSobre.setText("Sobre");

        smSobrePrograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        smSobrePrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sobre_16x16.png"))); // NOI18N
        smSobrePrograma.setText("Sobre o Programa");
        smSobrePrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smSobreProgramaActionPerformed(evt);
            }
        });
        mnSobre.add(smSobrePrograma);

        bmMenus.add(mnSobre);

        setJMenuBar(bmMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smBackupActionPerformed
        ViewBackup v = new ViewBackup();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smBackupActionPerformed

    private void smUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smUsuariosActionPerformed
        ViewUsuarios v = new ViewUsuarios();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smUsuariosActionPerformed

    private void smSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_smSairActionPerformed

    private void smEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smEmpresasActionPerformed
        ViewEmpresas v = new ViewEmpresas();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smEmpresasActionPerformed

    private void smLancDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smLancDebitoActionPerformed
        ViewLancamento v = new ViewLancamento();
        v.setLocationRelativeTo(null);
        v.tipo = 2;
        v.setVisible(true);
    }//GEN-LAST:event_smLancDebitoActionPerformed

    private void smLancCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smLancCreditoActionPerformed
        ViewLancamento v = new ViewLancamento();
        v.setLocationRelativeTo(null);
        v.tipo = 1;
        v.setVisible(true);
    }//GEN-LAST:event_smLancCreditoActionPerformed

    private void smExcluirLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smExcluirLancamentoActionPerformed
        ViewExcLancamento v = new ViewExcLancamento();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smExcluirLancamentoActionPerformed

    private void smSobreProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smSobreProgramaActionPerformed
        ViewSobre v = new ViewSobre();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smSobreProgramaActionPerformed

    private void btnEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresasActionPerformed
        smEmpresasActionPerformed(null);
    }//GEN-LAST:event_btnEmpresasActionPerformed

    private void btnLancCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancCreditoActionPerformed
        smLancCreditoActionPerformed(null);
    }//GEN-LAST:event_btnLancCreditoActionPerformed

    private void btnLancDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancDebitoActionPerformed
        smLancDebitoActionPerformed(null);
    }//GEN-LAST:event_btnLancDebitoActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        smRelLancamentosActionPerformed(null);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        smBackupActionPerformed(null);
    }//GEN-LAST:event_btnBackupActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        smSairActionPerformed(null);
    }//GEN-LAST:event_btnSairActionPerformed

    private void smRelLancamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smRelLancamentosActionPerformed
        ViewRelLancamento v = new ViewRelLancamento();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smRelLancamentosActionPerformed

    private void smPagContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smPagContaActionPerformed
        ViewPagContas v = new ViewPagContas();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smPagContaActionPerformed

    private void btnPagContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagContaActionPerformed
        smPagContaActionPerformed(null);
    }//GEN-LAST:event_btnPagContaActionPerformed

    private void smBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smBancoActionPerformed
        ViewBanco v = new ViewBanco();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smBancoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void smContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smContaActionPerformed
        ViewContas v = new ViewContas();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smContaActionPerformed

    private void smFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smFornecedoresActionPerformed
        ViewFornecedores v = new ViewFornecedores();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smFornecedoresActionPerformed

    private void smFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smFormaPagamentoActionPerformed
        ViewFormaPgto v = new ViewFormaPgto();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smFormaPagamentoActionPerformed

    private void smNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smNotasActionPerformed
        ViewNotas v = new ViewNotas();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_smNotasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar bmMenus;
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnEmpresas;
    private javax.swing.JButton btnLancCredito;
    private javax.swing.JButton btnLancDebito;
    private javax.swing.JButton btnPagConta;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JMenu mnContasBancarias;
    private javax.swing.JMenu mnEmpresas;
    private javax.swing.JMenu mnFornecedores;
    private javax.swing.JMenu mnLancamentos;
    private javax.swing.JMenu mnPagamentos;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JMenu mnSistema;
    private javax.swing.JMenu mnSobre;
    private javax.swing.JPopupMenu.Separator separador;
    private javax.swing.JMenuItem smBackup;
    private javax.swing.JMenuItem smBanco;
    private javax.swing.JMenuItem smConta;
    private javax.swing.JMenuItem smEmpresas;
    private javax.swing.JMenuItem smExcluirLancamento;
    private javax.swing.JMenuItem smFormaPagamento;
    private javax.swing.JMenuItem smFornecedores;
    private javax.swing.JMenuItem smLancCredito;
    private javax.swing.JMenuItem smLancDebito;
    private javax.swing.JMenuItem smNotas;
    private javax.swing.JMenuItem smPagConta;
    private javax.swing.JMenuItem smRelLancamentos;
    private javax.swing.JMenuItem smSair;
    private javax.swing.JMenu smServicos;
    private javax.swing.JMenuItem smSobrePrograma;
    private javax.swing.JMenuItem smUsuarios;
    // End of variables declaration//GEN-END:variables
}
