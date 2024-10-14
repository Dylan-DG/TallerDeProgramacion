/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto1Figuras;

/**
 *
 * @author Dylan
 */
public abstract class objetos {
    private String colorRelleno;
    private String colorLinea;
    
    public objetos(String colorLinea,String colorRelleno){
        setColorLinea(colorLinea);
        setColorRelleno(colorRelleno);
    }
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
    
    public void despintar(){
        this.setColorLinea("negro");
        this.setColorRelleno("blanco");
    };
 
    public String getColorRelleno() {
        return colorRelleno;
    }
    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public String ToString(){
        return " color de Relleno: "+this.getColorRelleno()+" color de Linea: "+this.getColorLinea();
    }
}
