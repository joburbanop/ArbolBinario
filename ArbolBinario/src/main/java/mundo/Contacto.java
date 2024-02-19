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

    private String nombre;

    private String apellido;

    private String correo;

    private String direccion;

    private Contacto izq;

    private Contacto der;
    
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
    
    public Contacto() {
    }

    public Contacto(String id, String celular, String nombre, String apellido, String correo, String direccion) {
        this.id = id;
        this.celular = celular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        izq = null;
        der = null;
    }
    /*
     *@param o es el otro contacto con el que se compara
     * @return -1 si este contacto es menor al otro, 0 si son iguales y 1 si este contacto es mayor al otro
     */
    public int compareTo(Object o) {
        Contacto otro = ( Contacto )o;
        return nombre.compareToIgnoreCase( otro.nombre );
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

    public void insertar (Contacto nuevo){
        if(compareTo(nuevo) > 0){
            // agregar un nuevo contacto en el subarbol izquierdo
            if(izq == null)
                izq = nuevo;
            else 
                izq.insertar(nuevo);
        }
        else{
            // agregar un nuevo contacto en el subarbol derecho
            if(der == null)
                der = nuevo;
            
            else
                der.insertar(nuevo);
        }
            
    }

}
