package Practicas.Clase1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Punto4 {
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        
        int[][] matriz=new int[8][4];
        int nroPiso,nroOfi;
        
        System.out.print("ingrese el numero de piso: ");
        nroPiso = Lector.leerInt();
        while(nroPiso != 9){
            System.out.print("ingrese el numero de oficina: ");
            nroOfi=Lector.leerInt();
            matriz[nroPiso-1][nroOfi-1]= matriz[nroPiso-1][nroOfi-1] +1;
           
            System.out.print("ingrese el numero de piso: ");
            nroPiso=Lector.leerInt();    
        }
        
        for(int i=7;i>=0;i--){
            for(int j=0;j<4;j++){
                System.out.print(matriz[i][j]+" | ");
            }
            System.out.println();
        }
    }
}
