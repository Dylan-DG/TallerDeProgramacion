/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase3.Punto1Triangulo;

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    
    public Triangulo(double lado1,double lado2,double lado3,String colorRelleno,String colorLinea ){
        this.lado1=lado1;
        this.lado2=lado2;
        this.lado3=lado3;
        this.colorRelleno=colorRelleno;
        this.colorLinea=colorLinea;
    }
    public Triangulo(){
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
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
    
    public double calcularPerimetro(){
        return this.lado1 + this.lado2 + this.lado3;
    }
    
    public double calcularArea(){
        double S=(this.calcularPerimetro())/2;
        return Math.sqrt(S*(S -this.lado1)*(S -this.lado3)*(S-this.lado3));
    }

    public String toString() {
        return "Triangulo{" + "lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + ", colorRelleno=" + colorRelleno + ", colorLinea=" + colorLinea + '}';
    }
}
