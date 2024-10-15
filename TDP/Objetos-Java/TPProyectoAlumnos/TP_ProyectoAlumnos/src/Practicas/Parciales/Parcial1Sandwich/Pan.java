/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial1Sandwich;

/**
 *
 * @author Dylan
 */
public class Pan extends Comida {
    private String calidad;
    
    public Pan(String nombre, double costo, String calidad) {
        super(nombre,costo);
        this.setCalidad(calidad);
    }
    
    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        if(calidad.equals("Premium") || calidad.equals("normal")){
            this.calidad = calidad;
        }
        else
            System.out.println("ingrese una calidad valida (Premium o normal)");
    }
    
    public double costoFinal(){
        double costoFinal;
        
        if(this.getCalidad().equals("Premium")){
            costoFinal = this.getCosto()+ (this.getCosto()*0.20);
        }
        else
            costoFinal = this.getCosto();
        
        return costoFinal;
    }
    public String toString(){
        return "un Pan: "+super.toString()+this.getCalidad();
    } 
}
