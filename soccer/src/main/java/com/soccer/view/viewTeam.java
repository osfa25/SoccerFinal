package com.soccer.view;

import com.soccer.Controller;
import com.soccer.model.entity.Coach;
import com.soccer.model.entity.Doctor;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;
import java.util.ArrayList;
import java.util.Scanner;

public class viewTeam {
    private static Controller controlador;

    public viewTeam() {}

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            int choice = sc.nextInt();
            sc.nextLine();
            Team equipo;
            String codigoEquipo;

            switch (choice) {
                case 1:
                    crearEquipo(sc);
                    break;
                case 2:
                    actualizarEquipo(sc);
                    break;
                case 3:
                    buscarEquipo(sc);
                    break;
                case 4:
                    eliminarEquipo(sc);
                    break;
                case 5:
                    listarEquipos();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void crearEquipo(Scanner sc) {
        Team equipo = new Team();
        ArrayList<Player> jugadores = new ArrayList<>();
        ArrayList<Coach> instructores = new ArrayList<>();
        ArrayList<Doctor> doctores = new ArrayList<>();

        System.out.println("Ingrese el código del equipo:");
        String codigoEquipo = sc.nextLine();
        System.out.println("Ingrese Nombre del equipo:");
        equipo.setNombre(sc.nextLine());
        System.out.println("Ingrese la ciudad:");
        equipo.setCiudad(sc.nextLine());

        agregarJugadores(sc, jugadores);
        equipo.setLstJugadores(jugadores);

        agregarEntrenadores(sc, instructores);
        equipo.setLstEntrenadores(instructores);

        agregarDoctores(sc, doctores);
        equipo.setLstMasajistas(doctores);

        controlador.getEquipos().put(codigoEquipo, equipo);
    }

    private void actualizarEquipo(Scanner sc) {
        System.out.println("Ingrese el código del equipo a actualizar:");
        String codigoEquipo = sc.nextLine();

        if (controlador.getEquipos().containsKey(codigoEquipo)) {
            Team equipo = controlador.getEquipos().get(codigoEquipo);
            System.out.println("Ingrese el nuevo nombre del equipo:");
            equipo.setNombre(sc.nextLine());
            System.out.println("Ingrese la nueva ciudad del equipo:");
            equipo.setCiudad(sc.nextLine());

            ArrayList<Player> jugadores = new ArrayList<>();
            agregarJugadores(sc, jugadores);
            equipo.setLstJugadores(jugadores);

            ArrayList<Coach> entrenadores = new ArrayList<>();
            agregarEntrenadores(sc, entrenadores);
            equipo.setLstEntrenadores(entrenadores);

            ArrayList<Doctor> doctores = new ArrayList<>();
            agregarDoctores(sc, doctores);
            equipo.setLstMasajistas(doctores);

            controlador.getEquipos().put(codigoEquipo, equipo);
            System.out.println("Equipo actualizado correctamente.");
        } else {
            System.out.println("El equipo con código " + codigoEquipo + " no existe.");
        }
    }

    private void buscarEquipo(Scanner sc) {
        System.out.println("Ingrese el ID del equipo (o 'salir' para salir):");
        while (true) {
            String codigoEquipo = sc.nextLine();
            if (codigoEquipo.equalsIgnoreCase("salir")) {
                return;
            }

            if (controlador.getEquipos().containsKey(codigoEquipo)) {
                Team equipo = controlador.getEquipos().get(codigoEquipo);
                System.out.println("Nombre del equipo: " + equipo.getNombre());
                System.out.println("Ciudad: " + equipo.getCiudad());
                return;
            } else {
                System.out.println("El equipo con el ID '" + codigoEquipo + "' no existe.");
            }
        }
    }

    private void eliminarEquipo(Scanner sc) {
        System.out.println("Ingrese el ID del equipo a eliminar:");
        String codigoEquipo = sc.nextLine();

        if (controlador.getEquipos().containsKey(codigoEquipo)) {
            controlador.getEquipos().remove(codigoEquipo);
            System.out.println("El equipo ha sido eliminado");
        } else {
            System.out.println("El equipo con código " + codigoEquipo + " no existe.");
        }
    }

    private void listarEquipos() {
        System.out.println("Listado de todos los Equipos:");
        for (String key : controlador.getEquipos().keySet()) {
            Team equipo = controlador.getEquipos().get(key);
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Ciudad: " + equipo.getCiudad());
            System.out.println("Jugadores:");
            for (Player jugador : equipo.getLstJugadores()) {
                System.out.println("- ID: " + jugador.getId());
            }
            System.out.println("Entrenadores:");
            for (Coach entrenador : equipo.getLstEntrenadores()) {
                System.out.println("- ID: " + entrenador.getId());
            }
            System.out.println("Doctores:");
            for (Doctor doctor : equipo.getLstMasajistas()) {
                System.out.println("- ID: " + doctor.getId());
            }
            System.out.println("-----------------------------------");
        }
    }

    private void agregarJugadores(Scanner sc, ArrayList<Player> jugadores) {
        while (true) {
            System.out.println("Ingrese el ID del jugador:");
            int idJugador = sc.nextInt();
            sc.nextLine();
            if (controlador.getJugadores().containsKey(idJugador)) {
                jugadores.add(controlador.getJugadores().get(idJugador));
            } else {
                System.out.println("El jugador que quieres agregar no existe.");
            }
            System.out.println("¿Quiere agregar otro jugador? \n 1: Sí \n 2: No");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion != 1) {
                break;
            }
        }
    }

    private void agregarEntrenadores(Scanner sc, ArrayList<Coach> entrenadores) {
        while (true) {
            System.out.println("Ingrese el ID del entrenador:");
            int idEntrenador = sc.nextInt();
            sc.nextLine();
            if (controlador.getEntrenadores().containsKey(idEntrenador)) {
                entrenadores.add(controlador.getEntrenadores().get(idEntrenador));
            } else {
                System.out.println("El entrenador no existe.");
            }
            System.out.println("¿Quiere agregar otro entrenador? \n 1: Sí \n 2: No");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion != 1) {
                break;
            }
        }
    }

    private void agregarDoctores(Scanner sc, ArrayList<Doctor> doctores) {
        while (true) {
            System.out.println("Ingrese el ID del doctor:");
            int idDoctor = sc.nextInt();
            sc.nextLine();
            if (controlador.getDoctores().containsKey(idDoctor)) {
                doctores.add(controlador.getDoctores().get(idDoctor));
            } else {
                System.out.println("El doctor no existe.");
            }
            System.out.println("¿Quiere agregar otro doctor? \n 1: Sí \n 2: No");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion != 1) {
                break;
            }
        }
    }

    public static void setControlador(Controller ctrl) {
        controlador = ctrl;
    }
}
