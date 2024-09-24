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


public class Punto2 {
    
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        
        String name;
        int dni;
        int edad;
        int dimL=0;
        int cantMayor65=0;
        int minDni = 999999999;
        int indicador =0;
        Persona1[] vector= new Persona1[15];
        
        name = GeneradorAleatorio.generarString(10);
        dni = GeneradorAleatorio.generarInt(10000000);
        edad = GeneradorAleatorio.generarInt(100);  
        while(edad!=0 && dimL<15) //Carga la informacion de las personas
        {
            vector[dimL] = new Persona1(name,dni,edad);
            name = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(10000000);
            edad = GeneradorAleatorio.generarInt(100);
            dimL++;
        }
        
        for(int i=0;i<dimL;i++) //Imprime la info de las personas y recopila datos
        {
            System.out.println(vector[i].toString());
            if(vector[i].getEdad()> 65)
                cantMayor65++;
            if(vector[i].getDNI()< minDni){
                indicador = i;
                minDni = vector[i].getDNI();
            }
        }
        System.out.println("la cantidad de personas con una edad mayor a 65 es: "+ cantMayor65);
        System.out.println(vector[indicador].toString());
    
    }   
}
