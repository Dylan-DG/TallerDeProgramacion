/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto2Club;

/**
 *
 * @author Dylan
 */
public class punto2 {
    public static void main(String[] args){
        
        Jugador jugador=new Jugador("jose",5000,10);
        jugador.setGoles(20);
        jugador.setPartidosJugados(10);
        
        Entrenador entrenador =  new Entrenador("lautaro",10000,5);
        entrenador.setCampeonatosGanados(5);
        
        System.out.println(jugador.toString());
        System.out.println(entrenador.toString());
        
    }
}
