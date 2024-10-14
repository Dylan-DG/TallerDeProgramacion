/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase5.Punto2Estacionamientos;

/**
 *
 * @author Dylan
 */
public class Estacionamiento {
    private String nombre;
    private int direccion;
    private int horaApertura;
    private int horaCierre;
    private Auto[][] autos;
    private int cantPisos;
    private int cantPlazas;
    
    public Estacionamiento(String nombre,int direccion,int horaApertura,int horaCierre,int cantPisos,int cantPlazas){
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setHoraApertura(horaApertura);
        this.setHoraCierre(horaCierre);
        this.setCantPisos(cantPisos);
        this.setCantPlazas(cantPlazas);
        this.inicializarAutos();
    }  
    public Estacionamiento(String nombre,int direccion){
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setHoraApertura(8);
        this.setHoraCierre(21);
        this.setCantPisos(5);
        this.setCantPlazas(10);
        this.inicializarAutos();
    }
    public Estacionamiento(int cantPisos,int cantPlazas){
        this.setCantPisos(cantPisos);
        this.setCantPlazas(cantPlazas);
        this.inicializarAutos();
    }

    public int getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }

    public int getCantPlazas() {
        return cantPlazas;
    }

    public void setCantPlazas(int cantPlazas) {
        this.cantPlazas = cantPlazas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public int getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Auto[][] getAutos() {
        return autos;
    }
    
    private void inicializarAutos(){
        autos=new Auto[this.cantPisos][this.cantPlazas];
        for(int i=0;i<this.cantPisos;i++){
            for(int j=0;j<this.cantPlazas;j++){
                autos[i][j] = null;
            }
        }  
    }
    
    public void setAuto(Auto auto,int x,int y){
        autos[x-1][y-1] = auto;
    }
    
    public String buscarAuto(int patente){
        String datos="Auto inexistente";
        int i=0;
        int j=0;
        boolean ok = false;
        
        while(i<this.cantPisos && ok == false){
            while(j<this.cantPlazas && ok == false){
                if(autos[i][j].getPatente() == patente){
                    ok = true;
                    datos= "numero piso: "+i+" numero de plaza: "+j;
                }
            }
        }
        return datos;
    }
    
    public int getAutosPlaza(int y){
        int cant =0;
        for(int i=0;i<this.cantPisos;i++){
            if(this.autos[i][y-1] != null){
                cant++;
            }
        }
        return cant;
    }
    
    public String toString(){
        String string="";
        for(int i=0;i<this.cantPisos;i++){
            for(int j=0;j<this.cantPlazas;j++){
                if(this.autos[i][j] != null){
                    string+="piso "+i+" Plaza "+j+ ": "+this.autos[i][j].toString()+"\n";
                }
                else{
                    string+="piso "+i+" Plaza "+j+ ": libre \n";
                }
            }
        }     
        
        return string;
    }
}
