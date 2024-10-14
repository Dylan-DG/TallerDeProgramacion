/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto1Figuras;

/**
 *
 * @author Dylan
 */
public class Triangulo extends objetos{
    private int lado1;
    private int lado2;
    private int lado3;
    
    public Triangulo(int lado1,int lado2,int lado3,String colorRelleno,String colorLinea){
        super(colorLinea,colorRelleno);
        this.setLado1(lado1);
        this.setLado2(lado2);
        this.setLado3(lado3);
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }
    
    public double calcularPerimetro(){
        return 12.12;
    }
    
    public double calcularArea(){
        return 12.1;
    }

    public String toString() {
             String i="Triangulo{" + "lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + '}'+ super.ToString();
             return i;
    }
    
    
}
