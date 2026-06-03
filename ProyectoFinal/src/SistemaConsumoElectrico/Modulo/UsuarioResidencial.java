package SistemaConsumoElectrico.Modulo;

public class UsuarioResidencial extends Usuario {

    // Tarifa simulada para usuarios residenciales
    private static final double TARIFA_RESIDENCIAL = 0.10;

    public UsuarioResidencial(int id, String nombre, Sector sector) {
        super(id, nombre, sector);
    }

    @Override
    public double obtenerTarifa() {
        return TARIFA_RESIDENCIAL;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("\n===== USUARIO RESIDENCIAL =====");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Sector: " + sector);
        System.out.println("Tarifa: $" + TARIFA_RESIDENCIAL + " por kWh");
        System.out.println("Dispositivos registrados: " + dispositivos.size());
    }
}
