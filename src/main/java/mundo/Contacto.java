/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 *
 * @author jonathan
 */
public class Contacto implements Comparable<Contacto>, Serializable {

    /*-------------------------------------------------
     * Atributos 
     *--------------------------------------------*/
    private String id;

    private String celular;

    private String nombre;

    private String apellido;

    private String correo;

    private String direccion;

    private String cedula;

    //private static Contacto instancia = null;
    /**
     * Sub�rbol izquierdo de contactos
     */
    private Contacto izquierda;

    /**
     * Sub�rbol derecho de contactos
     */
    private Contacto derecha;

    /*------------------------------------------------------
     * Metodos
     *-----------------------------------------------------*/
 /* *
     * constructor de la clase Contacto.
     * @param id
     * @param celular
     * @param nombre
     * @param apellido
     * @param correo
     * @param direccion 
     */
    public Contacto(String id, String celular, String nombre, String apellido, String correo, String cedula, String direccion) {
        this.cedula = cedula;
        this.id = id;
        this.celular = celular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Contacto() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Contacto getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Contacto izquierda) {
        this.izquierda = izquierda;
    }

    public Contacto getDerecha() {
        return derecha;
    }

    public void setDerecha(Contacto derecha) {
        this.derecha = derecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Compara este contacto con otro
     *
     * @param o o es el otro contacto con el que se compara
     * @return -1 si este contacto es menor al otro, 0 si son iguales y 1 si
     * este contacto es mayor al otro
     */
    @Override
    public int compareTo(Contacto o) {
        Contacto otro = (Contacto) o;
        //System.out.println("haber");
        //System.out.println(this.nombre.compareToIgnoreCase(otro.getNombre()));
        return this.nombre.compareToIgnoreCase(otro.getNombre());
    }

    public boolean esHoja() {
        return izquierda == null && derecha == null;
    }

    public Contacto darMenor() {
        return (izquierda == null) ? this : izquierda.darMenor();
    }

    /**
     * Elimina un contacto del �rbol que comienza en este nodo.
     *
     * @param unNombre nombre del contacto que se va a eliminar - hay un
     * contacto en el �rbol que se llama unNombre
     * @return el �rbol de contactos despu�s de eliminar el contacto indicado
     */
    public Contacto eliminar(String unNombre) {
        if (esHoja()) // Tiene que ser el elemento que estamos buscando
        {
            return null;
        }
        if (nombre.compareToIgnoreCase(unNombre) == 0) {
            ArrayList<Contacto> conEliminar = Directorio.obtenerContactos();

            conEliminar.removeIf(elemento -> elemento.equals(unNombre));
            
            if (izquierda == null) {
                return derecha;
            }
            if (derecha == null) {
                return izquierda;
            }
            // Localiza el menor contacto del sub�rbol derecho
            Contacto sucesor = derecha.darMenor();
            // Elimina del sub�rbol derecho el elemento que acaba de localizar
            derecha = derecha.eliminar(sucesor.getNombre());
            // Deja el elemento localizado en la ra�z del �rbol de respuesta
            sucesor.izquierda = izquierda;
            sucesor.derecha = derecha;

            return sucesor;
        } else if (nombre.compareToIgnoreCase(unNombre) > 0) {
            izquierda = izquierda.eliminar(unNombre);
        } else {
            derecha = derecha.eliminar(unNombre);
        }
        return this;
    }

}
