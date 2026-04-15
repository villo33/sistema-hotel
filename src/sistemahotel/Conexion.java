package sistemahotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/sistemahotel";
    private static final String USER = "root";
    private static final String PASSWORD = "1003645363";

    public static Connection conectar() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conectado a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }

        return con;
    }
}