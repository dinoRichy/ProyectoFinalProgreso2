package SistemaConsumoElectrico.Negocio;

import SistemaConsumoElectrico.Modulo.Usuario;

public class Factura {

    private Usuario usuario;
    private CalculadoraConsumo calculadora;

    private static final double IVA = 0.15;

    public Factura(Usuario usuario) {

        this.usuario = usuario;
        this.calculadora = new CalculadoraConsumo();
    }

    public double calcularSubtotal() {

        return calculadora.calcularCostoMensual(usuario);
    }

    public double calcularIVA() {

        return calcularSubtotal() * IVA;
    }

    public double calcularTotal() {

        return calcularSubtotal() + calcularIVA();
    }

    public void mostrarFactura() {

        System.out.println("\n==================================");
        System.out.println("      FACTURA DE CONSUMO");
        System.out.println("==================================");

        System.out.println("Cliente: " + usuario.getNombre());
        System.out.println("Sector : " + usuario.getSector());

        System.out.printf(
                "Consumo mensual: %.2f kWh%n",
                calculadora.calcularConsumoMensual(usuario));

        System.out.printf(
                "Tarifa aplicada: $%.2f por kWh%n",
                usuario.obtenerTarifa());

        System.out.printf(
                "Subtotal: $%.2f%n",
                calcularSubtotal());

        System.out.printf(
                "IVA (15%%): $%.2f%n",
                calcularIVA());

        System.out.printf(
                "TOTAL A PAGAR: $%.2f%n",
                calcularTotal());

        System.out.println("==================================");
    }
}
