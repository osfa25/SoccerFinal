package com.soccer.view;

import com.soccer.Controller;
import com.soccer.model.entity.Doctor;

import java.util.Iterator;
import java.util.Scanner;

public class viewDoctor {
    public static Controller controlador;

    public viewDoctor() {
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear medico");
            System.out.println("2. Actualizar medico");
            System.out.println("3. Buscar medico");
            System.out.println("4. Eliminar medico");
            System.out.println("5. Listar todos los medicos");
            System.out.println("6. Salir");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    crearMedico(sc);
                    break;
                case 2:
                    actualizarMedico(sc);
                    break;
                case 3:
                    buscarMedico(sc);
                    break;
                case 4:
                    eliminarMedico(sc);
                    break;
                case 5:
                    listarMedicos();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción inválida, intentelo de nuevo.");
            }
        }
    }

    private void crearMedico(Scanner sc) {
        System.out.println("Ingrese el id del medico:");
        int idMedico = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el nombre del medico:");
        String nombreMedico = sc.nextLine();
        System.out.println("Ingrese el apellido del medico:");
        String apellidoMedico = sc.nextLine();
        System.out.println("Ingrese la edad del medico:");
        int edadMedico = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el titulo del medico:");
        String tituloMedico = sc.nextLine();
        System.out.println("Ingrese los años de experiencia:");
        int expYear = sc.nextInt();
        sc.nextLine();
        Doctor nuevoDoctor = new Doctor(idMedico, nombreMedico, apellidoMedico, edadMedico, tituloMedico, expYear);
        controlador.doctores.put(idMedico, nuevoDoctor);
    }

    private void actualizarMedico(Scanner sc) {
        System.out.println("Ingrese el id del medico a actualizar:");
        int idMedico = sc.nextInt();
        sc.nextLine();
        if (controlador.doctores.containsKey(idMedico)) {
            Doctor medico = controlador.doctores.get(idMedico);
            System.out.println("Ingrese el nombre del medico:");
            String nuevoNombre = sc.nextLine();
            medico.setNombre(nuevoNombre);
            System.out.println("Ingrese el apellido del medico:");
            String nuevoApellido = sc.nextLine();
            medico.setApellido(nuevoApellido);
            System.out.println("Ingrese la edad del medico:");
            int nuevaEdad = sc.nextInt();
            sc.nextLine();
            medico.setEdad(nuevaEdad);
            System.out.println("Ingrese el titulo del medico:");
            String nuevoTitulo = sc.nextLine();
            medico.setTitulo(nuevoTitulo);
            System.out.println("Ingrese los años de experiencia del medico:");
            int nuevosXpYears = sc.nextInt();
            sc.nextLine();
            medico.setExpYear(nuevosXpYears);
        } else {
            System.out.println("El medico con el id: " + idMedico + " no existe.");
        }
    }

    private void buscarMedico(Scanner sc) {
        boolean encontrado = false;
        while (!encontrado) {
            System.out.println("Ingrese el id del medico:");
            int idMedico = sc.nextInt();
            sc.nextLine();
            if (controlador.doctores.containsKey(idMedico)) {
                Doctor medico = controlador.doctores.get(idMedico);
                System.out.println("Nombre del medico es: " + medico.getNombre());
                encontrado = true;
            } else {
                System.out.println("El medico con el id: " + idMedico + " no existe.");
            }
        }
    }

    private void eliminarMedico(Scanner sc) {
        System.out.println("Ingrese el id del medico a eliminar:");
        int idMedico = sc.nextInt();
        sc.nextLine();
        if (controlador.doctores.containsKey(idMedico)) {
            controlador.doctores.remove(idMedico);
            System.out.println("El medico con el id = " + idMedico + " ha sido eliminado.");
        } else {
            System.out.println("El medico con el id: " + idMedico + " no existe.");
        }
    }

    private void listarMedicos() {
        System.out.println("Listado de todos los medicos:");
        Iterator<Integer> it = controlador.doctores.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            Doctor medico = controlador.doctores.get(key);
            System.out.println("Id: " + medico.getId());
            System.out.println("Nombre: " + medico.getNombre());
            System.out.println("Apellido: " + medico.getApellido());
            System.out.println("Edad: " + medico.getEdad());
            System.out.println("Titulo: " + medico.getTitulo());
            System.out.println("Años de experiencia: " + medico.getExpYear());
            System.out.println("-----------------------------------");
        }
    }

    public static void setControlador(Controller ctrlDoctores) {
        controlador = ctrlDoctores;
    }
}
