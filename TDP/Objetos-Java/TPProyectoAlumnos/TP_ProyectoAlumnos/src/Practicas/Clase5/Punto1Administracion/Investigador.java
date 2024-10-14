/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase5.Punto1Administracion;

/**
 *
 * @author Dylan
 */
public class Investigador {
    private String nombreCompleto;
    private int categoria;
    private String especialidad;
    
    private int cantSubsidiosPedidos;
    private Subsidio[] subsidios =  new Subsidio[5];
    
    public Investigador(String nombreCompleto,int categoria,String especialidad){
        this.setNombreCompleto(nombreCompleto);
        this.setCategoria(categoria);
        this.setEspecialidad(especialidad);
        for(int i=0;i<5;i++)
            subsidios[i] = new Subsidio();
    }
    
    public Investigador(){
        this.setCantSubsidiosPedidos(10);
        for(int i=0;i<5;i++)
            subsidios[i] = new Subsidio();
    }

    public void setCantSubsidiosPedidos(int cantSubsidiosPedidos) {
        this.cantSubsidiosPedidos = cantSubsidiosPedidos;
    }

    public int getCantSubsidiosPedidos() {
        return cantSubsidiosPedidos;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        if(categoria>=1 && categoria<=5)
            this.categoria = categoria;
        else
            System.out.println("esta fuera del rango de categorias");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Subsidio[] getSubsidios() {
        return subsidios;
    }

    public void setSubsidios(Subsidio[] subsidios) {
        this.subsidios = subsidios;
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){      
        if(this.cantSubsidiosPedidos<5){
            subsidios[this.cantSubsidiosPedidos]=unSubsidio;
            this.cantSubsidiosPedidos++;
        }
        else{
            System.out.println("ya no se pueden agregar mas subsidios");
        }
    }
    
    public double totalDineroSubsidios(){
        double total=0;
        for(int i=0;i<5;i++){
            if(this.subsidios[i].getOtorgado()){
                total+=this.subsidios[i].getMontoPedido();
            }
        } 
        return total;
    }
    
    public String toString(){
        return " nombre: "+this.getNombreCompleto()+" categoria: "+this.getCategoria()+" especialidad: "+this.getEspecialidad()+" total de dinero en subsidios: "+this.totalDineroSubsidios();
    }
    
}
