/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Parciales.Parcial2;

/**
 *
 * @author Dylan
 */
public class Ticket {
    private int numero;
    private int dniCliente;
    private int cantLibrosComprados;
    private double monto;
    private String medioDePago;

    public Ticket(int numero, int dniCliente, int cantLibrosComprados, double monto, String medioDePago) {
        this.setNumero(numero);
        this.setDniCliente(dniCliente);
        this.setMedioDePago(medioDePago);
        this.setCantLibrosComprados(cantLibrosComprados);
        this.setMonto(monto);
    }
    public Ticket(){}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getCantLibrosComprados() {
        return cantLibrosComprados;
    }

    public void setCantLibrosComprados(int cantLibrosComprados) {
        this.cantLibrosComprados = cantLibrosComprados;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        if(medioDePago.equals("debito")||medioDePago.equals("credito")||medioDePago.equals("efectivo")){
            this.medioDePago = medioDePago;
        }
        else{
            System.out.println("medio de pago no valido");
        }
    }
    
    
}
