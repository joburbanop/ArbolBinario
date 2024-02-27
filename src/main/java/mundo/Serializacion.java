/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.servlet.ServletContext;
import mundo.Directorio;
/**
 *
 * @author sofi
 */
public class Serializacion {
    
    public static void escribirArchivoContactos(Directorio listaContactos, ServletContext context) throws FileNotFoundException, IOException {
        // cambiarlo
        String rutaRelativa = "/data/contactosAgregados.ser";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

        try (FileOutputStream fos = new FileOutputStream(archivo); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // cambiar
            oos.writeObject(listaContactos);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de datos.");
        }
    }

    public static Directorio leerArchivoContactos(ServletContext context) throws IOException, ClassNotFoundException {
        Directorio listaContactos = new Directorio();
      
        String rutaRelativa = "/data/contactosAgregados.ser";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

        if (archivo.exists() && archivo.isFile()) {
            try (FileInputStream fis = new FileInputStream(archivo); ObjectInputStream ois = new ObjectInputStream(fis)) {
              
                listaContactos = (Directorio) ois.readObject();
            } catch (EOFException e) {
                
                System.out.println("El archivo de datos está vacío.");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo de datos.");
            }
        } else {
            System.out.println("El archivo de datos no existe.");
        }
        System.out.println(listaContactos);
        return listaContactos;
    }
}