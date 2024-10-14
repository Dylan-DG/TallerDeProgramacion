/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase5.Punto1Administracion;

/**
 *
 * @author Dylan
 */
public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean otorgado = false;
    
    public Subsidio(double montoPedido,String motivo,boolean otorgado){
        this.setMontoPedido(montoPedido);
        this.setMotivo(motivo);
        this.setOtorgado(otorgado);
    }

    public Subsidio(double montoPedido,String motivo){
        this.setMontoPedido(montoPedido);
        this.setMotivo(motivo);        
    }
    
    public Subsidio(){
    }
    
    public double getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(double MontoPedido) {
        this.montoPedido = MontoPedido;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean getOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
}
