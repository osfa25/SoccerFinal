package com.soccer;

import com.soccer.view.viewCoach;
import com.soccer.view.viewDoctor;
import com.soccer.view.viewPlayer;
import com.soccer.view.viewTeam;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializar controladores
        Controller ctrlTeams = new Controller();
        Controller ctrlPlayers = new Controller();
        Controller ctrlDoctor = new Controller();
        Controller ctrlCoach = new Controller();

        // Asignar controladores a las vistas
        viewTeam.setControlador(ctrlTeams);
        viewPlayer.setControlador(ctrlPlayers);
        viewDoctor.setControlador(ctrlDoctor);
        viewCoach.setControlador(ctrlCoach);

        // Crear instancias de las vistas
        viewTeam vt = new viewTeam();
        viewPlayer vp = new viewPlayer();
        viewDoctor vd = new viewDoctor();
        viewCoach vc = new viewCoach();

        // Menú de gestión
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de gestion de la liga BetPlay");

        while (true) {
            int opcion = 0;
            while (true) {
                System.out.println("Opciones: \n 1: Equipos \n 2: Jugadores \n 3: Médicos \n 4: Instructores \n 5: Salir");
                try {
                    opcion = sc.nextInt();
                    sc.nextLine();
                    if (opcion >= 1 && opcion <= 5) {
                        break;
                    } else {
                        System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 5.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    sc.nextLine();
                }
            }

            switch (opcion) {
                case 1:
                    vt.start();
                    break;
                case 2:
                    vp.start();
                    break;
                case 3:
                    vd.start();
                    break;
                case 4:
                    vc.start();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 5.");
                    break;
            }
        }
    }
}
