/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial2;

/**
 *
 * @author Dylan
 */
public class Libreria {
    private String nombre;
    private int numeroVentaActual;
    private Caja cajas[] = new Caja[4];
    
    public Libreria(String nombre,int maxTickets){
        this.setNombre(nombre);
        this.setNumeroVenta(0);
        
        for(int i=0;i<4;i++){
            this.cajas[i] = new Caja(true,maxTickets);
        }
            
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroVentaActual() {
        return numeroVentaActual;
    }

    private void setNumeroVenta(int numeroVenta) {
        this.numeroVentaActual = numeroVenta;
    }
    
}
