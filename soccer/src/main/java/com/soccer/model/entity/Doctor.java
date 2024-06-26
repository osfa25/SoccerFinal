// Source code is decompiled from a .class file using FernFlower decompiler.
package com.soccer.model.entity;

public class Doctor extends Person {
   private String titulo;
   private int expYear;

   public Doctor() {
   }

   public Doctor(String titulo, int expYear) {
      this.titulo = titulo;
      this.expYear = expYear;
   }

   public Doctor(int id, String nombre, String apellido, int edad, String titulo, int expYear) {
      super(id, nombre, apellido, edad);
      this.titulo = titulo;
      this.expYear = expYear;
   }

   public String getTitulo() {
      return this.titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public int getExpYear() {
      return this.expYear;
   }

   public void setExpYear(int expYear) {
      this.expYear = expYear;
   }
}
