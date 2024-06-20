package dao;

import Connection.ConnectionFactory;
import Model.Fazenda;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;




public class FazendaDAO {
    private Connection connection;
    Long IdFazenda;
    String NomeFazenda;
    String EnderecoFazenda;
    String PrincRacaAnimal;
    String QuantAnimais;
    String IDUsuario;
    
    public FazendaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvarFazenda(Fazenda objFazenda) {
        try {
            String sql;
            if (String.valueOf(objFazenda.getIdFazenda()).isEmpty()) {
                sql = "INSERT INTO Fazenda(NomeFazenda,EnderecoFazenda,PrincRacaAnimal,QuantAnimais,IDUsuario) VALUES(?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objFazenda.getNomeFazenda());
                stmt.setString(2, objFazenda.getEnderecoFazenda());
                stmt.setString(3, objFazenda.getPrincRacaAnimal());
                stmt.setString(4, objFazenda.getQuantAnimais());
                stmt.setString(5, objFazenda.getIDUsuario());
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE Fazenda SET NomeFazenda = ?, EnderecoFazenda = ?, PrincRacaAnimal = ?, QuantAnimais = ?, IDUsuario = ? WHERE Fazenda.IdFazenda = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                
                stmt.setString(1, objFazenda.getNomeFazenda());
                stmt.setString(2, objFazenda.getEnderecoFazenda());
                stmt.setString(3, objFazenda.getPrincRacaAnimal());
                stmt.setString(4, objFazenda.getQuantAnimais());
                stmt.setString(5, objFazenda.getIDUsuario());
                stmt.setString(6, objFazenda.getIdFazenda());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public ArrayList buscarFazenda(Fazenda objFazenda) {
        try {
            String sql = "";
            if (!objFazenda.getNomeFazenda().isEmpty()) {
                sql = "SELECT * FROM Fazenda WHERE NomeFazenda LIKE '%" + objFazenda.getNomeFazenda()+ "%' ";

            } else if (!objFazenda.getEnderecoFazenda().isEmpty()) {
                sql = "SELECT * FROM Fazenda WHERE EnderecoFazenda LIKE '%" + objFazenda.getEnderecoFazenda()+ "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("IdFazenda"),
                    rs.getString("NomeFazenda"),
                    rs.getString("EnderecoFazenda"),
                    rs.getString("PrincRacaAnimal"),
                    rs.getString("QuantAnimais"),
                    rs.getString("IDUsuario")
                        
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

    public void deletarFazenda(Fazenda objFazenda) {
        try {
            String sql;
            if (!String.valueOf(objFazenda. getIdFazenda()).isEmpty()) {
                sql = "DELETE FROM Fazenda WHERE Fazenda.IdFazenda = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objFazenda.getIdFazenda());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList listarTodosFazenda() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Fazenda");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("IdFazenda"),
                    rs.getString("Nomefazenda"),
                    rs.getString("EnderecoFazenda"),
                    rs.getString("PrincRacaAnimal"),
                    rs.getString("QuantAnimais"),
                    rs.getString("IDUsuario")
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

    public static void testarConexaoFazenda() throws SQLException {
        try (Connection objConnection = new ConnectionFactory().getConnection()) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ");
        }
    }
    
    
    
}
