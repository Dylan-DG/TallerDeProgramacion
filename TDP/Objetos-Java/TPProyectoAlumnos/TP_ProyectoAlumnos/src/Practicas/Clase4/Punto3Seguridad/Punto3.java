/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto3Seguridad;

import tema2.Persona;

public class Punto3 {
    public static void main(String[] args){
        Persona persona = new Persona("dylan",47254898,18);
        Trabajador trabajador = new Trabajador("alex",478393289,23,"limpia vidrios");
        System.out.println(persona.toString());
        System.out.println(trabajador.toString());
    }   
    
}
