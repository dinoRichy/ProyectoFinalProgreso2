package SistemaConsumoElectrico.Modulo;

public class UsuarioEmpresa extends Usuario {

    private String ruc;
    private String actividadEconomica;

    // Tarifa simulada para empresas
    private static final double TARIFA_EMPRESA = 0.15;

    public UsuarioEmpresa(int id,
                          String nombre,
                          Sector sector,
                          String ruc,
                          String actividadEconomica) {

        super(id, nombre, sector);

        this.ruc = ruc;
        this.actividadEconomica = actividadEconomica;
    }

    public String getRuc() {
        return ruc;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    @Override
    public double obtenerTarifa() {
        return TARIFA_EMPRESA;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("\n===== EMPRESA =====");
        System.out.println("ID: " + id);
        System.out.println("Nombre Empresa: " + nombre);
        System.out.println("RUC: " + ruc);
        System.out.println("Actividad: " + actividadEconomica);
        System.out.println("Sector: " + sector);
        System.out.println("Tarifa: $" + TARIFA_EMPRESA + " por kWh");
        System.out.println("Dispositivos registrados: " + dispositivos.size());
    }
}

