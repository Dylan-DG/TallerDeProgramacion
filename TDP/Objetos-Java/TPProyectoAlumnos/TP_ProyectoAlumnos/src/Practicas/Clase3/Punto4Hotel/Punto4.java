/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase3.Punto4Hotel;

import tema2.Persona;
import PaqueteLectura.Lector;

public class Punto4 {
    public static void main(String[] args){
            Hotel hotel = new Hotel(2);
            Persona persona = new Persona();
               
            System.out.print("ingrese su nombre: ");
            persona.setNombre(Lector.leerString());
            System.out.print("ingrese su dni: ");
            persona.setDNI(Lector.leerInt());
            System.out.print("ingrese su edad: ");
            persona.setEdad(Lector.leerInt());
                
            hotel.ingresarCliente(persona, 2);
       
            
            for(int i=0;i<2;i++){
                System.out.println(hotel.ToString(i));
            }
            
            System.out.print("ingrese un monot a aumentar: ");
            hotel.aumentarPrecio(Lector.leerDouble()); 
            
            for(int i=0;i<2;i++){
                System.out.println(hotel.ToString(i));
            }
    }
}
