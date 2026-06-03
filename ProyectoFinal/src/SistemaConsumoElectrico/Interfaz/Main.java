
import SistemaConsumoElectrico.Modulo.*;
import SistemaConsumoElectrico.Negocio.*;
import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);

    SistemaEnergetico sistema = new SistemaEnergetico();
    CatalogoDispositivos catalogo = new CatalogoDispositivos();

    Usuario usuarioActual = null;

    int opcion;

    do {

        System.out.println("\n========================================");
        System.out.println(" SISTEMA INTELIGENTE DE CONSUMO ENERGÉTICO");
        System.out.println("========================================");
        System.out.println("1. Registrar usuario residencial");
        System.out.println("2. Registrar empresa");
        System.out.println("3. Mostrar usuarios");
        System.out.println("4. Seleccionar usuario");
        System.out.println("5. Eliminar usuario");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case 1:

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                Sector sector = seleccionarSector(sc);

                UsuarioResidencial usuario =
                        new UsuarioResidencial(
                                id,
                                nombre,
                                sector
                        );

                sistema.getGestorUsuarios()
                        .agregarUsuario(usuario);

                System.out.println("Usuario registrado correctamente.");

                break;

            case 2:

                System.out.print("ID: ");
                int idEmpresa = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre empresa: ");
                String nombreEmpresa = sc.nextLine();

                Sector sectorEmpresa =
                        seleccionarSector(sc);

                System.out.print("RUC: ");
                String ruc = sc.nextLine();

                System.out.print("Actividad económica: ");
                String actividad = sc.nextLine();

                UsuarioEmpresa empresa =
                        new UsuarioEmpresa(
                                idEmpresa,
                                nombreEmpresa,
                                sectorEmpresa,
                                ruc,
                                actividad
                        );

                sistema.getGestorUsuarios()
                        .agregarUsuario(empresa);

                System.out.println("Empresa registrada correctamente.");

                break;

            case 3:

                sistema.getGestorUsuarios()
                        .mostrarUsuarios();

                break;

            case 4:

                System.out.print("Ingrese ID del usuario: ");

                int idBuscar = sc.nextInt();

                usuarioActual =
                        sistema.getGestorUsuarios()
                                .buscarUsuario(idBuscar);

                if (usuarioActual != null) {

                    menuUsuario(
                            sc,
                            usuarioActual,
                            sistema,
                            catalogo
                    );
                } else {

                    System.out.println(
                            "Usuario no encontrado."
                    );
                }

                break;

            case 5:

                System.out.print(
                        "Ingrese ID del usuario a eliminar: "
                );

                int idEliminar = sc.nextInt();

                boolean eliminado =
                        sistema.getGestorUsuarios()
                                .eliminarUsuario(idEliminar);

                if (eliminado) {

                    System.out.println(
                            "Usuario eliminado."
                    );

                } else {

                    System.out.println(
                            "Usuario no encontrado."
                    );
                }

                break;

            case 6:

                System.out.println(
                        "\nGracias por utilizar el sistema."
                );

                break;

            default:

                System.out.println(
                        "Opción inválida."
                );
        }

    } while (opcion != 6);

    sc.close();
}

private static void menuUsuario(
        Scanner sc,
        Usuario usuario,
        SistemaEnergetico sistema,
        CatalogoDispositivos catalogo) {

    int opcion;

    do {

        System.out.println("\n================================");
        System.out.println("USUARIO ACTUAL: "
                + usuario.getNombre());
        System.out.println("================================");

        System.out.println("1. Agregar dispositivo catálogo");
        System.out.println("2. Agregar dispositivo personalizado");
        System.out.println("3. Mostrar dispositivos");
        System.out.println("4. Ver resumen energético");
        System.out.println("5. Ver análisis energético");
        System.out.println("6. Generar factura");
        System.out.println("7. Ver recomendaciones");
        System.out.println("8. Mostrar información usuario");
        System.out.println("9. Regresar");

        System.out.print("Seleccione una opción: ");

        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case 1:

                catalogo.mostrarCatalogo();

                System.out.print(
                        "Seleccione dispositivo: "
                );

                int idDispositivo = sc.nextInt();

                if (idDispositivo >= 1
                        && idDispositivo <= 8) {

                    Dispositivo base =
                            catalogo.buscarDispositivo(
                                    idDispositivo
                            );

                    System.out.print(
                            "Cantidad: "
                    );

                    int cantidad =
                            sc.nextInt();

                    System.out.print(
                            "Horas uso diarias: "
                    );

                    double horas =
                            sc.nextDouble();

                    Dispositivo nuevo =
                            new Dispositivo(
                                    base.getId(),
                                    base.getNombre(),
                                    base.getPotencia(),
                                    cantidad,
                                    horas
                            );

                    usuario.agregarDispositivo(
                            nuevo
                    );

                    System.out.println(
                            "Dispositivo agregado."
                    );
                }

                break;

            case 2:

                System.out.print(
                        "ID dispositivo: "
                );

                int idPersonal =
                        sc.nextInt();

                sc.nextLine();

                System.out.print(
                        "Nombre: "
                );

                String nombre =
                        sc.nextLine();

                System.out.print(
                        "Potencia (W): "
                );

                double potencia =
                        sc.nextDouble();

                System.out.print(
                        "Cantidad: "
                );

                int cantidad =
                        sc.nextInt();

                System.out.print(
                        "Horas uso diarias: "
                );

                double horas =
                        sc.nextDouble();

                Dispositivo personalizado =
                        new Dispositivo(
                                idPersonal,
                                nombre,
                                potencia,
                                cantidad,
                                horas
                        );

                usuario.agregarDispositivo(
                        personalizado
                );

                System.out.println(
                        "Dispositivo agregado."
                );

                break;

            case 3:

                if (usuario.getDispositivos()
                        .isEmpty()) {

                    System.out.println(
                            "No existen dispositivos."
                    );

                } else {

                    for (Dispositivo d :
                            usuario.getDispositivos()) {

                        System.out.println(d);
                    }
                }

                break;

            case 4:

                sistema.mostrarResumenUsuario(
                        usuario
                );

                break;

            case 5:

                sistema.mostrarAnalisisUsuario(
                        usuario
                );

                break;

            case 6:

                sistema.generarFactura(
                        usuario
                );

                break;

            case 7:

                sistema.mostrarRecomendaciones(
                        usuario
                );

                break;

            case 8:

                usuario.mostrarInformacion();

                break;

            case 9:

                System.out.println(
                        "Regresando..."
                );

                break;

            default:

                System.out.println(
                        "Opción inválida."
                );
        }

    } while (opcion != 9);
}

private static Sector seleccionarSector(
        Scanner sc) {

    System.out.println("\nSeleccione sector:");

    Sector[] sectores =
            Sector.values();

    for (int i = 0;
         i < sectores.length;
         i++) {

        System.out.println(
                (i + 1)
                        + ". "
                        + sectores[i]
        );
    }

    System.out.print("Opción: ");

    int opcion = sc.nextInt();

    return sectores[opcion - 1];
}





