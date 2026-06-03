package SistemaConsumoElectrico.Negocio;

import SistemaConsumoElectrico.Modulo.Dispositivo;
import SistemaConsumoElectrico.Modulo.Usuario;

public class Recomendador {

    private AnalizadorConsumo analizador;
    private CalculadoraConsumo calculadora;

    public Recomendador() {

        analizador = new AnalizadorConsumo();
        calculadora = new CalculadoraConsumo();
    }

    public void generarRecomendaciones(Usuario usuario) {

        System.out.println("\n===== RECOMENDACIONES =====");

        String nivel = analizador.clasificarConsumo(usuario);

        switch (nivel) {

            case "BAJO":

                System.out.println(
                        "Excelente. Su consumo energético es eficiente.");
                break;

            case "NORMAL":

                System.out.println(
                        "Su consumo es adecuado. Mantenga sus hábitos actuales.");
                break;

            case "ALTO":

                System.out.println(
                        "Su consumo está por encima de lo recomendado.");
                System.out.println(
                        "Revise los dispositivos de mayor uso.");
                break;

            case "CRITICO":

                System.out.println(
                        "Su consumo es excesivamente alto.");
                System.out.println(
                        "Se recomienda tomar medidas inmediatas de ahorro.");
                break;
        }

        Dispositivo mayor =
                analizador.obtenerMayorConsumidor(usuario);

        if (mayor != null) {

            System.out.println("\nDispositivo que más consume:");

            System.out.println(
                    mayor.getNombre());

            System.out.printf(
                    "Consumo mensual: %.2f kWh%n",
                    mayor.calcularConsumoMensual());

            System.out.println(
                    "\nSugerencia:");

            System.out.println(
                    "Reducir las horas de uso de "
                            + mayor.getNombre()
                            + " podría disminuir significativamente el consumo.");
        }

        double consumo =
                calculadora.calcularConsumoMensual(usuario);

        double limite =
                usuario.getSector().getLimiteConsumo();

        if (consumo > limite) {

            System.out.println(
                    "\nSu consumo supera el límite recomendado para el sector "
                            + usuario.getSector());

            System.out.println(
                    "Considere utilizar dispositivos de bajo consumo energético.");
        }

        System.out.println(
                "\nApague equipos que no estén en uso.");

        System.out.println(
                "Realice mantenimiento periódico a los electrodomésticos.");

        System.out.println(
                "Utilice iluminación LED cuando sea posible.");
    }
}

