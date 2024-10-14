/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto4Clima;

/**
 *
 * @author Dylan
 */
public class SistemaMensual extends Sistema{
    private String[] meses = new String[]{"Enero", "Febrero", "Marzo",
        "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre"};    
    
    public SistemaMensual(Estacion estacion,int añoInicial,int cantAños){
        super(estacion,añoInicial,cantAños);      
    }    
    
    public String promedioTemperaturas(){
        double promTemp;
        String promediosMensuales = ""+this.getEstacion();
        
        for(int i=0;i<12;i++){
            promTemp = 0;
            for(int j=0;j<this.getCantAños();j++){
                promTemp+= this.getTemperatura(i+1,j+this.getAñoInicial());
            }
            promediosMensuales+="- "+(meses[i])+": "+(promTemp/this.getCantAños())+"°C;\n";
        } 
        return promediosMensuales;
    }
}
