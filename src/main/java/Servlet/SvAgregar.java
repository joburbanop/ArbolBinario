/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mundo.Contacto;
import mundo.Directorio;
import mundo.Serializacion;

/**
 *
 * @author jonathan
 */
@WebServlet(name = "SvAgregar", urlPatterns = {"/SvAgregar"})
public class SvAgregar extends HttpServlet {

    private Directorio directorio = new Directorio();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // Obtiene los parámetros del formulario
        String celular = request.getParameter("celular");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String cedula = request.getParameter("cedula");
        String direccion = request.getParameter("direccion");

                //Obtener el contexto del servlet
        ServletContext context = getServletContext();
        //System.out.println("celular " + celular);
        //System.out.println("apellido " + apellido);
        //System.out.println("correo " + correo);

        //System.out.println("nombre " + nombre);
        //System.out.println("cedula " + cedula);
        //System.out.println("direccion " + direccion);
        String id = "1";

        // Agrega el nuevo contacto al directorio
        directorio.agregarContacto(id, String.valueOf(celular), nombre, apellido, correo, String.valueOf(cedula), direccion);
        
        Serializacion.escribirArchivoContactos(directorio, context);
        
        // Obtener la lista de contactos del directorio
        ArrayList<Contacto> contactos = directorio.obtenerContactos();
        
        
        //System.out.println("Lista de contactos:");
        //for (Contacto contacto : contactos) {
        //    System.out.println(contacto.getNombre() + " --- " + contacto.getApellido() + " - " + contacto.getCorreo());
        //}
        // Establecer la lista de contactos como un atributo en el request
        request.setAttribute("contactos", contactos);
        
        // Redirecciona al archivo index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
