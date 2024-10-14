/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto3Seguridad;

import tema2.Persona;

public class Trabajador extends Persona{
    private String trabajo;
    
    public Trabajador(String nombre,int dni,int edad,String trabajo){
        super(nombre,dni,edad);
        this.setTrabajo(trabajo);
    }
    public Trabajador(){}
    
    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
    
    public String toString(){
        return super.toString()+". Soy "+this.getTrabajo();
    }
}
