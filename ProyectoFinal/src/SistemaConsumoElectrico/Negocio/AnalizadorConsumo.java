package SistemaConsumoElectrico.Negocio;
import SistemaConsumoElectrico.Modulo.Dispositivo;
import SistemaConsumoElectrico.Modulo.Usuario;

public class AnalizadorConsumo {

    private CalculadoraConsumo calculadora;

    public AnalizadorConsumo() {

        calculadora = new CalculadoraConsumo();
    }

    // Encontrar el dispositivo que más consume
    public Dispositivo obtenerMayorConsumidor(Usuario usuario) {

        Dispositivo mayor = null;
        double mayorConsumo = 0;

        for (Dispositivo d : usuario.getDispositivos()) {

            if (d.calcularConsumoMensual() > mayorConsumo) {

                mayorConsumo = d.calcularConsumoMensual();
                mayor = d;
            }
        }

        return mayor;
    }

    // Determinar nivel de consumo
    public String clasificarConsumo(Usuario usuario) {

        double consumo =
                calculadora.calcularConsumoMensual(usuario);

        double limite =
                usuario.getSector().getLimiteConsumo();

        if (consumo < limite * 0.50) {

            return "BAJO";
        }

        if (consumo < limite) {

            return "NORMAL";
        }

        if (consumo < limite * 1.30) {

            return "ALTO";
        }

        return "CRITICO";
    }

    // Verificar si supera el límite recomendado
    public boolean consumoExcesivo(Usuario usuario) {

        double consumo =
                calculadora.calcularConsumoMensual(usuario);

        return consumo >
                usuario.getSector().getLimiteConsumo();
    }

    // Mostrar análisis completo
    public void mostrarAnalisis(Usuario usuario) {

        System.out.println("\n===== ANALISIS ENERGETICO =====");

        double consumo =
                calculadora.calcularConsumoMensual(usuario);

        double limite =
                usuario.getSector().getLimiteConsumo();

        System.out.printf(
                "Consumo mensual: %.2f kWh%n",
                consumo);

        System.out.printf(
                "Limite recomendado para %s: %.2f kWh%n",
                usuario.getSector(),
                limite);

        System.out.println(
                "Clasificacion: " +
                        clasificarConsumo(usuario));

        if (consumoExcesivo(usuario)) {

            System.out.println(
                    "ALERTA: El consumo supera el limite recomendado.");
        }
        else {

            System.out.println(
                    "El consumo se encuentra dentro de parametros aceptables.");
        }

        Dispositivo mayor =
                obtenerMayorConsumidor(usuario);

        if (mayor != null) {

            System.out.println(
                    "\nDispositivo de mayor consumo:");

            System.out.println(
                    mayor.getNombre());

            System.out.printf(
                    "Consumo mensual: %.2f kWh%n",
                    mayor.calcularConsumoMensual());
        }
    }
}

