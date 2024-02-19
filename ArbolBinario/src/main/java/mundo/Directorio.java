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
public class Directorio {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ra�z del �rbol de contactos presentes en el directorio
     */
    
    private Contacto contactoRaiz;
    
    /**
     * N�mero de contactos en el directorio
     */
    private int numContactos;
    
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

        public Directorio( )
    {
        contactoRaiz = null;
        numContactos = 0;
    }
        
    private ArrayList<Contacto> contactos;
    
    public void agregarContacto( String nombre,String id, String celular, String apellido, String correo , String direccion){
     
        Contacto c = new Contacto(nombre, apellido,id,celular,correo,direccion);
                if( contactoRaiz == null )
            contactoRaiz = c;
        else
            contactoRaiz.insertar( c );
        numContactos++;
    }
    
    public Contacto buscarContacto( String id){
        for (Contacto con: contactos){
            if(con.getId()==  id){
                
                return con;
            }
        }
        return null;
    }
    
    public void eliminarContacto(String id){
        
    }
    
    public Contacto visualizarDatos(){
        return null;
    }

    public void agregarContacto(Contacto contacto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
