package SistemaConsumoElectrico.Negocio;

import java.util.ArrayList;
import SistemaConsumoElectrico.Modulo.Usuario;

public class GestorUsuarios {

    private ArrayList<Usuario> usuarios;

    public GestorUsuarios() {

        usuarios = new ArrayList<>();
    }

    // Agregar usuario
    public void agregarUsuario(Usuario usuario) {

        usuarios.add(usuario);
    }

    // Buscar usuario por ID
    public Usuario buscarUsuario(int id) {

        for (Usuario u : usuarios) {

            if (u.getId() == id) {

                return u;
            }
        }

        return null;
    }

    // Eliminar usuario
    public boolean eliminarUsuario(int id) {

        Usuario usuario = buscarUsuario(id);

        if (usuario != null) {

            usuarios.remove(usuario);
            return true;
        }

        return false;
    }

    // Mostrar todos los usuarios
    public void mostrarUsuarios() {

        if (usuarios.isEmpty()) {

            System.out.println(
                    "\nNo existen usuarios registrados.");
            return;
        }

        System.out.println("\n===== USUARIOS REGISTRADOS =====");

        for (Usuario u : usuarios) {

            System.out.println(
                    "ID: " + u.getId()
                            + " | Nombre: " + u.getNombre()
                            + " | Sector: " + u.getSector());
        }
    }

    // Cantidad de usuarios
    public int cantidadUsuarios() {

        return usuarios.size();
    }

    // Obtener lista completa
    public ArrayList<Usuario> getUsuarios() {

        return usuarios;
    }
}