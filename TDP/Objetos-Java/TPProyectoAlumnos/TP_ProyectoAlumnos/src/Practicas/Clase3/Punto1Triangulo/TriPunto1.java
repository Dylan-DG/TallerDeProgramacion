/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase3.Punto1Triangulo;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class TriPunto1 {
    public static void main(String[] args){
        Triangulo ob = new Triangulo();
        System.out.print("ingrese lado 1: ");   
        ob.setLado1(Lector.leerDouble());
        System.out.print("ingrese lado 2: ");
        ob.setLado2(Lector.leerDouble());
        System.out.print("ingrese lado 3: ");
        ob.setLado3(Lector.leerDouble());
        
        System.out.println("el perimetro del triangulo es: "+ob.calcularPerimetro()+" y el Area es: "+ob.calcularArea());
    }
}
