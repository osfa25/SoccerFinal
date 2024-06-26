package com.soccer;

import com.soccer.model.entity.Coach;
import com.soccer.model.entity.Doctor;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;
import java.util.Hashtable;

public class Controller {
   private Hashtable<String, Team> equipos;
   public Hashtable<Integer, Player> jugadores;
   public static Hashtable<Integer, Coach> entrenadores;
   public Hashtable<Integer, Doctor> doctores;

   public Controller() {
       this.equipos = new Hashtable<>();
       this.jugadores = new Hashtable<>();
       this.entrenadores = new Hashtable<>();
       this.doctores = new Hashtable<>();
   }

   // Getters and Setters
   public Hashtable<String, Team> getEquipos() {
       return equipos;
   }

   public void setEquipos(Hashtable<String, Team> equipos) {
       this.equipos = equipos;
   }

   public Hashtable<Integer, Player> getJugadores() {
       return jugadores;
   }

   public void setJugadores(Hashtable<Integer, Player> jugadores) {
       this.jugadores = jugadores;
   }

   public Hashtable<Integer, Coach> getEntrenadores() {
       return entrenadores;
   }

   public void setEntrenadores(Hashtable<Integer, Coach> entrenadores) {
       this.entrenadores = entrenadores;
   }

   public Hashtable<Integer, Doctor> getDoctores() {
       return doctores;
   }

   public void setDoctores(Hashtable<Integer, Doctor> doctores) {
       this.doctores = doctores;
   }
}
