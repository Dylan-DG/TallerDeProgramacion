/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto1Figuras;

/**
 *
 * @author Dylan
 */
public class Punto1 {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(2,2,2,"amarillo","azul");
        System.out.println(triangulo.toString());
        triangulo.despintar();
        System.out.println(triangulo.toString());
        Circulo circulo = new Circulo(12,"celeste","rojo");
        System.out.println(circulo.ToString());
        circulo.despintar();
        System.out.println(circulo.ToString());
    }
}
