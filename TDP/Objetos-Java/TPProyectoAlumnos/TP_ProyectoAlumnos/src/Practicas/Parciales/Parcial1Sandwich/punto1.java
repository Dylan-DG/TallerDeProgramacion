/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial1Sandwich;

/**
 *
 * @author Dylan
 */
public class punto1 {
    public static void main(String[] args){
        Pan pan = new Pan("Pan De Papa",50.0,"Premium");
        Sandwich sandwich = new Sandwich("Napolitana",pan,3);
        Ingrediente ingrediente1 = new Ingrediente("queso",10,"A");
        Ingrediente ingrediente2 = new Ingrediente("lechuga",15,"B");
        Ingrediente ingrediente3 = new Ingrediente("tomate",25,"A");
        
        sandwich.agregarIngrediente(ingrediente1);
        sandwich.agregarIngrediente(ingrediente2);
        sandwich.agregarIngrediente(ingrediente3);
        
        System.out.println(sandwich.toString());
    }       
}
