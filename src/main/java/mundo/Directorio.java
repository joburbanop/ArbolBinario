/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author jonathan
 */
public class Directorio {

    /*---------------------------------------------------------------------------------
    *Atributos
    *-----------------------------------------------------------------------------------*/

    
    private ArrayList<Contacto> contactos = new ArrayList<>();

    /**
     * Raiz del arbol de contactos presentes en el directorio
     */
    public static Contacto contactoRaiz = null;

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
        Contacto c = new Contacto(id, celular, nombre, apellido, correo, cedula, direccion);
        
        if (contactoRaiz == null) {
            System.out.println("cabeza");
            System.out.println();
            contactoRaiz = c;
            agregarContacto(c);
        } else {
            System.out.println("ha incertar");
            System.out.println();
            insertar(contactoRaiz, c);
        }
        numContactos++;

    }


    /**
     *
     * @param nuevo
     */
    public void insertar(Contacto actual, Contacto nuevo) {
        if(nuevo.compareTo(actual)==0){
            return;
        }

        //System.out.println("insertar ya estamos ");
        if (nuevo.compareTo(actual) <= 0) {
            // El nuevo contacto es menor o igual que el actual, entonces va al subárbol izquierdo
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(nuevo);
                contactos.add(contactos.indexOf(actual), nuevo);
            } else {
                //System.out.println("menor entonces izquierda "+actual.getIzquierda());
                insertar(actual.getIzquierda(), nuevo);
            }
        } else {

            // El nuevo contacto es mayor que el actual, entonces va al subárbol derecho
            if (actual.getDerecha() == null) {
                //System.out.println("mayor  entonces izquierda "+actual.getIzquierda());
                actual.setDerecha(nuevo);
                contactos.add(contactos.indexOf(actual) + 1, nuevo);
            } else {
                insertar(actual.getDerecha(), nuevo);
            }
        }
    }

    /**
     * Implementacion recursiva para localizar un contacto en el arbol que
     * comienza en este nodo
     *
     * @param actual es el nodo actual
     * @param unNombre nombre que se va a buscar - unNombre != null
     * @return contacto asociado al nombre. Si no lo encuentra retorna null;
     */
    public static Contacto buscar(Contacto actual, String unNombre) {
       
        if (actual == null || actual.getNombre().compareToIgnoreCase(unNombre) == 0) {
            return actual;
        }

        
        if (actual.getNombre().compareToIgnoreCase(unNombre) > 0) {
            return buscar(actual.getIzquierda(), unNombre);

        } 
        else {
            return buscar(actual.getDerecha(), unNombre);
        }
    }

    public void eliminarContacto( String nombre )
    {
        contactoRaiz = contactoRaiz.eliminar( nombre );
        numContactos--;
        
    }

    public Contacto visualizarDatos() {
        return null;
    }

    // Método para agregar un contacto al directorio
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    

    // Método para obtener la lista de contactos
    public ArrayList<Contacto> obtenerContactos() {
        return contactos;
    }

}
