/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mundo.Contacto;
import mundo.Directorio;

/**
 *
 * @author jonathan
 */
public class SvBuscar extends HttpServlet {

    private Contacto contactoRaiz = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //System.out.println("hola desde sv buscar");
        String nombreContacto = request.getParameter("nombreContacto");

        System.out.println("hola desde sv buscar " + nombreContacto);
        Contacto dir = Directorio.buscar(Directorio.contactoRaiz, nombreContacto);

        System.out.println("Nombre " + dir.getNombre());
        System.out.println("CELULAR " + dir.getCelular());
        System.out.println("cedula " + dir.getCedula());
        // Crear un objeto JSON con la información del contacto
        StringBuilder jsonResponse = new StringBuilder();
        jsonResponse.append("{");
        jsonResponse.append("\"nombre\": \"" + dir.getNombre() + "\",");
        jsonResponse.append("\"apellido\": \"" + dir.getApellido() + "\",");
        jsonResponse.append("\"email\": \"" + dir.getCorreo()+ "\",");
        jsonResponse.append("\"celular\": \"" + dir.getCelular() + "\",");
        jsonResponse.append("\"cedula\": \"" + dir.getCedula() + "\",");
        jsonResponse.append("\"direccion\": \"" + dir.getDireccion() + "\"");
        jsonResponse.append("}");
        // Escribir el objeto JSON en la respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse.toString());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
