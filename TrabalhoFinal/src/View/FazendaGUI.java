package View;
import dao.FazendaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.ModelTable;
import Model.Fazenda;
import Model.Usuario;
import dao.UsuarioDAO;

public class FazendaGUI extends javax.swing.JFrame {

    private Fazenda objFazenda;
    private FazendaDAO objDAO;
    private boolean buscarFazenda = false;
    private UsuarioDAO objDAO2;
    private boolean buscar;
  
    public FazendaGUI() {
        initComponents();
        setSize(1200,600);
        this.setLocationRelativeTo(null);       
        this.setResizable(false);        
        carregarTable(null);
        carregarTableUsuario(null);
    }

    public void carregarTableUsuario(Usuario objUsuario) {

        objDAO2 = new UsuarioDAO();
        ArrayList dados = new ArrayList();
        if (buscar) {
            dados = objDAO2.buscar(objUsuario);
        } else {
            objUsuario = new Usuario();
            dados = objDAO2.listarTodos();
        }
        String[] colunas = objUsuario.getColunas();

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
    
    public void selectRegistryTableUsuario() {

        txtIDUsuario.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 0).toString());

        
    }
    
    public void carregarTable(Fazenda objFazenda) {

        objDAO = new FazendaDAO();
        ArrayList dados = new ArrayList();
        if (buscarFazenda) {
            dados = objDAO.buscarFazenda(objFazenda);
        } else {
            objFazenda = new Fazenda();
            dados = objDAO.listarTodosFazenda();
        }
        String[] colunas = objFazenda.getColunas();

        ModelTable modelo = new ModelTable(dados, colunas);

        tbListagemFazenda.setModel(modelo);
        tbListagemFazenda.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbListagemFazenda.getColumnModel().getColumn(0).setResizable(false);
        tbListagemFazenda.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbListagemFazenda.getColumnModel().getColumn(1).setResizable(false);
        tbListagemFazenda.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbListagemFazenda.getColumnModel().getColumn(2).setResizable(false);
        tbListagemFazenda.getTableHeader().setReorderingAllowed(false);
        
    }
    
    public void selectRegistryTable() {

        txtIDFazenda.setText(tbListagemFazenda.getValueAt(tbListagemFazenda.getSelectedRow(), 0).toString());

        //Object objNome = tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 1);
        txtNomeFazenda.setText(tbListagemFazenda.getValueAt(tbListagemFazenda.getSelectedRow(), 1).toString());
        txtEnderecoFazenda.setText(tbListagemFazenda.getValueAt(tbListagemFazenda.getSelectedRow(), 2).toString());
        txtPrincRacaAnimais.setText(tbListagemFazenda.getValueAt(tbListagemFazenda.getSelectedRow(), 3).toString());
        txtQuantAnimais.setText(tbListagemFazenda.getValueAt(tbListagemFazenda.getSelectedRow(), 4).toString());
        txtIDUsuario.setText(tbListagemFazenda.getValueAt(tbListagemFazenda.getSelectedRow(), 5).toString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtIDFazenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeFazenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEnderecoFazenda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrincRacaAnimais = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuantAnimais = new javax.swing.JTextField();
        tbnSalvarFazenda = new javax.swing.JButton();
        tbnLimparFazenda = new javax.swing.JButton();
        btnDeletarFazenda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListagemFazenda = new javax.swing.JTable();
        btnBuscarFazenda = new javax.swing.JButton();
        tbnExitFazenda = new javax.swing.JButton();
        tbnExit1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDUsuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbListagemUsuario = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("ID");

        txtIDFazenda.setEditable(false);

        jLabel2.setText("Nome da fazenda");

        txtNomeFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFazendaActionPerformed(evt);
            }
        });

        jLabel3.setText("Endereço da fazenda");

        txtEnderecoFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoFazendaActionPerformed(evt);
            }
        });

        jLabel5.setText("Raça de animais da fazenda");

        jLabel4.setText("Quantidade de animais");

        tbnSalvarFazenda.setText("Salvar");
        tbnSalvarFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSalvarFazendaActionPerformed(evt);
            }
        });

        tbnLimparFazenda.setText("Limpar");
        tbnLimparFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLimparFazendaActionPerformed(evt);
            }
        });

        btnDeletarFazenda.setText("Deletar");
        btnDeletarFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarFazendaActionPerformed(evt);
            }
        });

        tbListagemFazenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IDFazenda", "Nome Fazenda", "Endereço ", "Raça de animais", "Quantidade de animais", "ID Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        tbListagemFazenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListagemFazendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListagemFazenda);

        btnBuscarFazenda.setText("Buscar");
        btnBuscarFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFazendaActionPerformed(evt);
            }
        });

        tbnExitFazenda.setText("Sair");
        tbnExitFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExitFazendaActionPerformed(evt);
            }
        });

        tbnExit1.setText("Testar Conexão");
        tbnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExit1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FAZENDA");

        jLabel7.setText("Codigo do Usuário");

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Selecione o seu Usuário na Tabela Usuários");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tabela Usuários");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(217, 217, 217))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(txtIDFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(tbnSalvarFazenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tbnLimparFazenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeletarFazenda)))
                                .addGap(217, 217, 217)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtQuantAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(294, 294, 294))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNomeFazenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addComponent(txtEnderecoFazenda, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrincRacaAnimais, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBuscarFazenda)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tbnExitFazenda)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tbnExit1))))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addComponent(txtIDFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnderecoFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrincRacaAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbnLimparFazenda)
                                    .addComponent(tbnSalvarFazenda)
                                    .addComponent(btnDeletarFazenda)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnExitFazenda)
                            .addComponent(btnBuscarFazenda)
                            .addComponent(tbnExit1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFazendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFazendaActionPerformed

    private void txtEnderecoFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoFazendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoFazendaActionPerformed

    private void tbnSalvarFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSalvarFazendaActionPerformed

        objFazenda = new Fazenda();
        objFazenda.setIdFazenda(txtIDFazenda.getText());
        objFazenda.setNomeFazenda(txtNomeFazenda.getText());
        objFazenda.setEnderecoFazenda(txtEnderecoFazenda.getText());
        objFazenda.setPrincRacaAnimal(txtPrincRacaAnimais.getText());
        objFazenda.setQuantAnimais(txtQuantAnimais.getText());
        objFazenda.setIDUsuario(txtIDUsuario.getText());

        if ((txtNomeFazenda.getText().isEmpty()) || (txtEnderecoFazenda.getText().isEmpty()) || (txtPrincRacaAnimais.getText().isEmpty()) || (txtQuantAnimais.getText().isEmpty())|| (txtIDUsuario.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new FazendaDAO();
            objDAO.salvarFazenda(objFazenda);
            JOptionPane.showMessageDialog(null, "Fazenda " + txtNomeFazenda.getText() + " inserido com sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_tbnSalvarFazendaActionPerformed

    private void tbnLimparFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLimparFazendaActionPerformed
        setClear();
        carregarTable(null);
    }//GEN-LAST:event_tbnLimparFazendaActionPerformed

    private void btnDeletarFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarFazendaActionPerformed
        objFazenda.setIdFazenda(txtIDFazenda.getText());

        if ((txtIDFazenda.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new FazendaDAO();
            objDAO.deletarFazenda(objFazenda);
            JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso! ");
        }

        carregarTable(null);

        setClear();
    }//GEN-LAST:event_btnDeletarFazendaActionPerformed

    private void tbListagemFazendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemFazendaMouseClicked
        // TODO add your handling code here:
        selectRegistryTable();
    }//GEN-LAST:event_tbListagemFazendaMouseClicked

    private void btnBuscarFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFazendaActionPerformed
        objFazenda = new Fazenda();
        objFazenda.setNomeFazenda(txtNomeFazenda.getText());
        objFazenda.setEnderecoFazenda(txtEnderecoFazenda.getText());

        if ((!txtNomeFazenda.getText().isEmpty()) || (!txtEnderecoFazenda.getText().isEmpty())) {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new FazendaDAO();
            buscarFazenda = true;
            carregarTable(objFazenda);
        }else{
            buscarFazenda = false;
            carregarTable(null);
        }

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_btnBuscarFazendaActionPerformed

    public void setClear() {
        txtIDFazenda.setText(null);
        txtNomeFazenda.setText(null);
        txtEnderecoFazenda.setText(null);
        txtPrincRacaAnimais.setText(null);
        txtQuantAnimais.setText(null);
        txtIDUsuario.setText(null);
    }
    
    private void tbnExitFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExitFazendaActionPerformed
        dispose();    
        
        
    }//GEN-LAST:event_tbnExitFazendaActionPerformed

    private void tbnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExit1ActionPerformed
        try {
            FazendaDAO.testarConexaoFazenda();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_tbnExit1ActionPerformed

    private void tbListagemUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemUsuarioMouseClicked
        // TODO add your handling code here:
        selectRegistryTableUsuario();
    }//GEN-LAST:event_tbListagemUsuarioMouseClicked

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
            java.util.logging.Logger.getLogger(FazendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FazendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FazendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FazendaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FazendaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFazenda;
    private javax.swing.JButton btnDeletarFazenda;
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
    private javax.swing.JTable tbListagemFazenda;
    private javax.swing.JTable tbListagemUsuario;
    private javax.swing.JButton tbnExit1;
    private javax.swing.JButton tbnExitFazenda;
    private javax.swing.JButton tbnLimparFazenda;
    private javax.swing.JButton tbnSalvarFazenda;
    private javax.swing.JTextField txtEnderecoFazenda;
    private javax.swing.JTextField txtIDFazenda;
    private javax.swing.JTextField txtIDUsuario;
    private javax.swing.JTextField txtNomeFazenda;
    private javax.swing.JTextField txtPrincRacaAnimais;
    private javax.swing.JTextField txtQuantAnimais;
    // End of variables declaration//GEN-END:variables
}
