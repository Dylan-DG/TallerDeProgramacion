/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial1Sandwich;

/**
 *
 * @author Dylan
 */
public class Sandwich {
    private String nombre;
    private Pan pan;
    private Ingrediente[] ingredientes;
    private int ingredientesMax;
    private int cantIngredientes;
    
    public Sandwich(String nombre,Pan pan,int ingredientesMax){
        this.setNombre(nombre);
        this.setPan(pan);
        this.setIngredientesMax(ingredientesMax);
        this.inicializarSandwich();
    }
    
    private int getIngredientesMax() {
        return ingredientesMax;
    }

    private void setIngredientesMax(int ingredientesMax) {
        this.ingredientesMax = ingredientesMax;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public int getCantIngredientes() {
        return cantIngredientes;
    }
        
    
    private void inicializarSandwich(){
        ingredientes = new Ingrediente[this.ingredientesMax];
        for(int i=0;i<this.getIngredientesMax();i++){
            ingredientes[i]= null;
        }
    }
    
    public void agregarIngrediente(Ingrediente unIngrediente){
        if(this.getCantIngredientes()<this.getIngredientesMax()){
            ingredientes[this.cantIngredientes]= unIngrediente;
            this.cantIngredientes++;
        }
        else{
            System.out.println("ya no hay mas espacio para ingredientes.");
        }
    }
    
    public double costoTotalSandwich(){
        double costoTodo =0;
        costoTodo+= this.getPan().costoFinal();
        
        for(int i=0;i<this.getCantIngredientes();i++){
            costoTodo+=this.ingredientes[i].costoFinal();
        }
        return costoTodo;
    }
    
    public String toString(){
        String representacion = this.getNombre()+"\n"+this.getPan().toString()+"\n"+"cantidad de ingredientes: "+this.getCantIngredientes()+"\n";
        
        for(int i=0;i<this.cantIngredientes;i++){
            representacion+= this.ingredientes[i].toString()+"\n";
        }
        representacion+=" costo Final del Sandwich: "+this.costoTotalSandwich();
        return representacion;
    }
}
