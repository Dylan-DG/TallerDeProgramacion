/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial2;

/**
 *
 * @author Dylan
 */
public class Caja {
    private boolean disponible;
    private Ticket[] tickets;
    private int ticketsMax;
    private int cantTickets;
    
    public Caja(boolean disponible,int maxTickets){
        this.setDisponible(disponible);
        this.setTicketsMax(ticketsMax);
        
        tickets = new Ticket[this.getTicketsMax()];
        for(int i=0;i<this.getTicketsMax();i++){
            tickets[i] =null;
        }
    }
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getTicketsMax() {
        return ticketsMax;
    }

    public void setTicketsMax(int ticketsMax) {
        this.ticketsMax = ticketsMax;
    }
    
    public void agregarTicket(Ticket ticket){
        if(this.cantTickets < this.getTicketsMax()){
            tickets[this.cantTickets] = ticket;
            this.cantTickets++;
        }
        else{
            System.out.println("ya no se pueden agregar mas tickets");
        }
    }
    
    public double LibrosVendidos(){
        double total=0;
        
        for(int i=0;i<this.cantTickets;i++){
            total+=tickets[i].getCantLibrosComprados();
        }
        
        return total;
    }
    
    public Ticket ticketMaxValor(){
        double ticketMaxValor=0;
        Ticket ticketmax = null;
        
        for(int i=0;i<this.cantTickets;i++){
            if(this.tickets[i].getMonto()> ticketMaxValor ){
                ticketMaxValor = this.tickets[i].getMonto();
                ticketmax = this.tickets[i];
            }
        }
        
        return ticketmax;
    }
}
