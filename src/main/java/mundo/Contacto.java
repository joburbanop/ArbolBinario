/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author jonathan
 */
public class Contacto implements Comparable {

    /*-------------------------------------------------
     * Atributos 
     *--------------------------------------------*/
    private String id;

    private String celular;

    String nombre;

    private String apellido;

    private String correo;

    private String direccion;

    private String cedula;

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

    public Contacto() {
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

    @Override
    public int compareTo(Object o) {
        Contacto otro = (Contacto) o;
        return nombre.compareToIgnoreCase(otro.nombre);
    }

}
