/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial2;

/**
 *
 * @author Dylan
 */
public class Libreria {
    private String nombre;
    private int numeroVentaActual;
    private Caja cajas[] = new Caja[4];
    
    public Libreria(String nombre,int maxTickets){
        this.setNombre(nombre);
        this.setNumeroVenta(0);
        
        for(int i=0;i<4;i++){
            this.cajas[i] = new Caja(true,maxTickets);
        }
            
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroVentaActual() {
        return numeroVentaActual;
    }

    private void setNumeroVenta(int numeroVenta) {
        this.numeroVentaActual = numeroVenta;
    }
    
    public void generarTicket(int n,int dni,int cantLibros,double montoAbonado,String formaDePago){
        Ticket ticket1 = new Ticket(this.getNumeroVentaActual(),dni,cantLibros,montoAbonado,formaDePago);
        cajas[n].agregarTicket(ticket1);
    }
    
    public void noDisponible(int x){
        for(int i=0;i<4;i++){
            if(cajas[i].LibrosVendidos()<x){
                cajas[i].setDisponible(false);
            }
        }
    }
    
    public Ticket ticketMaxLibreria(){
        Ticket ticketMax = new Ticket(0,0,0,0,"a");
        for(int i=0;i<4;i++){
            if(cajas[i].ticketMaxValor().getMonto()> ticketMax.getMonto()){
                ticketMax = cajas[i].ticketMaxValor();
            }
        }
        return ticketMax;
    }
}
