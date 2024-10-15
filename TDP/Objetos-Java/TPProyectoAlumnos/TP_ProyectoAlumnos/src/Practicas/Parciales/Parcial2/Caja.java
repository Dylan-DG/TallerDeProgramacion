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
    
    
}
