/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto1Figuras;

/**
 *
 * @author Dylan
 */
public class Cuadrado extends objetos{
    private int lado;
    
    public Cuadrado(int Lado,String colorLinea,String colorRelleno){
        super(colorLinea, colorRelleno);
        this.setLado(Lado);
    }
    
    public void setLado(int lado){
        this.lado = lado;
    }
    public int getLado(){
        return this.lado;
    }
    
    public double calcularPerimetro(){
        return 12;
    }
    
    public double calcularArea(){
        return 0;
    }
    
    public String ToString(){
        return "lado: "+this.lado + super.toString();
    }
}
