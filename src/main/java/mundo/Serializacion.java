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

/**
 * @author sofi
 */
public class Serializacion {
    
    /**
     * Escribe el objeto Directorio en un archivo de serialización.
     * @param listaContactos El Directorio a escribir.
     * @param context El contexto del servlet.
     * @throws FileNotFoundException Si no se encuentra el archivo.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void escribirArchivoContactos(Directorio listaContactos, ServletContext context) throws FileNotFoundException, IOException {
        String rutaRelativa = "/data/contactosAgregados.ser";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

        try (FileOutputStream fos = new FileOutputStream(archivo); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaContactos);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de datos.");
        }
    }

    /**
     * Lee el archivo de serialización y devuelve un objeto Directorio.
     * @param context El contexto del servlet.
     * @return El Directorio leído desde el archivo.
     * @throws IOException Si ocurre un error de E/S.
     * @throws ClassNotFoundException Si la clase no se encuentra.
     */
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
        return listaContactos;
    }
}
