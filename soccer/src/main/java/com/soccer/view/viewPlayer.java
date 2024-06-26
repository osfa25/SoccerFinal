package com.soccer.view;

import com.soccer.Controller;
import com.soccer.model.entity.Player;

import java.util.Iterator;
import java.util.Scanner;

public class viewPlayer {
    public static Controller controlador;

    public viewPlayer() {
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Buscar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar todos Jugador");
            System.out.println("6. Salir");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    crearJugador(sc);
                    break;
                case 2:
                    actualizarJugador(sc);
                    break;
                case 3:
                    buscarJugador(sc);
                    break;
                case 4:
                    eliminarJugador(sc);
                    break;
                case 5:
                    listarJugadores();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción inválida, intentelo de nuevo.");
            }
        }
    }

    private void crearJugador(Scanner sc) {
        System.out.println("Ingrese el id del jugador");
        int idJugador = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el nombre del jugador");
        String nombreJugador = sc.nextLine();
        System.out.println("Ingrese el apellido del jugador");
        String apellidoJugador = sc.nextLine();
        System.out.println("Ingrese la edad del jugador");
        int edadJugador = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el dorsal del jugador");
        int dorsalJugador = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la posición del jugador");
        String posicionJugador = sc.nextLine();
        Player nuevoJugador = new Player(idJugador, nombreJugador, apellidoJugador, edadJugador, dorsalJugador, posicionJugador);
        controlador.jugadores.put(idJugador, nuevoJugador);
    }

    private void actualizarJugador(Scanner sc) {
        System.out.println("Ingrese el código del jugador a actualizar:");
        int codigoJugador = sc.nextInt();
        sc.nextLine();
        if (controlador.jugadores.containsKey(codigoJugador)) {
            Player jugador = controlador.jugadores.get(codigoJugador);
            System.out.println("Ingrese el nombre del jugador");
            String nuevoNombre = sc.nextLine();
            jugador.setNombre(nuevoNombre);
            System.out.println("Ingrese el apellido");
            String nuevoApellido = sc.nextLine();
            jugador.setApellido(nuevoApellido);
            System.out.println("Ingrese la edad");
            int nuevaEdad = sc.nextInt();
            sc.nextLine();
            jugador.setEdad(nuevaEdad);
            System.out.println("Ingrese el dorsal");
            int nuevoDorsal = sc.nextInt();
            sc.nextLine();
            jugador.setDorsal(nuevoDorsal);
            System.out.println("Ingrese la posición del jugador");
            String nuevaPosicion = sc.nextLine();
            jugador.setPosicion(nuevaPosicion);
        } else {
            System.out.println("El jugador con el id: " + codigoJugador + " no existe");
        }
    }

    private void buscarJugador(Scanner sc) {
        boolean encontrado = false;
        while (!encontrado) {
            System.out.println("Ingrese el id del jugador:");
            int codigoJugador = sc.nextInt();
            sc.nextLine();
            if (controlador.jugadores.containsKey(codigoJugador)) {
                Player jugador = controlador.jugadores.get(codigoJugador);
                System.out.println("Nombre del jugador es: " + jugador.getNombre());
                encontrado = true;
            } else {
                System.out.println("El jugador con el id: " + codigoJugador + " no existe");
            }
        }
    }

    private void eliminarJugador(Scanner sc) {
        System.out.println("Ingrese el id del jugador a eliminar:");
        int codigoJugador = sc.nextInt();
        sc.nextLine();
        if (controlador.jugadores.containsKey(codigoJugador)) {
            controlador.jugadores.remove(codigoJugador);
            System.out.println("El jugador con el id: " + codigoJugador + " ha sido eliminado");
        } else {
            System.out.println("El jugador con el id: " + codigoJugador + " no existe");
        }
    }

    private void listarJugadores() {
        System.out.println("Listado de todos los jugadores:");
        Iterator<Integer> it = controlador.jugadores.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            Player jugador = controlador.jugadores.get(key);
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + jugador.getNombre());
            System.out.println("Apellido: " + jugador.getApellido());
            System.out.println("Edad: " + jugador.getEdad());
            System.out.println("Dorsal: " + jugador.getDorsal());
            System.out.println("Posición: " + jugador.getPosicion());
            System.out.println("-----------------------------------");
        }
    }

    public static void setControlador(Controller ctrlPlayers) {
        controlador = ctrlPlayers;
    }
}
