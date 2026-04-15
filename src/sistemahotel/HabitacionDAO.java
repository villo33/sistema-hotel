package sistemahotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class HabitacionDAO {

    public void insertar(Habitacion h) {

        Connection con = Conexion.conectar();

        String sql = "INSERT INTO habitaciones (numero, tipo, precio, estado) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, h.getNumero());
            ps.setString(2, h.getTipo());
            ps.setDouble(3, h.getPrecio());
            ps.setString(4, h.getEstado());

            ps.executeUpdate();

            System.out.println("Habitacion insertada");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void listarHabitaciones() {

        Connection con = Conexion.conectar();

        String sql = "SELECT * FROM habitaciones";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("numero") + " - " +
                    rs.getString("tipo") + " - " +
                    rs.getDouble("precio") + " - " +
                    rs.getString("estado")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public void actualizar(Habitacion h) {

        Connection con = Conexion.conectar();

        String sql = "UPDATE habitaciones SET numero=?, tipo=?, precio=?, estado=? WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, h.getNumero());
            ps.setString(2, h.getTipo());
            ps.setDouble(3, h.getPrecio());
            ps.setString(4, h.getEstado());
            ps.setInt(5, h.getId());

            ps.executeUpdate();

            System.out.println("Habitacion actualizada");

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    public void eliminar(int id) {

    Connection con = Conexion.conectar();

    String sql = "DELETE FROM habitaciones WHERE id=?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();

        System.out.println("Habitacion eliminada");

    } catch (SQLException e) {
        System.out.println("Error al eliminar: " + e.getMessage());
    }
}
}