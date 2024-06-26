// Source code is decompiled from a .class file using FernFlower decompiler.
package com.soccer.view;

import com.soccer.Controller;
import com.soccer.model.entity.Coach;
import java.util.Iterator;
import java.util.Scanner;

public class viewCoach {
   public static Controller controlador;

   public viewCoach() {
   }

   public void start() {
      Scanner sc = new Scanner(System.in);

      label43:
      while(true) {
         System.out.println("1. Crear entrenador");
         System.out.println("2. Actualizar entrenador");
         System.out.println("3. Buscar entrenador");
         System.out.println("4. Eliminar entrenador");
         System.out.println("5. Listar todos entrenador");
         System.out.println("6. Salir");
         int choice = sc.nextInt();
         sc.nextLine();
         new Coach();
         Coach ch;
         int codigoc;
         int key;
         switch (choice) {
            case 1:
               System.out.println("Ingrese el id del entrenador: ");
               int idcoach = sc.nextInt();
               sc.nextLine();
               System.out.println("Ingrese el nombre del entrenador:");
               String nombrentrenador = sc.nextLine();
               System.out.println("Ingrese el apellido del coach: ");
               String apellidoentrenenador = sc.nextLine();
               System.out.println("Ingrese la edad del entrenador: ");
               int edadentrenador = sc.nextInt();
               sc.nextLine();
               System.out.println("Ingrese la id de la federacion: ");
               int idfederacion = sc.nextInt();
               sc.nextLine();
               Coach nuevoCoach = new Coach(idcoach, nombrentrenador, apellidoentrenenador, edadentrenador, idfederacion);
               Controller.entrenadores.put(idcoach, nuevoCoach);
               break;
            case 2:
               System.out.println("Ingrese el id del coach a actualizar: ");
               int codigoentrenador = sc.nextInt();
               sc.nextLine();
               if (Controller.entrenadores.containsKey(codigoentrenador)) {
                  ch = (Coach)Controller.entrenadores.get(codigoentrenador);
                  System.out.println("Ingrese el nombre de el entrenador: ");
                  String nuevonombre = sc.nextLine();
                  ch.setNombre(nuevonombre);
                  System.out.println("Ingrese el apellido del entrenado: ");
                  String nuevoapellido = sc.nextLine();
                  ch.setApellido(nuevoapellido);
                  System.out.println("Ingrese la edad del entrenador: ");
                  key = sc.nextInt();
                  sc.nextLine();
                  ch.setEdad(key);
                  System.out.println("Ingrese el id de la federacion: ");
                  int nuevafederacion = sc.nextInt();
                  sc.nextLine();
                  ch.setIdFederacion(nuevafederacion);
               } else {
                  System.out.println("El coach con el id: " + codigoentrenador + " no existe.");
               }
               break;
            case 3:
               new Coach();
               boolean encontrado = false;

               while(true) {
                  if (encontrado) {
                     continue label43;
                  }

                  System.out.println("Ingrese el id del coach: ");
                  codigoc = sc.nextInt();
                  sc.nextLine();
                  if (Controller.entrenadores.containsKey(codigoc)) {
                     ch = (Coach)Controller.entrenadores.get(codigoc);
                     System.out.println("Nombre del coach es: " + ch.getNombre());
                     encontrado = true;
                     continue label43;
                  }

                  if (!encontrado) {
                     System.out.println("El entrenado con el id: " + codigoc + " no existe.");
                  }
               }
            case 4:
               System.out.println("Ingrese el id del entrenador a eliminar: ");
               codigoc = sc.nextInt();
               sc.nextLine();
               if (Controller.entrenadores.containsKey(codigoc)) {
                  Controller.entrenadores.remove(codigoc);
                  System.out.println("El entrenador con el id " + codigoc + " ha sido eliminado.");
               } else {
                  System.out.println("El entrenador con el id " + codigoc + " no existe.");
               }
               break;
            case 5:
               System.out.println("Listado de todos los entrenadores:");
               Iterator var15 = Controller.entrenadores.keySet().iterator();

               while(true) {
                  if (!var15.hasNext()) {
                     continue label43;
                  }

                  key = (Integer)var15.next();
                  Coach coach = (Coach)Controller.entrenadores.get(key);
                  System.out.println("ID: " + coach.getId());
                  System.out.println("Nombre: " + coach.getNombre());
                  System.out.println("Apellido: " + coach.getApellido());
                  System.out.println("Edad: " + coach.getEdad());
                  System.out.println("ID de Federaci\u00f3n: " + coach.getIdFederacion());
                  System.out.println("----------------------");
               }
            case 6:
               return;
            default:
               System.out.println("Opcion invalida, intentelo de nuevo.");
         }
      }
   }

public static void setControlador(Controller ctrlCoach) {
  
    throw new UnsupportedOperationException("Unimplemented method 'setControlador'");
}
}
