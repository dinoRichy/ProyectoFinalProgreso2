package SistemaConsumoElectrico.Modulo;

import java.util.ArrayList;

public abstract class Usuario extends Persona {

    protected int id;
    protected Sector sector;
    protected ArrayList<Dispositivo> dispositivos;

    public Usuario(int id, String nombre, Sector sector) {

        super(nombre);

        this.id = id;
        this.sector = sector;

        dispositivos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Sector getSector() {
        return sector;
    }

    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public boolean eliminarDispositivo(int idDispositivo) {

        for (Dispositivo d : dispositivos) {

            if (d.getId() == idDispositivo) {

                dispositivos.remove(d);
                return true;
            }
        }

        return false;
    }

    public void mostrarDispositivos() {

        if (dispositivos.isEmpty()) {

            System.out.println("No existen dispositivos registrados.");
            return;
        }

        for (Dispositivo d : dispositivos) {

            System.out.println(d);
        }
    }

    public abstract double obtenerTarifa();

}

