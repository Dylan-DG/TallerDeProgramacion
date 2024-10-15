/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial1Sandwich;

/**
 *
 * @author Dylan
 */
public abstract class Comida {
    private String nombre;
    private double costo;
    
    public Comida(String nombre,double costo){
        this.setCosto(costo);
        this.setNombre(nombre);
    }
    public Comida(){}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public abstract double costoFinal();
    
    public String toString(){
        return this.getNombre()+" - "+this.getCosto()+" - ";
    }
}
