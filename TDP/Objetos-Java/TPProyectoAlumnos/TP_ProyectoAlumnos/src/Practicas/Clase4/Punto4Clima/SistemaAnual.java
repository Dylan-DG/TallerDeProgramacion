/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto4Clima;

/**
 *
 * @author Dylan
 */
public class SistemaAnual extends Sistema{
    
    public SistemaAnual(Estacion estacion,int añoInicial,int cantAños){
        super(estacion,añoInicial,cantAños);
        
    }
    
    public String promedioTemperaturas(){
        double promTemp;
        String promediosAnuales= ""+this.getEstacion();
        
        for(int i=0;i<this.getCantAños();i++){
            promTemp = 0;
            for(int j=0;j<12;j++){
                promTemp+= this.getTemperatura(j+1,i+this.getAñoInicial());
            }
            promediosAnuales+="año "+(i+this.getAñoInicial())+": "+(promTemp/this.getCantAños())+"°C;\n";
        } 
        return promediosAnuales;
    }
    
}
