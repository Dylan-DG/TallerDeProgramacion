/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto4Clima;




public abstract class  Sistema {
    private Estacion estacion;
    private int añoInicial;
    private int cantAños;
    private double[][] temperatura;
    
    public Sistema(Estacion estacion,int añoInicial,int cantAños){
        this.setEstacion(estacion);
        this.setAñoInicial(añoInicial);
        this.setCantAños(cantAños);
        
        temperatura = new double[12][cantAños];
        for(int i=0;i<cantAños;i++){
            for(int j=0;j<12;j++){
                temperatura[j][i] = 100;
            }
        }
    }
    
    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public int getAñoInicial() {
        return añoInicial;
    }

    public void setAñoInicial(int AñoInicial) {
        this.añoInicial = AñoInicial;
    }

    public int getCantAños() {
        return cantAños;
    }

    public void setCantAños(int cantAños) {
        this.cantAños = cantAños;
    }
    
    public void setTemperatura(int mes,int año,double temp){
        if(this.verificaRango(mes, año))
            temperatura[mes-1][año-this.añoInicial]=temp;
    }
    
    public double getTemperatura(int mes,int año){
        double temp;
        if(this.verificaRango(mes, año))
            temp = temperatura[mes-1][año-this.añoInicial];
        else
            temp = 1000;
        
        return temp;
    }
    
    private boolean verificaRango(int mes,int año){
        boolean ok; 
        if(año>=añoInicial && año<=añoInicial+(cantAños-1)){
            if(mes>=1 && mes<=12)
                ok=true;
            else{
                ok = false;
                System.out.println("el mes esta fuera de rango");
            }
        }
        else{
            ok=false;
            System.out.println("el anio esta fuera de rango");
        }
        return ok;
    }
    
    public String mayorTemperatura(){
        double tempMax = 1;
        int añoMax = 0;
        int mesMax = 0;
        
        for(int i=0;i<this.cantAños;i++){
            for(int j=0;j<12;j++){
                if(temperatura[j][i]>tempMax){
                    mesMax=j;
                    añoMax=i;
                    tempMax = temperatura[j][i];
                }
            }
        }
        
        return "mes: "+mesMax+" año: "+añoMax+" temperatura mas alta: "+tempMax;
    }
    
    public abstract String promedioTemperaturas();
    
    public String toString(){        
        return "";
    }
}
