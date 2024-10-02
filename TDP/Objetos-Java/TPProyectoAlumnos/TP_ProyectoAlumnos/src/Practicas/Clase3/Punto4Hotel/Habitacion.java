/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase3.Punto4Hotel;

import tema2.Persona;
import PaqueteLectura.GeneradorAleatorio;

public class Habitacion {
    private double costoNoche;
    private boolean ocupada = false;
    private Persona persona =new Persona();

    
    public Habitacion(){
        this.costoNoche = GeneradorAleatorio.generarDouble(6001)+2000;
    }
    
    public double getCostoNoche() {
        return costoNoche;
    }
    
    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public String ToString(){
        String to = "Costo: "+ this.getCostoNoche()+" , "+this.getOcupada();
        if(this.getOcupada() == false)
            return to;
        else
            to+=" ,"+persona.toString();
        return to;  
    }
    
}
