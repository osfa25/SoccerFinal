// Source code is decompiled from a .class file using FernFlower decompiler.
package com.soccer.model.entity;

public class Player extends Person {
   private int dorsal;
   private String posicion;

   public Player() {
   }

   public Player(int dorsal, String posicion) {
      this.dorsal = dorsal;
      this.posicion = posicion;
   }

   public Player(int id, String nombre, String apellido, int edad, int dorsal, String posicion) {
      super(id, nombre, apellido, edad);
      this.dorsal = dorsal;
      this.posicion = posicion;
   }

   public int getDorsal() {
      return this.dorsal;
   }

   public void setDorsal(int dorsal) {
      this.dorsal = dorsal;
   }

   public String getPosicion() {
      return this.posicion;
   }

   public void setPosicion(String posicion) {
      this.posicion = posicion;
   }
}
