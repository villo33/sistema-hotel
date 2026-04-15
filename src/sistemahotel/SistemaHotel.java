package sistemahotel;

public class SistemaHotel {

    public static void main(String[] args) {

        HabitacionDAO dao = new HabitacionDAO();

        Habitacion h = new Habitacion("300", "Suite", 200000, "Ocupada");
        h.setId(1);

        dao.actualizar(h);

        dao.listarHabitaciones();

        dao.eliminar(1);

        dao.listarHabitaciones();
    }
}