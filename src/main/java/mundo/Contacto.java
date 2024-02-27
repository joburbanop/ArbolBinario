/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.io.Serializable;
import java.text.Collator;
import java.util.Collection;
import java.util.Locale;

/**
 *
 * @author jonathan
 */
public class Contacto implements Comparable<Contacto> , Serializable{

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
        public boolean esHoja( )
    {
        return izquierda == null && derecha == null;
    }
            public Contacto darMenor( )
    {
        return ( izquierda == null ) ? this : izquierda.darMenor( );
    }
public Contacto eliminar(String unNombre) {
    Collator collator = Collator.getInstance(new Locale("es", "ES"));

    // Compara los nombres de manera sensible a la localización

    // Elimina los símbolos y las tildes
    nombre = nombre.replaceAll("[^\\p{ASCII}]", "");

    int comparacion = collator.compare(nombre, unNombre);

    if (comparacion == 0) {
        // Si la raíz coincide con el nombre a eliminar
        if (izquierda == null) {
            // Si el hijo izquierdo es nulo, devuelve el hijo derecho como nueva raíz
            return derecha;
        } else if (derecha == null) {
            // Si el hijo derecho es nulo, devuelve el hijo izquierdo como nueva raíz
            return izquierda;
        } else {
            // Si la raíz tiene ambos hijos, encuentra el sucesor en el subárbol derecho
            Contacto sucesor = derecha.darMenor();
            // Actualiza los datos de la raíz con los del sucesor
            nombre = sucesor.getNombre();
            apellido = sucesor.getApellido();
            celular = sucesor.getCelular();
            direccion = sucesor.getDireccion();
            correo = sucesor.getCorreo();
            // Elimina el sucesor del subárbol derecho
            derecha = derecha.eliminar(sucesor.getNombre());
            return this;
        }
    } else if (comparacion > 0) {
        // Si el nombre a eliminar es menor que el nombre de la raíz, busca en el subárbol izquierdo
        if (izquierda != null) {
            izquierda = izquierda.eliminar(unNombre);
        }
    } else {
        // Si el nombre a eliminar es mayor que el nombre de la raíz, busca en el subárbol derecho
        if (derecha != null) {
            derecha = derecha.eliminar(unNombre);
        }
    }
    return this;
}
    
    

}
