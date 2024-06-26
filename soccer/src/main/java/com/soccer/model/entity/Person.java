// Source code is decompiled from a .class file using FernFlower decompiler.
package com.soccer.model.entity;

public class Person {
   private int id;
   private String nombre;
   private String apellido;
   private int edad;

   public Person() {
   }

   public Person(int id, String nombre, String apellido, int edad) {
      this.id = id;
      this.nombre = nombre;
      this.apellido = apellido;
      this.edad = edad;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return this.apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public int getEdad() {
      return this.edad;
   }

   public void setEdad(int edad) {
      this.edad = edad;
   }
}
