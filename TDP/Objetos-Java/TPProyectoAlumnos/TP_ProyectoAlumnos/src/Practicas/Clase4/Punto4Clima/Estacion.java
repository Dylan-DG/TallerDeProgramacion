/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto4Clima;

/**
 *
 * @author Dylan
 */
public class Estacion {
    private String nombre;
    private int latitud;
    private int longitud;
    
    public Estacion(String nombre,int latitud,int longitud){
        this.setNombre(nombre);
        this.setLatitud(latitud);
        this.setLongitud(longitud);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    public String toString(){
        return nombre+"("+latitud+" - "+longitud+"):";
    }
}
