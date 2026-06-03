package SistemaConsumoElectrico.Modulo;

public class Dispositivo {
    private int id;
    private String nombre;
    private double potencia;
    private int cantidad;
    private double horasUsoDiarias;

    public Dispositivo(int id, String nombre, double potencia, int cantidad, double horasUsoDiarias) {

        this.id = id;
        this.nombre = nombre;
        this.potencia = potencia;
        this.cantidad = cantidad;
        this.horasUsoDiarias = horasUsoDiarias;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPotencia() {
        return potencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getHorasUsoDiarias() {
        return horasUsoDiarias;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setHorasUsoDiarias(double horasUsoDiarias) {
        this.horasUsoDiarias = horasUsoDiarias;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    // Consumo diario en kWh
    public double calcularConsumoDiario() {

        return (potencia * cantidad * horasUsoDiarias) / 1000;
    }

    // Consumo mensual en kWh
    public double calcularConsumoMensual() {

        return calcularConsumoDiario() * 30;
    }

    // Consumo anual en kWh
    public double calcularConsumoAnual() {

        return calcularConsumoMensual() * 12;
    }

    @Override
    public String toString() {

        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Potencia: " + potencia + " W" +
                " | Cantidad: " + cantidad +
                " | Horas/día: " + horasUsoDiarias +
                " | Consumo mensual: " +
                String.format("%.2f", calcularConsumoMensual()) +
                " kWh";
    }
}