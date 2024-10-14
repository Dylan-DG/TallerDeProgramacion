/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase5.Punto2Estacionamientos;

/**
 *
 * @author Dylan
 */
public class Auto {
    private String nombreDueño;
    private int patente;
    
    public Auto(String nombreDueño,int patente){
        this.setNombreDueño(nombreDueño);
        this.setPatente(patente);
    }
    public Auto(){
    }
    
    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }
    
    public String toString(){
        return "nombre del dueño: "+this.getNombreDueño()+" patente: "+this.getPatente();
    }
}
