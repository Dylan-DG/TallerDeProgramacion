/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto2Club;

/**
 *
 * @author Dylan
 */
public class Jugador extends Empleado{
    private int PartidosJugados;
    private int goles;

    public Jugador(String nombre,double sueldoBasico, int antiguedad,int PartidosJugados,int goles){
        super(nombre,sueldoBasico,antiguedad);
        this.setPartidosJugados(PartidosJugados);
        this.setGoles(goles);
    }
    public Jugador(String nombre,double sueldo,int antiguedad){
        super(nombre,sueldo,antiguedad);
    }
    
    public int getPartidosJugados() {
        return PartidosJugados;
    }

    public void setPartidosJugados(int PartidosJugados) {
        this.PartidosJugados = PartidosJugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    public double calcularSueldoACobrar(){
        double sueldo = (this.getSueldoBasico()+(this.getSueldoBasico()*0.10)*this.getAntiguedad());
        if(this.getGoles()/this.getPartidosJugados()> 0.5){
            sueldo+=this.getSueldoBasico();
        }
        return sueldo;
    }
    
    public double calcularEfectividad(){
        return (this.getGoles()/this.getPartidosJugados());
    }
    
    public String toString() {
        return super.toString()+" sueldo a cobrar: "+this.calcularSueldoACobrar()+" -  efectividad: "+this.calcularEfectividad();
    }
}
