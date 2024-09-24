package Practicas.Clase2;


import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Punto3 {
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        
        int filas = 0;
        int cupos = 0;
        int cont = 0;
        int columnas =0;
        boolean ok;
        Persona1[][] casting = new Persona1[8][5];
        
        do{
            casting[filas][columnas]= new Persona1();
            
            System.out.print("ingrese un nombre: ");
            casting[filas][columnas].setNombre(Lector.leerString());
            casting[filas][columnas].setDNI(GeneradorAleatorio.generarInt(100000000));
            casting[filas][columnas].setEdad(GeneradorAleatorio.generarInt(100));
            
            if(casting[filas][columnas].getNombre().equals("ZZZ"))
                ok=false;
            else
                ok=true;
            
            if(filas == 8){
                columnas++;
                filas = 0;
            }
            filas++;
            cupos++;
            
        }while(cupos < 40 && ok);
        
        filas =0;
        columnas =0;
        
        while(cont < cupos){
            if(filas ==0)
                System.out.println("dia nro: "+ (columnas +1));
            System.out.println("nombre: "+casting[filas][columnas].getNombre());
            filas++;
            if(filas == 8){
                columnas++;
                filas = 0;
            }
            cont++;
        }
    }
}
