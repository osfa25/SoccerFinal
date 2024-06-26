package com.soccer.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
   private String nombre;
   private String ciudad;
   private List<Player> lstJugadores = new ArrayList<>();
   private List<Coach> lstEntrenadores = new ArrayList<>();
   private List<Doctor> lstMasajistas = new ArrayList<>();

   public Team() {
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getCiudad() {
      return this.ciudad;
   }

   public void setCiudad(String ciudad) {
      this.ciudad = ciudad;
   }

   public List<Player> getLstJugadores() {
      return this.lstJugadores;
   }

   public void setLstJugadores(List<Player> jugadores) {
      this.lstJugadores = jugadores;
   }

   public List<Coach> getLstEntrenadores() {
      return this.lstEntrenadores;
   }

   public void setLstEntrenadores(List<Coach> coachs) {
      this.lstEntrenadores = coachs;
   }

   public List<Doctor> getLstMasajistas() {
      return this.lstMasajistas;
   }

   public void setLstMasajistas(List<Doctor> doctores) {
      this.lstMasajistas = doctores;
   }
}
