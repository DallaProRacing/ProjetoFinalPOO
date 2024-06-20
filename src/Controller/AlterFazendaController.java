package Controller;

import Model.Fazenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlterFazendaController {

    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USUARIO = "root";
    private static final String SENHA = "02638862045";

    public boolean alterarFazenda(Fazenda fazenda) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE fazenda SET nome_produtor = ?, cpf = ?, endereco = ? WHERE nome_fazenda = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fazenda.getNomeProdutor());
            pstmt.setString(2, fazenda.getCpf());
            pstmt.setString(3, fazenda.getEndereco());
            pstmt.setString(4, fazenda.getNomeFazenda());
            
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
