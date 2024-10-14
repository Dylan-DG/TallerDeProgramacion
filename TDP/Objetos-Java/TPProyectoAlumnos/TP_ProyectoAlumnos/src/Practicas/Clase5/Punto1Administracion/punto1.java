/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practicas.Clase5.Punto1Administracion;

/**
 *
 * @author Dylan
 */
public class punto1 {
    public static void main (String[] args){
        Projectos projecto = new Projectos("alu","manuel Adorni",123111145);
    
        Investigador investigador1=new Investigador("Raul Ramirez",2,"ingenieria Mecanica");
        Investigador investigador2=new Investigador("luis Ez",1,"ingenireia Aeronautica");
        Investigador investigador3=new Investigador("lucas Tielmo",5,"limpia vidrios");
        
        Subsidio subsidio = new Subsidio(20.5,"quiero plata");
        Subsidio subsidio2 =new Subsidio(10.23,"quiero mas plata");
        
        Subsidio subsidio5 = new Subsidio(20.5,"quiero plata");
        Subsidio subsidio6 =new Subsidio(10.23,"quiero mas plata");
        
        Subsidio subsidio3 = new Subsidio(20.5,"quiero plata");
        Subsidio subsidio4 =new Subsidio(10.23,"quiero mas plata");
        
        investigador1.agregarSubsidio(subsidio);
        investigador1.agregarSubsidio(subsidio2);
        
        investigador2.agregarSubsidio(subsidio3);
        investigador2.agregarSubsidio(subsidio4);
        
        investigador3.agregarSubsidio(subsidio5);
        investigador3.agregarSubsidio(subsidio6);
        
        projecto.agregarInvestigador(investigador1);
        projecto.agregarInvestigador(investigador2);
        projecto.agregarInvestigador(investigador3);
        
        projecto.otorgarTodos("lucas Tielmo");   
        projecto.otorgarTodos("Raul Ramirez"); 
        System.out.println(projecto.toString());

    }
    
}
