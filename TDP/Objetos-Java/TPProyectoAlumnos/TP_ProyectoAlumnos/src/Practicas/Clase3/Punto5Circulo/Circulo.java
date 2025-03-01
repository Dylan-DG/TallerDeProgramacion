/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase3.Punto5Circulo;

/**
 *
 * @author Dylan
 */
public class Circulo {
    private double radio;
    private String colorRelleno;
    private String colorLinea;

    public Circulo(double radio,String colorRelleno,String colorLinea){
        this.radio = radio;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }
    
    public Circulo(){
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

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
    
    public double calcularArea(){
        return this.radio*Math.PI;
    }
    
    public double calcularPerimetro(){
        return (2*Math.PI*this.radio);
    }
}
