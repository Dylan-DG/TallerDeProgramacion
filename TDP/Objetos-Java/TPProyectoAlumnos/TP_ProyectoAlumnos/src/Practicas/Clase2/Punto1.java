/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Dylan
 */

public class Punto1 {
    public static void main(String[] args){
        System.out.print("ingrese el nombre: ");
        String nombre = Lector.leerString();
        
        System.out.print("ingrese el dni: ");
        int dni = Lector.leerInt();
        
        System.out.print("ingrese la edad: ");
        int edad = Lector.leerInt();
        
        Persona alumno = new Persona(nombre,dni,edad);
        System.out.println(alumno.toString());
    }   
       
}
