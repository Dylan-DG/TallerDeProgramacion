/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase5.Punto2Estacionamientos;

import PaqueteLectura.GeneradorAleatorio;

public class Punto2 {
    public static void main(String[] args){
        Estacionamiento estacionamiento = new Estacionamiento("Lanu",223,7,14,3,3);
        
        Auto auto1 = new Auto("antonio",1212);
        Auto auto2 = new Auto("Luis",GeneradorAleatorio.generarInt(10000));
        Auto auto3 = new Auto("Rafa",GeneradorAleatorio.generarInt(10000));
        Auto auto4 = new Auto("lautaro",GeneradorAleatorio.generarInt(10000));
        Auto auto5 = new Auto("diego",GeneradorAleatorio.generarInt(10000));
        Auto auto6 = new Auto("dylan",GeneradorAleatorio.generarInt(10000));
        
        estacionamiento.setAuto(auto1, 1, 1);
        estacionamiento.setAuto(auto2, 1, 2);
        estacionamiento.setAuto(auto3, 1, 3);
        estacionamiento.setAuto(auto4, 2, 3);
        estacionamiento.setAuto(auto5, 2, 3);
        estacionamiento.setAuto(auto6, 2, 1);
        
        System.out.println(estacionamiento.toString());
        System.out.println(estacionamiento.getAutosPlaza(1));
        System.out.println(estacionamiento.buscarAuto(1212));
    }
}
