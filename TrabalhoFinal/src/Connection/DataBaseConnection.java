
package Connection;


import Model.Estagiario;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataBaseConnection {
    //Colocar o nome do banco de dados que você criou
    private static final String URL = "jdbc:mysql://localhost:3306/trabalhopoo";
    //Colocar o usuario que loga no MySQL Workbench
    private static final String USER = "root";
    //Colocar a senha que loga no MySQL Workbench
    private static final String PASSWORD = "02638862045";

    //Método que faz a conexão com o banco de dados
    public static Connection GetConnection() {
        try {
            //Classe importada para usar o banco, sempre será usado no JAVA
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void createFunc(Funcionario func) {
        // Query SQL para inserção.
        String query = "INSERT INTO Funcionario (nome, idade, endereco, sexo, altura, telefone, registro, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query
            PreparedStatement adapter = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            adapter.setString(1, func.getNome());
            adapter.setInt(2, func.getIdade());
            adapter.setString(3, func.getEndereco());
            adapter.setString(4, func.getSexo());
            adapter.setDouble(5, func.getAltura());
            adapter.setString(6, func.getTelefone());
            adapter.setString(7, func.getRegistro());
            adapter.setDouble(8, func.getSalario());
            // Executa a query.
            adapter.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }
    
    public void createEstag(Estagiario estag) {
        // Query SQL para inserção.
        String query = "INSERT INTO Estagiario (nome, idade, endereco, sexo, altura, telefone, registro, salario, bolsa, horas_servico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query
            PreparedStatement adapter = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            adapter.setString(1, estag.getNome());
            adapter.setInt(2, estag.getIdade());
            adapter.setString(3, estag.getEndereco());
            adapter.setString(4, estag.getSexo());
            adapter.setDouble(5, estag.getAltura());
            adapter.setString(6, estag.getTelefone());
            adapter.setString(7, estag.getRegistro());
            adapter.setDouble(8, estag.getSalario());
            adapter.setDouble(9, estag.getBolsa());
            adapter.setInt(10, estag.getIdade());
            // Executa a query.
            adapter.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }
    
    public void selectFun(JTable table){
        String query = "SELECT * FROM Funcionario";
        try (Connection conn = GetConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Limpar o JTable antes de preencher

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("endereco"),
                    rs.getString("sexo"),
                    rs.getDouble("altura"),
                    rs.getString("telefone"),
                    rs.getString("registro"),
                    rs.getDouble("salario")
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void selectEstag(JTable table){
        String query = "SELECT * FROM Estagiario";
        try (Connection conn = GetConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Limpar o JTable antes de preencher

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("endereco"),
                    rs.getString("sexo"),
                    rs.getDouble("altura"),
                    rs.getString("telefone"),
                    rs.getString("registro"),
                    rs.getDouble("salario"),
                    rs.getDouble("bolsa"),
                    rs.getInt("horas_servico")
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void excluirFunc(int Id){
        String query = "DELETE FROM Funcionario WHERE id = ?";
        try (Connection conn = GetConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirEstag(int Id){
        String query = "DELETE FROM Estagiario WHERE id = ?";
        try (Connection conn = GetConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        
    }
    
    public void updateFunc(Funcionario func, int Id){
        String query = "UPDATE Funcionario SET nome = ?, idade = ?, endereco = ?, sexo = ?, altura = ?, telefone = ?, salario = ? WHERE id = ?";
        try (Connection conn = GetConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, func.getNome());
            stmt.setInt(2, func.getIdade());
            stmt.setString(3, func.getEndereco());
            stmt.setString(4, func.getSexo());
            stmt.setDouble(5, func.getAltura());
            stmt.setString(6, func.getTelefone());
            stmt.setDouble(7, func.getSalario());
            stmt.setInt(8, Id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void updateEstag(Estagiario estag, int Id){
        String query = "UPDATE Funcionario SET nome = ?, idade = ?, endereco = ?, sexo = ?, altura = ?, telefone = ?, salario = ?, bolsa = ?, horas_servico = ? WHERE id = ?";
        try (Connection conn = GetConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, estag.getNome());
            stmt.setInt(2, estag.getIdade());
            stmt.setString(3, estag.getEndereco());
            stmt.setString(4, estag.getSexo());
            stmt.setDouble(5, estag.getAltura());
            stmt.setString(6, estag.getTelefone());
            stmt.setDouble(7, estag.getSalario());
            stmt.setDouble(8, estag.getBolsa());
            stmt.setInt(9, estag.getHorasServico());
            stmt.setInt(10, Id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void createEst(Estagiario estag) {
        // Query SQL para inserção.
        String query = "INSERT INTO Estagiario (nome, idade, endereco, sexo, altura, telefone, registro, salario, bolsa, horas_servico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement adapter = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            adapter.setString(1, estag.getNome());
            adapter.setInt(2, estag.getIdade());
            adapter.setString(3, estag.getEndereco());
            adapter.setString(4, estag.getSexo());
            adapter.setDouble(5, estag.getAltura());
            adapter.setString(6, estag.getTelefone());
            adapter.setString(7, estag.getRegistro());
            adapter.setDouble(8, estag.getSalario());
            adapter.setDouble(9, estag.getBolsa());
            adapter.setInt(10, estag.getHorasServico());
            // Executa a query.
            adapter.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }
}
