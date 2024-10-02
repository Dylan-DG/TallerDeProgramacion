/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase3.Punto4Hotel;

import tema2.Persona;

public class Hotel {
    private int cantHabitaciones;
    private Habitacion[] hotel;
    
    public Hotel(int cantHabitaciones){
        this.cantHabitaciones = cantHabitaciones;
        hotel = new Habitacion[cantHabitaciones];
        for(int i=0;i<cantHabitaciones;i++)
            hotel[i] = new Habitacion();
    }
    
    public Hotel(){
    }

    public Habitacion[] getHotel() {
        return this.hotel;
    }

    public void setHotel(Habitacion[] hotel) {
        this.hotel = hotel;
    }

    public int getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(int cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }
    
    public void ingresarCliente(Persona persona,int habitacion){
        this.hotel[habitacion-1] = new Habitacion();
        this.hotel[habitacion-1].setPersona(persona);
        this.hotel[habitacion-1].setOcupada(true);
    }
    public void aumentarPrecio(double monto){
        for(int i=0;i<this.cantHabitaciones;i++)
            hotel[i].setCostoNoche(hotel[i].getCostoNoche()+ monto);
    }
    public String ToString(int habitacion){
        return "Habitacion "+(habitacion + 1 )+": "+hotel[habitacion].ToString();
    }
}
