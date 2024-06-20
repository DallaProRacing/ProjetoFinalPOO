package Controller;

import static Controller.DatabaseConnection.GetConnection;
import Model.Fazenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ADDFazendaController {

    private final String url = "jdbc:mysql://localhost:3306/ControleMedicamentos"; 
    private final String user = "root"; 
    private final String password = "02638862045";

    // Método para conectar ao banco de dados
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Método para adicionar uma nova fazenda ao banco de dados
    public boolean salvarFazenda(Fazenda fazenda) {
        try (Connection conn = connect()) {
            String query = "INSERT INTO fazenda (NomeFazenda, NomeProdutor, CPF, Endereco) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fazenda.getNomeFazenda());
            pstmt.setString(2, fazenda.getNomeProdutor());
            pstmt.setString(3, fazenda.getCpf());
            pstmt.setString(4, fazenda.getEndereco());
            
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para pesquisar fazendas com base em um campo e valor específicos
    public List<Fazenda> pesquisarFazendas(String campo, String valor) {
        List<Fazenda> fazendas = new ArrayList<>();
        String query = "SELECT * FROM fazenda WHERE " + campo + " LIKE ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + valor + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Fazenda fazenda = new Fazenda();
                    fazenda.setIdFazenda(rs.getInt("idFazenda"));
                    fazenda.setNomeFazenda(rs.getString("NomeFazenda"));
                    fazenda.setNomeProdutor(rs.getString("NomeProdutor"));
                    fazenda.setCpf(rs.getString("CPF"));
                    fazenda.setEndereco(rs.getString("Endereco"));
                    fazendas.add(fazenda);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fazendas;
    }
    
    // Método para atualizar uma pessoa existente no banco.
    public boolean alterarFazenda(Fazenda fazenda) {
    // Query SQL para atualização.
    String query = "UPDATE Fazenda SET NomeProdutor = ?, CPF = ?, Endereco = ? WHERE NomeFazenda = ?";
    
    try (
        // Estabelece uma conexão com o banco.
        Connection conn = GetConnection();
        // Cria um PreparedStatement para executar a query.
        PreparedStatement stmt = conn.prepareStatement(query)
    ) {
        // Atribui os novos valores da fazenda para a query.
        stmt.setString(1, fazenda.getNomeProdutor());
        stmt.setString(2, fazenda.getCpf());
        stmt.setString(3, fazenda.getEndereco());
        stmt.setString(4, fazenda.getNomeFazenda());
        
        // Executa a query.
        int rowsUpdated = stmt.executeUpdate(); // rowsUpdated contém o número de linhas afetadas
        
        // Verifica se a atualização foi bem-sucedida (pelo menos uma linha atualizada).
        return rowsUpdated > 0;
        
    } catch (SQLException e) {
        // Lança uma exceção em caso de erro.
        throw new RuntimeException("Erro ao tentar alterar a fazenda: " + e.getMessage(), e);
    }
}




}
