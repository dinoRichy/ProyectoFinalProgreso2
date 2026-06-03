package SistemaConsumoElectrico.Negocio;

import SistemaConsumoElectrico.Modulo.Usuario;

public class SistemaEnergetico {

    private GestorUsuarios gestorUsuarios;
    private CalculadoraConsumo calculadora;
    private AnalizadorConsumo analizador;
    private Recomendador recomendador;

    public SistemaEnergetico() {

        gestorUsuarios = new GestorUsuarios();
        calculadora = new CalculadoraConsumo();
        analizador = new AnalizadorConsumo();
        recomendador = new Recomendador();
    }

    public GestorUsuarios getGestorUsuarios() {
        return gestorUsuarios;
    }

    public void mostrarResumenUsuario(Usuario usuario) {

        calculadora.mostrarResumen(usuario);
    }

    public void mostrarAnalisisUsuario(Usuario usuario) {

        analizador.mostrarAnalisis(usuario);
    }

    public void mostrarRecomendaciones(Usuario usuario) {

        recomendador.generarRecomendaciones(usuario);
    }

    public void generarFactura(Usuario usuario) {

        Factura factura = new Factura(usuario);

        factura.mostrarFactura();
    }
}
