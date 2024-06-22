package dao;

import Connection.ConnectionFactory;
import Model.Medicamento;
import Model.Usuario;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class MedicamentoDAO {
    private Connection connection;
    Long IdMed;
    String NomeMed;
    String Tipo;
    String Quantidade;
    String Observacao;
    String IDFazenda;
    
    public MedicamentoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
        public void salvarMed(Medicamento objMedicamento) {
        try {
            String sql;
            if (String.valueOf(objMedicamento.getIdMed()).isEmpty()) {
                sql = "INSERT INTO Medicamento(NomeMed,Tipo,Quantidade,Observacao,IDFazenda) VALUES(?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objMedicamento.getNomeMed());
                stmt.setString(2, objMedicamento.getTipo());
                stmt.setString(3, objMedicamento.getQuantidade());
                stmt.setString(4, objMedicamento.getObservacao());
                stmt.setString(5, objMedicamento.getIDFazenda());
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE Medicamento SET NomeMed = ?, Tipo = ?, Quantidade = ?, Observacao = ?, IDFazenda = ? WHERE Medicamento.IdMed = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                
                stmt.setString(1, objMedicamento.getNomeMed());
                stmt.setString(2, objMedicamento.getTipo());
                stmt.setString(3, objMedicamento.getQuantidade());
                stmt.setString(4, objMedicamento.getObservacao());
                stmt.setString(5, objMedicamento.getIDFazenda());
                stmt.setString(6, objMedicamento.getIdMed());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
        
        public ArrayList buscarMed(Medicamento objMedicamento) {
        try {
            String sql = "";
            if (!objMedicamento.getNomeMed().isEmpty()) {
                sql = "SELECT * FROM Medicamento WHERE NomeMed LIKE '%" + objMedicamento.getNomeMed()+ "%' ";

            } else if (!objMedicamento.getTipo().isEmpty()) {
                sql = "SELECT * FROM Medicamento WHERE Tipo LIKE '%" + objMedicamento.getTipo()+ "%' ";
            }
            else if (!objMedicamento.getIDFazenda().isEmpty()) {
                sql = "SELECT * FROM Medicamento WHERE IDFazenda LIKE '%" + objMedicamento.getIDFazenda()+ "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("IdMed"),
                    rs.getString("NomeMed"),
                    rs.getString("Tipo"),
                    rs.getString("Quantidade"),
                    rs.getString("Observacao"),
                    rs.getString("IDFazenda")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }

    }
        
        public void deletarMed(Medicamento objMedicamento) {
    try {
        if (objMedicamento.getIdMed() != null) {
            String sql = "DELETE FROM Medicamento WHERE IdMed = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, objMedicamento.getIdMed());
                stmt.execute();
                stmt.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID do Medicamento é nulo. Não é possível deletar.");
        }
    } catch (SQLException u) {
        throw new RuntimeException(u);
    }
}
        
        public ArrayList listarTodosMed() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Medicamento");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("IdMed"),
                    rs.getString("NomeMed"),
                    rs.getString("Tipo"),
                    rs.getString("Quantidade"),
                    rs.getString("Observacao"),
                    rs.getString("IDFazenda")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }
    }

    public static void testarConexaoMed() throws SQLException {
        try (Connection objConnection = new ConnectionFactory().getConnection()) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ");
        }
    }

}
