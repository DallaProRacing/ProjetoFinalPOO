package View;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Connection.DataBaseConnection;
import Model.Estagiario;
import Model.Funcionario;
import java.awt.Color;

/**
 *
 * @author henri
 */
public class MainForm extends javax.swing.JFrame {
    private JTable table;
    
    private void LoadDataGridFunc(){
        DataBaseConnection dbConn = new DataBaseConnection();
        dbConn.selectFun(jTable1);
         jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) { // Evitar eventos duplicados
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        jTextCod.setText(jTable1.getValueAt(selectedRow, 0).toString());
                        jTextNome.setText(jTable1.getValueAt(selectedRow, 1).toString());
                        jTextIdade.setText(jTable1.getValueAt(selectedRow, 2).toString());
                        jTextEndereco.setText(jTable1.getValueAt(selectedRow, 3).toString());
                        jTextSexo.setText(jTable1.getValueAt(selectedRow, 4).toString());
                        jTextAltura.setText(jTable1.getValueAt(selectedRow, 5).toString());
                        jTextTelefone.setText(jTable1.getValueAt(selectedRow, 6).toString());
                        jTextRegistro.setText(jTable1.getValueAt(selectedRow, 7).toString());
                        jTextSalario.setText(jTable1.getValueAt(selectedRow, 8).toString());
                    }
                }
            }
        });
    }
    
    private void LoadDataGridEstag(){
        DataBaseConnection dbConn = new DataBaseConnection();
        dbConn.selectEstag(jTable2);
         jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) { // Evitar eventos duplicados
                    int selectedRow = jTable2.getSelectedRow();
                    if (selectedRow != -1) {
                        jTextCod.setText(jTable2.getValueAt(selectedRow, 0).toString());
                        jTextNome.setText(jTable2.getValueAt(selectedRow, 1).toString());
                        jTextIdade.setText(jTable2.getValueAt(selectedRow, 2).toString());
                        jTextEndereco.setText(jTable2.getValueAt(selectedRow, 3).toString());
                        jTextSexo.setText(jTable2.getValueAt(selectedRow, 4).toString());
                        jTextAltura.setText(jTable2.getValueAt(selectedRow, 5).toString());
                        jTextTelefone.setText(jTable2.getValueAt(selectedRow, 6).toString());
                        jTextRegistro.setText(jTable2.getValueAt(selectedRow, 7).toString());
                        jTextSalario.setText(jTable2.getValueAt(selectedRow, 8).toString());
                        jTextBolsa.setText(jTable2.getValueAt(selectedRow, 9).toString());
                        jTextHorasServico.setText(jTable2.getValueAt(selectedRow, 10).toString());
                    }
                }
            }
        });
    }
    
    private void limpaCampos(){
        jTextCod.setText("");
        jTextNome.setText("");
        jTextIdade.setText("");
        jTextEndereco.setText("");
        jTextSexo.setText("");
        jTextAltura.setText("");
        jTextTelefone.setText("");
        jTextRegistro.setText("");
        jTextSalario.setText("");
        jTextBolsa.setText("");
        jTextHorasServico.setText("");
    }
    
    private boolean verificaCampos() {
        if (jTextBolsa.isVisible()){
        JTextField[] fields = {jTextNome, jTextIdade, jTextEndereco, jTextSexo, jTextAltura, jTextTelefone, jTextRegistro, jTextSalario, jTextBolsa, jTextHorasServico};
        
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
        } else{
          JTextField[] fields = {jTextNome, jTextIdade, jTextEndereco, jTextSexo, jTextAltura, jTextTelefone, jTextRegistro, jTextSalario};
            for (JTextField field : fields) {
                if (field.getText().trim().isEmpty()) {
                    return false;
                }
            }
            return true;
        }  
    }
    
    private void excluirFunc(){
        int Id = Integer.parseInt(jTextCod.getText());
        try{
            DataBaseConnection dbConn = new DataBaseConnection();
            dbConn.excluirFunc(Id);
            LoadDataGridFunc();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
             JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação." + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void excluirEstag(){
        int Id = Integer.parseInt(jTextCod.getText());
        try{
            DataBaseConnection dbConn = new DataBaseConnection();
            dbConn.excluirEstag(Id);
            LoadDataGridEstag();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
             JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação." + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void updateFunc(){
        if (verificaCampos()){
        int Id = Integer.parseInt(jTextCod.getText());
        String nome = jTextNome.getText();
        int idade = Integer.parseInt(jTextIdade.getText());
        String endereco = jTextEndereco.getText();
        String sexo = jTextSexo.getText();
        double altura = Double.parseDouble(jTextAltura.getText());
        String telefone = jTextTelefone.getText();
        String registro = jTextRegistro.getText();
        double salario = Double.parseDouble(jTextSalario.getText());

        Funcionario func = new Funcionario(registro, salario, nome, idade, endereco, sexo, altura, telefone);
        
        try{
            DataBaseConnection dbConn = new DataBaseConnection();
            dbConn.updateFunc(func, Id);
            LoadDataGridFunc();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
             JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação." + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }
    }
    
    private void updateEstag(){
        if (verificaCampos()){
        int Id = Integer.parseInt(jTextCod.getText());
        String nome = jTextNome.getText();
        int idade = Integer.parseInt(jTextIdade.getText());
        String endereco = jTextEndereco.getText();
        String sexo = jTextSexo.getText();
        double altura = Double.parseDouble(jTextAltura.getText());
        String telefone = jTextTelefone.getText();
        String registro = jTextRegistro.getText();
        double salario = Double.parseDouble(jTextSalario.getText());
        double bolsa = Double.parseDouble(jTextBolsa.getText());
        int horasServico = Integer.parseInt(jTextHorasServico.getText());

        Estagiario estag = new Estagiario(bolsa, horasServico, registro, salario, nome, idade, endereco, sexo, altura, telefone);
        
        try{
            DataBaseConnection dbConn = new DataBaseConnection();
            dbConn.updateEstag(estag, Id);
            LoadDataGridEstag();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
             JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação." + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }        
    }
    
    private void ativaFunc(){
        jButtonFunc.setBackground(new Color(210, 210, 210));
        btnSair.setBackground(new Color(242, 242, 242));
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jTextBolsa.setVisible(false);
        jTextHorasServico.setVisible(false);
        jTable2.setVisible(false);
        jScrollPane2.setVisible(false);
        jTable1.setVisible(true);
        jScrollPane1.setVisible(true);
        
    }
    
    private void ativaEstag(){
        LoadDataGridEstag();
        btnEstag.setBackground(new Color(210, 210, 210));
        jButtonFunc.setBackground(new Color(242, 242, 242));
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jTextBolsa.setVisible(true);
        jTextHorasServico.setVisible(true);
        jScrollPane1.setVisible(false);
        jTable1.setVisible(false);
        jTable2.setVisible(true);
        jScrollPane2.setVisible(true);
    }
    
    private void incluirFunc(){
        
        if (verificaCampos()){
        String nome = jTextNome.getText();
        int idade = Integer.parseInt(jTextIdade.getText());
        String endereco = jTextEndereco.getText();
        String sexo = jTextSexo.getText();
        double altura = Double.parseDouble(jTextAltura.getText());
        String telefone = jTextTelefone.getText();
        String registro = jTextRegistro.getText();
        double salario = Double.parseDouble(jTextSalario.getText());

        Funcionario func = new Funcionario(registro, salario, nome, idade, endereco, sexo, altura, telefone);
        
            
        try{
            DataBaseConnection dbConn = new DataBaseConnection();
            dbConn.createFunc(func);
            LoadDataGridFunc();
            JOptionPane.showMessageDialog(null, "Inclusão realizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
             JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação." + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }
    }
    
    private void incluirEstag(){
        if (verificaCampos()){
        String nome = jTextNome.getText();
        int idade = Integer.parseInt(jTextIdade.getText());
        String endereco = jTextEndereco.getText();
        String sexo = jTextSexo.getText();
        double altura = Double.parseDouble(jTextAltura.getText());
        String telefone = jTextTelefone.getText();
        String registro = jTextRegistro.getText();
        double salario = Double.parseDouble(jTextSalario.getText());
        double bolsa = Double.parseDouble(jTextBolsa.getText());
        int horasServico = Integer.parseInt(jTextHorasServico.getText());

        Estagiario estag = new Estagiario(bolsa, horasServico, registro, salario, nome, idade, endereco, sexo, altura, telefone);
        
            
        try{
            DataBaseConnection dbConn = new DataBaseConnection();
            dbConn.createEstag(estag);
            LoadDataGridEstag();
            JOptionPane.showMessageDialog(null, "Inclusão realizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
             JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a operação." + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }
    }
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        ativaFunc();
        LoadDataGridFunc();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextIdade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextSexo = new javax.swing.JTextField();
        jTextAltura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextTelefone = new javax.swing.JTextField();
        jTextRegistro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextSalario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextCod = new javax.swing.JTextField();
        jButtonIncluir = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jButtonFunc = new javax.swing.JButton();
        jTextBolsa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextHorasServico = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnEstag = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMainPanel.setPreferredSize(new java.awt.Dimension(1360, 800));
        jMainPanel.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Idade", "Endereço", "Sexo", "Altura", "Telefone", "Registro", "Salario"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMainPanel.add(jScrollPane1);
        jScrollPane1.setBounds(384, 114, 600, 372);
        jMainPanel.add(jTextNome);
        jTextNome.setBounds(52, 192, 170, 22);

        jLabel1.setText("Nome");
        jMainPanel.add(jLabel1);
        jLabel1.setBounds(52, 170, 37, 16);
        jMainPanel.add(jTextIdade);
        jTextIdade.setBounds(271, 192, 31, 22);

        jLabel2.setText("Idade");
        jMainPanel.add(jLabel2);
        jLabel2.setBounds(271, 170, 40, 16);
        jMainPanel.add(jTextEndereco);
        jTextEndereco.setBounds(52, 246, 250, 22);

        jLabel3.setText("Endereço");
        jMainPanel.add(jLabel3);
        jLabel3.setBounds(52, 226, 60, 16);

        jLabel4.setText("Sexo");
        jMainPanel.add(jLabel4);
        jLabel4.setBounds(52, 280, 30, 16);
        jMainPanel.add(jTextSexo);
        jTextSexo.setBounds(52, 300, 70, 22);
        jMainPanel.add(jTextAltura);
        jTextAltura.setBounds(140, 300, 37, 22);

        jLabel5.setText("Altura");
        jMainPanel.add(jLabel5);
        jLabel5.setBounds(140, 280, 37, 16);

        jLabel6.setText("Telefone");
        jMainPanel.add(jLabel6);
        jLabel6.setBounds(189, 280, 60, 16);
        jMainPanel.add(jTextTelefone);
        jTextTelefone.setBounds(189, 300, 177, 22);
        jMainPanel.add(jTextRegistro);
        jTextRegistro.setBounds(52, 348, 119, 22);

        jLabel7.setText("Registro");
        jMainPanel.add(jLabel7);
        jLabel7.setBounds(52, 328, 60, 16);

        jLabel8.setText("Salário");
        jMainPanel.add(jLabel8);
        jLabel8.setBounds(189, 328, 50, 16);
        jMainPanel.add(jTextSalario);
        jTextSalario.setBounds(189, 348, 177, 22);

        jLabel9.setText("Cód");
        jMainPanel.add(jLabel9);
        jLabel9.setBounds(52, 114, 37, 16);

        jTextCod.setEnabled(false);
        jMainPanel.add(jTextCod);
        jTextCod.setBounds(52, 136, 72, 22);

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        jMainPanel.add(jButtonIncluir);
        jButtonIncluir.setBounds(290, 440, 80, 23);

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        jMainPanel.add(jButtonLimpar);
        jButtonLimpar.setBounds(20, 440, 80, 23);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jMainPanel.add(jButtonSalvar);
        jButtonSalvar.setBounds(200, 440, 80, 23);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jMainPanel.add(jButtonExcluir);
        jButtonExcluir.setBounds(110, 440, 80, 23);

        btnSair.setBackground(new java.awt.Color(242, 242, 242));
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSair.setBorderPainted(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jMainPanel.add(btnSair);
        btnSair.setBounds(914, 40, 70, 30);

        jButtonFunc.setBackground(new java.awt.Color(242, 242, 242));
        jButtonFunc.setText("Funcionário");
        jButtonFunc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonFunc.setBorderPainted(false);
        jButtonFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncActionPerformed(evt);
            }
        });
        jMainPanel.add(jButtonFunc);
        jButtonFunc.setBounds(55, 45, 124, 40);
        jMainPanel.add(jTextBolsa);
        jTextBolsa.setBounds(52, 396, 119, 22);

        jLabel10.setText("Bolsa");
        jMainPanel.add(jLabel10);
        jLabel10.setBounds(52, 376, 40, 16);
        jMainPanel.add(jTextHorasServico);
        jTextHorasServico.setBounds(189, 396, 177, 22);

        jLabel11.setText("Horas Serviço");
        jMainPanel.add(jLabel11);
        jLabel11.setBounds(189, 376, 100, 16);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Idade", "Endereço", "Sexo", "Altura", "Telefone", "Registro", "Salario", "Bolsa", "Horas Serviço"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jMainPanel.add(jScrollPane2);
        jScrollPane2.setBounds(380, 110, 610, 372);

        btnEstag.setBackground(new java.awt.Color(242, 242, 242));
        btnEstag.setText("Estagiário");
        btnEstag.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEstag.setBorderPainted(false);
        btnEstag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstagActionPerformed(evt);
            }
        });
        jMainPanel.add(btnEstag);
        btnEstag.setBounds(197, 45, 124, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        // TODO add your handling code here:
        if (jTextBolsa.isVisible()){
            incluirEstag();
        } else{
            incluirFunc();
        }        
        limpaCampos();
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
        limpaCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        updateFunc();
        limpaCampos();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        if (jTextBolsa.isVisible()){
            excluirEstag();
        } else{
            excluirFunc();
        }
        
        limpaCampos();
        
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
       
    }//GEN-LAST:event_btnSairActionPerformed

    private void jButtonFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncActionPerformed
        // TODO add your handling code here:
        ativaFunc();
    }//GEN-LAST:event_jButtonFuncActionPerformed

    private void btnEstagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstagActionPerformed
       ativaEstag();
    }//GEN-LAST:event_btnEstagActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstag;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFunc;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextAltura;
    private javax.swing.JTextField jTextBolsa;
    private javax.swing.JTextField jTextCod;
    private javax.swing.JTextField jTextEndereco;
    private javax.swing.JTextField jTextHorasServico;
    private javax.swing.JTextField jTextIdade;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextRegistro;
    private javax.swing.JTextField jTextSalario;
    private javax.swing.JTextField jTextSexo;
    private javax.swing.JTextField jTextTelefone;
    // End of variables declaration//GEN-END:variables
}
