/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class Directorio  {

    /*---------------------------------------------------------------------------------
    *Atributos
    *-----------------------------------------------------------------------------------*/
    private ArrayList<Contacto> contactos;

    /**
     * Raiz del arbol de contactos presentes en el directorio
     */
    private Contacto contactoRaiz;

    /**
     * Nomero de contactos en el directorio
     */
    private int numContactos;

    /*-------------------------------------------------------------------------------------
    *Metodos
    *-------------------------------------------------------------------------------------*/
    
    
    
    /**
     * 
     * @param id
     * @param celular
     * @param nombre
     * @param apellido
     * @param correo
     * @param cedula
     * @param direccion 
     */
    public void agregarContacto(String id, String celular, String nombre, String apellido, String correo, String cedula, String direccion) {
        Contacto c= new Contacto(id, celular, nombre, apellido, correo, cedula,direccion);
        if (contactoRaiz == null) {
            contactoRaiz = c;
        } else {
            insertar(c);
        }
        numContactos++;
        
    }

    
    
    /**
     * 
     * @param nuevo 
     */
    public void insertar(Contacto nuevo){
        Contacto c=new Contacto();
        
        if (c.compareTo(nuevo) == 0) {
            //throw new ContactoRepetidoException(nuevo.nombre);
        }

        if (c.compareTo(nuevo) > 0) {
            // Debe agregar el nuevo contacto por el sub�rbol izquierdo
            if ( c.getIzquierda() == null) {
                c.setIzquierda(nuevo); 
            } else {
                insertar(nuevo);
            }
        } else {
            // Debe agregar el nuevo contacto por el sub�rbol derecho
            if (c.getDerecha() == null) {
                c.setDerecha(nuevo);
            } else {
                insertar(nuevo);
            }
        }
    }

    
    public Contacto buscarContacto(String id) {
       
        return null;
    }

    public void eliminarContacto(String id) {

    }

    public Contacto visualizarDatos() {
        return null;
    }

   
}
