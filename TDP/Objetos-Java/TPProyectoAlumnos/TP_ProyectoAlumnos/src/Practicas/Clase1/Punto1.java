/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Practicas.Clase1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class Punto1 {
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        int i,num;
        int DF=11;  
        int [] tabla2 = new int[DF]; // indices de 0 a 10
 
        for (i=0;i<DF;i++) 
            tabla2[i]=2*i;
        
        num=GeneradorAleatorio.generarInt(12);
        while(num !=11){
            System.out.println("2x"+num+"="+tabla2[num]);
            num=GeneradorAleatorio.generarInt(12);
        }
    }
}
