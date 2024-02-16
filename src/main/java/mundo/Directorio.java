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
    
    private ArrayList<Contacto> contactos;
    
    public void agregarContacto( Contacto contacto){
        
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
}
