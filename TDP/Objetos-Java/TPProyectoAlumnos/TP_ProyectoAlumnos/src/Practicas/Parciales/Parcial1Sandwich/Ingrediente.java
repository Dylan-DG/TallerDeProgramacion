/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial1Sandwich;

/**
 *
 * @author Dylan
 */
public class Ingrediente extends Comida{
    private String grupo;

    public Ingrediente(String nombre, double costo, String grupo) {
        super(nombre,costo);
        this.setGrupo(grupo);
    }
    public Ingrediente(){
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        if(grupo.equals("A") || grupo.equals("B")){
            this.grupo = grupo;
        }
        else{
            System.out.println("\n ingrese un grupo valido. (A o B) \n");
        }
    }
    
    public double costoFinal(){
        double costoFinal;
        
        if(this.getGrupo().equals("B")){
            costoFinal = this.getCosto()+ (this.getCosto()*0.10);
        }
        else
            costoFinal = this.getCosto();
        
        return costoFinal;
    }
    public String toString(){
        return "un Ingrediente: "+super.toString()+this.getGrupo();
    } 
}
