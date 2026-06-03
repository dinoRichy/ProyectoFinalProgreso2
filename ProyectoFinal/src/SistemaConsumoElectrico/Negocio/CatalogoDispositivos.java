package SistemaConsumoElectrico.Negocio;

import java.util.ArrayList;
import SistemaConsumoElectrico.Modulo.Dispositivo;

public class CatalogoDispositivos {

    private ArrayList<Dispositivo> catalogo;

    public CatalogoDispositivos() {

        catalogo = new ArrayList<>();

        cargarDispositivos();
    }

    private void cargarDispositivos() {

        catalogo.add(new Dispositivo(1, "Televisor", 150, 1, 5));
        catalogo.add(new Dispositivo(2, "Refrigerador", 350, 1, 24));
        catalogo.add(new Dispositivo(3, "Microondas", 1200, 1, 0.5));
        catalogo.add(new Dispositivo(4, "Lavadora", 500, 1, 1));
        catalogo.add(new Dispositivo(5, "Computadora", 300, 1, 6));
        catalogo.add(new Dispositivo(6, "Aire Acondicionado", 1500, 1, 8));
        catalogo.add(new Dispositivo(7, "Plancha", 1200, 1, 0.5));
        catalogo.add(new Dispositivo(8, "Licuadora", 400, 1, 0.25));
    }

    public void mostrarCatalogo() {

        System.out.println("\n===== CATÁLOGO DE DISPOSITIVOS =====");

        for (Dispositivo d : catalogo) {

            System.out.println(
                    d.getId() + ". " +
                            d.getNombre() +
                            " (" + d.getPotencia() + " W)"
            );
        }

        System.out.println("9. Otro dispositivo");
    }

    public Dispositivo buscarDispositivo(int id) {

        for (Dispositivo d : catalogo) {

            if (d.getId() == id) {

                return d;
            }
        }

        return null;
    }

    public ArrayList<Dispositivo> getCatalogo() {
        return catalogo;
    }
}
