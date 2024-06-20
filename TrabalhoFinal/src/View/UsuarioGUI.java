package View;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.ModelTable;
import Model.Usuario;


public class UsuarioGUI extends javax.swing.JFrame {

    private Usuario objUsuario;
    private UsuarioDAO objDAO;
    private boolean buscar = false;

    public UsuarioGUI() {

        initComponents();

       setSize(1200,600);
        this.setLocationRelativeTo(null);       
        this.setResizable(false);        
        carregarTable(null);
    }

    public void carregarTable(Usuario objUsuario) {

        objDAO = new UsuarioDAO();
        ArrayList dados = new ArrayList();
        if (buscar) {
            dados = objDAO.buscar(objUsuario);
        } else {
            objUsuario = new Usuario();
            dados = objDAO.listarTodos();
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

    
    public void selectRegistryTable() {

        txtID.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 0).toString());

        //Object objNome = tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 1);
        txtNome.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 1).toString());
        txtCPF.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 2).toString());
        txtEmail.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 3).toString());
        txtTelefone.setText(tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 4).toString());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tbnLimpar = new javax.swing.JButton();
        tbnSalvar = new javax.swing.JButton();
        tbnExit = new javax.swing.JButton();
        tbnExit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListagemUsuario = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE USUÁRIOS");

        jLabel2.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF");

        jLabel4.setText("Telefone");

        jLabel5.setText("Email");

        tbnLimpar.setText("Limpar");
        tbnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLimparActionPerformed(evt);
            }
        });

        tbnSalvar.setText("Salvar");
        tbnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSalvarActionPerformed(evt);
            }
        });

        tbnExit.setText("Sair");
        tbnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExitActionPerformed(evt);
            }
        });

        tbnExit1.setText("Testar Conexão");
        tbnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExit1ActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tbListagemUsuario);

        txtID.setEditable(false);

        jLabel6.setText("ID");

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tbnSalvar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tbnLimpar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDeletar))
                                .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbnExit1)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel1)
                .addGap(0, 374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnExit)
                            .addComponent(btnBuscar)
                            .addComponent(tbnExit1))
                        .addGap(241, 241, 241))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbnLimpar)
                            .addComponent(tbnSalvar)
                            .addComponent(btnDeletar))
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void tbnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSalvarActionPerformed

        objUsuario = new Usuario();
        objUsuario.setId(txtID.getText());
        objUsuario.setNome(txtNome.getText());
        objUsuario.setCpf(txtCPF.getText());
        objUsuario.setEmail(txtEmail.getText());
        objUsuario.setTelefone(txtTelefone.getText());

       
        if ((txtNome.getText().isEmpty()) || (txtCPF.getText().isEmpty()) || (txtEmail.getText().isEmpty()) || (txtTelefone.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new UsuarioDAO();
            objDAO.salvar(objUsuario);
            JOptionPane.showMessageDialog(null, "Usuário " + txtNome.getText() + " inserido com sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_tbnSalvarActionPerformed

    private void tbnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLimparActionPerformed
        setClear();
        carregarTable(null);
    }//GEN-LAST:event_tbnLimparActionPerformed

    private void tbnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExitActionPerformed
        dispose();      
        
        
    }//GEN-LAST:event_tbnExitActionPerformed

    private void tbnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExit1ActionPerformed
        try {
            UsuarioDAO.testarConexao();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_tbnExit1ActionPerformed

    private void tbListagemUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemUsuarioMouseClicked
        // TODO add your handling code here:
        selectRegistryTable();
    }//GEN-LAST:event_tbListagemUsuarioMouseClicked

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        objUsuario.setId(txtID.getText());

        
        if ((txtID.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new UsuarioDAO();
            objDAO.deletar(objUsuario);
            JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso! ");
        }

        carregarTable(null);

     
        setClear();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        objUsuario = new Usuario();
        objUsuario.setNome(txtNome.getText());
        objUsuario.setCpf(txtCPF.getText());

        
        if ((!txtNome.getText().isEmpty()) || (!txtCPF.getText().isEmpty())) {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new UsuarioDAO();
            buscar = true;
            carregarTable(objUsuario);
        }else{
            buscar = false;
            carregarTable(null);
        }

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void setClear() {
        txtID.setText(null);
        txtNome.setText(null);
        txtCPF.setText(null);
        txtEmail.setText(null);
        txtTelefone.setText(null);
    }

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
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListagemUsuario;
    private javax.swing.JButton tbnExit;
    private javax.swing.JButton tbnExit1;
    private javax.swing.JButton tbnLimpar;
    private javax.swing.JButton tbnSalvar;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
