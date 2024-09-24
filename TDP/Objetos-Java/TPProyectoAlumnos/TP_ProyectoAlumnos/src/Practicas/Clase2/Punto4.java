/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase2;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class Punto4 {
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        
        int filas = 0;
        int cupos = 0;
        int columnas =0;
        
        int dni,edad;
        String nombre;
        
        int[] turnos = new int[5];
        boolean ok = true;
        Persona[][] casting = new Persona[8][5];
        
        do{
            System.out.print("ingrese un nombre: ");
            nombre = Lector.leerString();
            
            if(nombre.equals("ZZZ")){
                ok=false;
            }
            else{
                ok=true;
                
                dni = GeneradorAleatorio.generarInt(100000000);
                edad = GeneradorAleatorio.generarInt(100);
                System.out.print("ingrese el dia en que se quiere presentar: ");
                columnas = Lector.leerInt();
                columnas--;
            
                if(turnos[columnas]< 8){
                    casting[turnos[columnas]][columnas]= new Persona();
                    casting[turnos[columnas]][columnas].setNombre(nombre);
                    casting[turnos[columnas]][columnas].setDNI(dni);
                    casting[turnos[columnas]][columnas].setEdad(edad);
                
                    turnos[columnas]++;
                    cupos++;
                }
                else{
                    System.out.println("no hay turno disponible en ese dia");
                }
            }
         
        }while(cupos < 40 && ok);
        
        for(int i=0;i<5;i++){
            System.out.println("en el dia "+ (i+1) +" hay "+ turnos[i]+" inscriptos");
            
            for(int j = 0;j<turnos[i];j++){
                System.out.println("nombre: "+ casting[j][i].getNombre());
            }
        }
    }
}
