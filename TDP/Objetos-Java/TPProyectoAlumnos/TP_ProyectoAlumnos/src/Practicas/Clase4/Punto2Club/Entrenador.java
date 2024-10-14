/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase4.Punto2Club;

/**
 *
 * @author Dylan
 */
public class Entrenador extends Empleado {
    private int campeonatosGanados;

    public Entrenador(String nombre,double sueldo,int antiguedad,int campeonatosGanados){
        super(nombre,sueldo,antiguedad);
        this.setCampeonatosGanados(campeonatosGanados);
    }
    
    public Entrenador(String nombre,double sueldo,int antiguedad){
        super(nombre,sueldo,antiguedad);
    }
    
    
    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }
    
    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public double calcularSueldoACobrar(){
        double sueldo =(this.getSueldoBasico()+(this.getSueldoBasico()*0.10)*this.getAntiguedad());
        if(this.getCampeonatosGanados()>=1 && this.getCampeonatosGanados()<=4)
            sueldo+=5000;
        else{
            if(this.getCampeonatosGanados()>=5 && this.getCampeonatosGanados()<=10)
                    sueldo+=30000;
            else{
                if(this.getCampeonatosGanados()>10) sueldo+=50000;
            }
        }       
        return sueldo;
    }
    
    public double calcularEfectividad(){
        return (this.getCampeonatosGanados()/this.getAntiguedad());
    }
    
    public String toString() {
        return super.toString()+" sueldo a cobrar: "+this.calcularSueldoACobrar()+" -  efectividad: "+this.calcularEfectividad();
    }
}
