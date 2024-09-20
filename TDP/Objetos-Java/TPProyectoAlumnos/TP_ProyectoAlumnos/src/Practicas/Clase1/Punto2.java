/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Punto2 {
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        int cant=0;
        double prom=0;
        int dimF = 15;
        double[] vector=new double[dimF];
        
        for(int i=0;i<dimF;i++){
            vector[i]= Lector.leerDouble();
            prom=prom + vector[i];
        }
        prom =(double) prom / dimF;
        System.out.println("el promedio de alturas es: "+prom);
        
        for(int j=0;j<dimF;j++){
            if(vector[j]>prom)
                cant++;
        }
        System.out.println("la cantidad de jugadores con altura mayor al promedio es: "+cant);
    }
}
