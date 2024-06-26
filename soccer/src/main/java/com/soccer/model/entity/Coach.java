// Source code is decompiled from a .class file using FernFlower decompiler.
package com.soccer.model.entity;

public class Coach extends Person {
   private int idFederacion;

   public Coach() {
   }

   public Coach(int idFederacion) {
      this.idFederacion = idFederacion;
   }

   public Coach(int id, String nombre, String apellido, int edad, int idFederacion) {
      super(id, nombre, apellido, edad);
      this.idFederacion = idFederacion;
   }

   public int getIdFederacion() {
      return this.idFederacion;
   }

   public void setIdFederacion(int idFederacion) {
      this.idFederacion = idFederacion;
   }
}
