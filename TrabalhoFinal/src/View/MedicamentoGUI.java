
package View;

import Model.Fazenda;
import Model.Medicamento;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.ModelTable;
import Model.Usuario;
import dao.FazendaDAO;
import dao.MedicamentoDAO;


public class MedicamentoGUI extends javax.swing.JFrame {

    private Medicamento objMedicamento;
    private MedicamentoDAO objDAO;
    private FazendaDAO objDAO2;
    private boolean buscar = false;
    private boolean buscarFazenda;
   
    public MedicamentoGUI() {
        initComponents();
        objMedicamento = new Medicamento();
        setSize(1200,600);
        this.setLocationRelativeTo(null);       
        this.setResizable(false);        
        carregarTableMed(null);
        carregarTable(null);
        }
    
     public void carregarTable(Fazenda objFazenda) {

        objDAO2 = new FazendaDAO();
        ArrayList dados = new ArrayList();
        if (buscarFazenda) {
            dados = objDAO2.buscarFazenda(objFazenda);
        } else {
            objFazenda = new Fazenda();
            dados = objDAO2.listarTodosFazenda();
        }
        String[] colunas = objFazenda.getColunas();

        ModelTable modelo = new ModelTable(dados, colunas);

        tbListagemUsuario.setModel(modelo);
        tbListagemUsuario.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbListagemUsuario.getColumnModel().getColumn(0).setResizable(false);
        tbListagemUsuario.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbListagemUsuario.getColumnModel().getColumn(1).setResizable(false);
        tbListagemUsuario.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbListagemUsuario.getColumnModel().getColumn(2).setResizable(false);
        tbListagemUsuario.getTableHeader().setReorderingAllowed(false);
        
    }
    
    public void selectRegistryTablefazenda() {

        txtIDFazenda.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 0).toString());

                
    }

    public void carregarTableMed(Medicamento objMedicamento) {

        objDAO = new MedicamentoDAO();
        ArrayList dados = new ArrayList();
        if (buscar) {
            dados = objDAO.buscarMed(objMedicamento);
        } else {
            objMedicamento = new Medicamento();
            dados = objDAO.listarTodosMed();
        }
        String[] colunas = objMedicamento.getColunas();

        ModelTable modelo = new ModelTable(dados, colunas);

        tbListagemMed.setModel(modelo);
        tbListagemMed.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbListagemMed.getColumnModel().getColumn(0).setResizable(false);
        tbListagemMed.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbListagemMed.getColumnModel().getColumn(1).setResizable(false);
        tbListagemMed.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbListagemMed.getColumnModel().getColumn(2).setResizable(false);
        tbListagemMed.getTableHeader().setReorderingAllowed(false);
        
    }
    public void selectRegistryTable() {

        txtIDMed.setText(tbListagemMed.getValueAt(tbListagemMed.getSelectedRow(), 0).toString());

        //Object objNome = tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 1);
        txtNomeMed.setText(tbListagemMed.getValueAt(tbListagemMed.getSelectedRow(), 1).toString());
        txtTipoMed.setText(tbListagemMed.getValueAt(tbListagemMed.getSelectedRow(), 2).toString());
        txtQuantidadeMed.setText(tbListagemMed.getValueAt(tbListagemMed.getSelectedRow(), 3).toString());
        txtObservacao.setText(tbListagemMed.getValueAt(tbListagemMed.getSelectedRow(), 4).toString());
        txtIDFazenda.setText(tbListagemMed.getValueAt(tbListagemMed.getSelectedRow(), 5).toString());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtIDMed = new javax.swing.JTextField();
        txtNomeMed = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTipoMed = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidadeMed = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        tbnSalvarMed = new javax.swing.JButton();
        tbnLimparMed = new javax.swing.JButton();
        btnDeletarMed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListagemMed = new javax.swing.JTable();
        btnBuscarMed = new javax.swing.JButton();
        tbnExitMed = new javax.swing.JButton();
        tbnExit1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDFazenda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbListagemUsuario = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("ID");

        txtIDMed.setEditable(false);

        txtNomeMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMedActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome do Produto");

        jLabel3.setText("Tipo");

        txtTipoMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoMedActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantidade");

        jLabel4.setText("Observação");

        tbnSalvarMed.setText("Salvar");
        tbnSalvarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSalvarMedActionPerformed(evt);
            }
        });

        tbnLimparMed.setText("Limpar");
        tbnLimparMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLimparMedActionPerformed(evt);
            }
        });

        btnDeletarMed.setText("Deletar");
        btnDeletarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarMedActionPerformed(evt);
            }
        });

        tbListagemMed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Produto", "Tipo", "Quantidade", "Observação", "IDFazenda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListagemMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListagemMedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListagemMed);

        btnBuscarMed.setText("Buscar");
        btnBuscarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMedActionPerformed(evt);
            }
        });

        tbnExitMed.setText("Sair");
        tbnExitMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExitMedActionPerformed(evt);
            }
        });

        tbnExit1.setText("Testar Conexão");
        tbnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExit1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("MEDICAMENTOS");

        jLabel7.setText("Codigo da fazenda");

        tbListagemUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Email", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListagemUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListagemUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbListagemUsuario);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tabela Fazendas");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Selecione uma Fazenda na Tabela de fazenda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIDMed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoMed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tbnSalvarMed)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tbnLimparMed)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDeletarMed))
                                .addComponent(txtObservacao, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantidadeMed, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIDFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))))
                            .addComponent(txtNomeMed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(339, 339, 339)
                                        .addComponent(btnBuscarMed)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tbnExitMed)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tbnExit1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(435, 435, 435)
                                        .addComponent(jLabel9)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnExitMed)
                            .addComponent(btnBuscarMed)
                            .addComponent(tbnExit1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantidadeMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnLimparMed)
                            .addComponent(tbnSalvarMed)
                            .addComponent(btnDeletarMed))
                        .addGap(31, 31, 31)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeMedActionPerformed

    private void txtTipoMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoMedActionPerformed

    private void tbnSalvarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSalvarMedActionPerformed

        objMedicamento = new Medicamento();
        objMedicamento.setIdMed(txtIDMed.getText());
        objMedicamento.setNomeMed(txtNomeMed.getText());
        objMedicamento.setTipo(txtTipoMed.getText());
        objMedicamento.setQuantidade(txtQuantidadeMed.getText());
        objMedicamento.setObservacao(txtObservacao.getText());
        objMedicamento.setIDFazenda(txtIDFazenda.getText());

        if ((txtNomeMed.getText().isEmpty()) || (txtTipoMed.getText().isEmpty()) || (txtQuantidadeMed.getText().isEmpty()) || (txtObservacao.getText().isEmpty())|| (txtIDFazenda.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new MedicamentoDAO();
            objDAO.salvarMed(objMedicamento);
            JOptionPane.showMessageDialog(null, "Medicamento " + txtNomeMed.getText() + " inserido com sucesso! ");
        }

        carregarTableMed(null);

        // apaga os dados preenchidos nos campos de texto
        setClearMed();
    }//GEN-LAST:event_tbnSalvarMedActionPerformed

    private void tbnLimparMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLimparMedActionPerformed
        setClearMed();
        carregarTableMed(null);
    }//GEN-LAST:event_tbnLimparMedActionPerformed

    private void btnDeletarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarMedActionPerformed
        objMedicamento.setIdMed(txtIDMed.getText());

        if ((txtIDMed.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new MedicamentoDAO();
            objDAO.deletarMed(objMedicamento);
            JOptionPane.showMessageDialog(null, "Medicamento Removido com Sucesso! ");
        }

        carregarTableMed(null);

        setClearMed();
    }//GEN-LAST:event_btnDeletarMedActionPerformed

    private void tbListagemMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemMedMouseClicked
        // TODO add your handling code here:
        selectRegistryTable();
    }//GEN-LAST:event_tbListagemMedMouseClicked

    private void btnBuscarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMedActionPerformed
        objMedicamento = new Medicamento();
        objMedicamento.setNomeMed(txtNomeMed.getText());
        objMedicamento.setTipo(txtTipoMed.getText());
        objMedicamento.setIDFazenda(txtIDFazenda.getText());

        if ((!txtNomeMed.getText().isEmpty()) || (!txtTipoMed.getText().isEmpty())|| (!txtIDFazenda.getText().isEmpty())) {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new MedicamentoDAO();
            buscar = true;
            carregarTableMed(objMedicamento);
        }else{
            buscar = false;
            carregarTableMed(null);
        }

        // apaga os dados preenchidos nos campos de texto
        setClearMed();
    }//GEN-LAST:event_btnBuscarMedActionPerformed

    private void tbnExitMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExitMedActionPerformed
        dispose();      
        
        
    }//GEN-LAST:event_tbnExitMedActionPerformed

    private void tbnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExit1ActionPerformed
        try {
            MedicamentoDAO.testarConexaoMed();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_tbnExit1ActionPerformed

    private void tbListagemUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemUsuarioMouseClicked
        // TODO add your handling code here:
        selectRegistryTablefazenda();
    }//GEN-LAST:event_tbListagemUsuarioMouseClicked

    public void setClearMed() {
        txtIDMed.setText(null);
        txtNomeMed.setText(null);
        txtTipoMed.setText(null);
        txtQuantidadeMed.setText(null);
        txtObservacao.setText(null);
        txtIDFazenda.setText(null);
    }
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
            java.util.logging.Logger.getLogger(MedicamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicamentoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMed;
    private javax.swing.JButton btnDeletarMed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbListagemMed;
    private javax.swing.JTable tbListagemUsuario;
    private javax.swing.JButton tbnExit1;
    private javax.swing.JButton tbnExitMed;
    private javax.swing.JButton tbnLimparMed;
    private javax.swing.JButton tbnSalvarMed;
    private javax.swing.JTextField txtIDFazenda;
    private javax.swing.JTextField txtIDMed;
    private javax.swing.JTextField txtNomeMed;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtQuantidadeMed;
    private javax.swing.JTextField txtTipoMed;
    // End of variables declaration//GEN-END:variables
}
