package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_escolar";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Erro de conexão com o banco: " + e.getMessage());
            return null;
        }
    }
}
