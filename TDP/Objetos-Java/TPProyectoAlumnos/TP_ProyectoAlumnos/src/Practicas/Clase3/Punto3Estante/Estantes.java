/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase3.Punto3Estante;

import tema3.Libro;

public class Estantes {
    private int cantTotalEspacios = 20;
    private Libro[] estante=new Libro[cantTotalEspacios];
    private int cantLibros;
    
    public Estantes(){
        this.cantLibros = 0;
    }
    public Estantes(Libro[] estante, int dimL){
        this.estante = estante;
        this.cantLibros = dimL;
    }
    

    public Libro[] getEstante() {
        return estante;
    }

    public void setEstante(Libro[] estante) {
        this.estante = estante;
    }
    
    public void setCantLibros(int cantLibros){
        this.cantLibros=cantLibros;
    }
    
    public int getCantLibros(){
        return cantLibros;
    }
    
    public boolean EstanteLLeno(){
        if(cantLibros == this.cantTotalEspacios)
            return true;
        else 
            return false;
    }
    
    public void agregarLibro(Libro lib){
        if(cantLibros < this.cantTotalEspacios){
            this.estante[cantLibros] = lib;
            this.cantLibros++;
        }
        else
            System.out.println("no se puede agregar mas libros el estante esta lleno");
    }
    public Libro devolverLibro(String titulo){
        int dimL=0;
        
        while(dimL<this.cantLibros){
            if(estante[dimL].getTitulo().equals(titulo)){
                return estante[dimL];
            }
            dimL++;
        }
        System.out.println("no se encontro el libro buscado");
        return null;
    }
    
}
