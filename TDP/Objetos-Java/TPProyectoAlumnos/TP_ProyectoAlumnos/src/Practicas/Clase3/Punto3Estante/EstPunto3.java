
package Practicas.Clase3.Punto3Estante;

import PaqueteLectura.Lector;
import Practicas.Clase3.Punto2Autor.Autor;
import tema3.Libro;


public class EstPunto3 {
    
    public static void main (String[] args){
        Estantes estante = new Estantes();
        
        Libro libro = new Libro();
        Autor au = new Autor("ale","vive solo","Alaska");
        libro.setTitulo("loki");
        libro.setEditorial("Mcgraw");
        libro.setAñoEdicion(2014);
        libro.setPrimerAutor(au);
        libro.setISBN("978-0071809252");
        libro.setPrecio(21.72);
        estante.agregarLibro(libro);
        
        Libro libro2 = new Libro();
        Autor au2 = new Autor("alejandro","vive solo","Alaska");
        libro2.setTitulo("manolos");
        libro2.setEditorial("Mcgraw-Hill");
        libro2.setAñoEdicion(2014);
        libro2.setPrimerAutor(au2);
        libro2.setISBN("978-0071809252");
        libro2.setPrecio(21.72);
        estante.agregarLibro(libro2);
        
        Libro libro3 = new Libro();
        Autor au3 = new Autor("bolsonaro","vive solo","Alaska");
        libro3.setTitulo("Mujercitas");
        libro3.setEditorial("Mpgul");
        libro3.setAñoEdicion(2014);
        libro3.setPrimerAutor(au3);
        libro3.setISBN("978-0071809252");
        libro3.setPrecio(21.72);
        estante.agregarLibro(libro3);
        
        System.out.println("la cantidad de libro es: "+ estante.getCantLibros());
        Libro L = new Libro(); 
        L = estante.devolverLibro("Mujercita");
        System.out.println("el nombre del autor del libro Mujercitas es: "+ L.getPrimerAutor());
    }
}
