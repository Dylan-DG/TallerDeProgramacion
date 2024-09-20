/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Punto3 {
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        
        int suma=0;
        int [] vec = new int[5];
        
        int[][] matriz = new int[5][5];
        for(int i=0;i<5;i++){
            System.out.print("<fila: "+i+ "> " );
            for(int f =0;f<5;f++){
                matriz[i][f]=GeneradorAleatorio.generarInt(31);
                System.out.print(matriz[i][f]+" | ");
            }    
            System.out.println();
        }
        
        for(int j=0;j<5;j++){
            suma=suma + matriz[1][j];
        }
        
        System.out.print("<sumas: > ");
        for(int j=0;j<5;j++){
            suma=0;
            for(int i=0;i<5;i++){
                suma=suma+matriz[i][j];
            }
            vec[j]= suma;
            System.out.print(vec[j]+" | ");
        }
        
        int num= Lector.leerInt();
        boolean ok=false;
        int c=0;
        int d=0;
        
        for(int j=0;j<5;j++){
            for(int a=0;a<5;a++){
                if(num == matriz[j][a]){
                    ok=true;
                    c=j;
                    d=a;
                }
            }
        }
        if(ok == true){
            System.out.println("fila: "+ c +" columna: "+ d);
        }
        else{
            System.out.println("No se encontró el elemento ");
        }
    }
}
