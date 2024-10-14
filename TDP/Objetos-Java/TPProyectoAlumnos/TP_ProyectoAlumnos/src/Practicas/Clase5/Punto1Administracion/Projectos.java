/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase5.Punto1Administracion;

/**
 *
 * @author Dylan
 */
public class Projectos {
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private int investigadoresAsignados =0;
    private Investigador[] investigadores= new Investigador[50];

    public Projectos(String nombre,String nombreDirector,int codigo){
        this.setNombre(nombre);
        this.setNombreDirector(nombreDirector);
        this.setCodigo(codigo);
        
        for(int i=0;i<50;i++)
            investigadores[i]=new Investigador();
    }
    
    public Projectos(){
        for(int i=0;i<50;i++)
            investigadores[i]=new Investigador();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private int getInvestigadoresAsignados() {
        return investigadoresAsignados;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public Investigador[] getInvestigadores() {
        return investigadores;
    }
    
    public void agregarInvestigador(Investigador unInvestigador){
        if(this.investigadoresAsignados<50){
            investigadores[this.investigadoresAsignados] = unInvestigador;
            this.investigadoresAsignados++;
        }
        else
            System.out.println("ya no quedan lugares para asignar investigadores");
    }
    
    public double dineroTotalOtorgado(){
        int i;
        double total = 0;
        Subsidio[] subsidio = new Subsidio[5];
        
        for(i=0;i<this.getInvestigadoresAsignados();i++){
            subsidio = this.investigadores[i].getSubsidios();
            total+=this.investigadores[i].totalDineroSubsidios();
        }
        return total;
    }
    
    public void otorgarTodos(String nombreCompleto){
        Subsidio[] subsidio = new Subsidio[5];
        boolean ok = true;
        int i = 0;
        
        while(i<this.getInvestigadoresAsignados()&& ok){
            if(this.investigadores[i].getNombreCompleto().equals(nombreCompleto)){
                ok = false;
                subsidio=this.investigadores[i].getSubsidios();
                for(int j=0;j<this.investigadores[i].getCantSubsidiosPedidos();j++){
                    if(subsidio[j].getOtorgado()==false)
                        subsidio[j].setOtorgado(true);
                }
                this.investigadores[i].setSubsidios(subsidio);
            } 
            i++;
        }
    }
    
    public String toString(){
        String to="";
        to+=this.getNombre()+" nombre del Director: "+this.getNombreDirector()+" total de dinero Otorgado: "+this.dineroTotalOtorgado()+"\n";
        
        for(int i=0;i<this.getInvestigadoresAsignados();i++){
            to+=this.investigadores[i].toString()+"\n";            
        }
        
        return to;
    }
}
