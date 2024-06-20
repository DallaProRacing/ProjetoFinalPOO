package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //Colocar o nome do banco de dados que você criou
    private static final String URL = "jdbc:mysql://localhost:3306/ControleMedicamentos";
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
}
