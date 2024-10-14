/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto1Figuras;

/**
 *
 * @author Dylan
 */
public class Circulo extends objetos{
    private double radio;
    
    public Circulo(double radio,String colorLinea,String colorRelleno){
        super(colorLinea, colorRelleno);
        this.setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double calcularArea(){
        return 0;// completar formulas
    }
    
    public double calcularPerimetro(){
        return 0; //completar Formulas
    
    }
    
   public String ToString(){
       return "radio: "+this.getRadio() + super.ToString();
   }
}
