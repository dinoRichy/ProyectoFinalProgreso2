package SistemaConsumoElectrico.Negocio;

import SistemaConsumoElectrico.Modulo.Dispositivo;
import SistemaConsumoElectrico.Modulo.Usuario;

public class CalculadoraConsumo {

    // Consumo diario total
    public double calcularConsumoDiario(Usuario usuario) {

        double total = 0;

        for (Dispositivo d : usuario.getDispositivos()) {

            total += d.calcularConsumoDiario();
        }

        return total;
    }

    // Consumo mensual total
    public double calcularConsumoMensual(Usuario usuario) {

        double total = 0;

        for (Dispositivo d : usuario.getDispositivos()) {

            total += d.calcularConsumoMensual();
        }

        return total;
    }

    // Consumo anual total
    public double calcularConsumoAnual(Usuario usuario) {

        double total = 0;

        for (Dispositivo d : usuario.getDispositivos()) {

            total += d.calcularConsumoAnual();
        }

        return total;
    }

    // Costo mensual
    public double calcularCostoMensual(Usuario usuario) {

        return calcularConsumoMensual(usuario)
                * usuario.obtenerTarifa();
    }

    // Costo anual
    public double calcularCostoAnual(Usuario usuario) {

        return calcularConsumoAnual(usuario)
                * usuario.obtenerTarifa();
    }

    // Mostrar resumen completo
    public void mostrarResumen(Usuario usuario) {

        System.out.println("\n===== RESUMEN ENERGÉTICO =====");

        System.out.printf(
                "Consumo diario: %.2f kWh%n",
                calcularConsumoDiario(usuario));

        System.out.printf(
                "Consumo mensual: %.2f kWh%n",
                calcularConsumoMensual(usuario));

        System.out.printf(
                "Consumo anual: %.2f kWh%n",
                calcularConsumoAnual(usuario));

        System.out.printf(
                "Costo mensual estimado: $%.2f%n",
                calcularCostoMensual(usuario));

        System.out.printf(
                "Costo anual estimado: $%.2f%n",
                calcularCostoAnual(usuario));
    }
}
