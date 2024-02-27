<%-- 
    Document   : index
    Created on : 15/02/2024, 9:03:33 p. m.
    Author     : jonathan
--%>

<%@page import="mundo.Serializacion"%>
<%@page import="mundo.Contacto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mundo.Directorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Directorio Contactos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Mukta:wght@400;700&display=swap" rel="stylesheet">   
        <link href="./static/css/style.css" rel="stylesheet">
    </head>

    <body>

        <header>
            <h1 class="animate__animated directory-title">Mi Directorio de Contactos</h1>  
        </header>

        <main class="container row">

            <!-- ********************************************************************************** -->
            <!-- Esta seccion es la interfaz grafica que cumple con el requerimiento funcional RF1 -->
            <!-- ************************************************************************************ -->

            <section class="row col-md-4">
                <div class="col-md-12">

                    <div class="card contact-form p-2">

                        <form action="SvAgregar"  method="POST" >

                            <div class="mb-3">
                                <input class="form-control" type="text" name="nombre" placeholder="Nombre" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="text" name="apellido"  placeholder="Apellido" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="email" name="correo"  placeholder="Email" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="number" name="cedula" placeholder="Cedula" required >
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="number" name="celular" placeholder="Celular" pattern="[0-9]{10}" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="text" name="direccion" placeholder="Direccion" required>
                            </div>

                            <button type="submit" class="btn btn-primary">
                                <i class="fas fa-plus"></i> Añadir Contacto
                            </button>
                        </form>
                    </div>
                </div>
            </section>

            <!-- *********************************************************** -->
            <!-- seccion para el cumplimiento de RF2,RF3 y RF4 -->
            <!-- ********************************************************** -->
            <section class="row col-md-7 ml-auto">
                <div class="col-md-12">
                    <!-- div especializado en el cumplimiento de RF2, se mostrara un modal. o en caso de RF3 se remarcara en la tabla -->
                    <div class="input-group mb-3 animate__animated animate__fadeInUp">

                        <div class="input-group">
                            <input id="" class="form-control rounded-0" type="text" placeholder="Buscar contacto..." >
                            <button id="" class="btn btn-primary rounded-0 search-btn">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </div>

                    <!-- ********************************************************** -->
                    <!-- cumplimineto de RF4 y mostrar informacion -->   
                    <!-- ********************************************************** -->
                    <div id="contactos" class="row">
                        <%
                            Directorio directorio = new Directorio();

                            //Obtener el contexto del servlet
                            ServletContext context = getServletContext();
                            directorio = Serializacion.leerArchivoContactos(context);
                            // Obtener la lista de contactos del directorio
                            ArrayList<Contacto> contactos = directorio.obtenerContactos();

                            //System.out.println("DESDE INDE.JSP");
                            //System.out.println(contactos != null);
                            if (contactos != null) {
                                for (Contacto concargar : contactos) {
                        %>
                        <div class="col-md-6 animate__animated animate__fadeInLeft">
                            <div class="card contact-card">
                                <div class="card-body">
                                    <h5 class="card-title">
                                        <%= concargar.getNombre() + " " + concargar.getApellido()%> 
                                    </h5>
                                    <p class="card-text"><strong>Correo: </strong>  <%= concargar.getCorreo()%></p>
                                    <p class="card-text"><strong>Celular: </strong>  <%= concargar.getCelular()%></p>


                                    <a href="#" class="btn btn-danger btn-sm btnEliminar" data-eliminar="<%= concargar.getNombre()%>" type="button" onclick="eliminar('<%=concargar.getNombre()%>')">
                                        <i class="fas fa-trash"></i>
                                    </a>


                                    <a href="#" class="btn btn-primary btn-sm btn-ojo" data-nombre="<%= concargar.getNombre()%>">
                                        <span class="fas fa-eye"></span>
                                    </a>

                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="Eliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="eliminarLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="popup">
                                        <div class="close-btn btn-close" data-bs-dismiss="modal">&times;</div>
                                        <div class="form">
                                            <div id="user-details">
                                                <h2>¿Seguro que quieres eliminar este contacto?</h2>
                                                <div class="form-element" style="display: flex; justify-content: space-between;">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="margin-right: 10px;">Cancelar</button>
                                                    <button type="button" class="btn btn-danger" style="margin-left: 10px;" onclick="eliminar()">Eliminar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%
                            }
                        } else {
                        %>
                        <div class="col-md-12">
                            <p>No hay contactos disponibles.</p>
                        </div>
                        <%
                            }
                        %> 
                    </div>





                </div>
            </section>


            <!-- *********************************************************** -->
            <!-- Modal para mostrar la informacion completa del usurio -->
            <!-- ********************************************************** -->            
            <div id="modal" class="modal fade" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Detalles del Contacto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>

                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="nombre">Nombre:</label>
                                        <input type="text" class="form-control" id="nombre" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email:</label>
                                        <input type="email" class="form-control" id="email" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label for="celular">Celular:</label>
                                        <input type="text" class="form-control" id="celular" disabled>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="apellido">Apellido:</label>
                                        <input type="text" class="form-control" id="apellido" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label for="cedula">Cédula:</label>
                                        <input type="text" class="form-control" id="cedula" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label for="direccion">Dirección:</label>
                                        <input type="text" class="form-control" id="direccion" disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script src="./static/js/scripts.js"></script>
    </body>
</html>
