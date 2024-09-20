package Practicas.Clase1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Punto5 {
    public static void main(String[] args){
        int [][] cali = new int[5][4];
        int [] prom = new int [4];
        
        for(int i=0;i<5;i++){
            System.out.print("<cliente nro: "+ (i+1)+"> ");
            for(int c=0;c<4;c++){
                System.out.print("ingrese la calificacion entre 1 y 10: ");
                cali[i][c]=Lector.leerInt();
                prom[c]=prom[c] +cali[i][c];
            }
        }
        
        for(int i=0;i<5;i++){
            System.out.print("<cliente nro: "+ (i+1)+"> ");
            for(int c=0;c<4;c++){
                System.out.print( cali[i][c]+" | ");
            }
            System.out.println();
        }
        
        System.out.print("<Cal. Promedio:> ");
        for(int i=0;i<4;i++){
            prom[i]=prom[i]/5;
            System.out.print(prom[i]+ " | ");
        }
        
    }
}
