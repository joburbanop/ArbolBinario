<%-- 
    Document   : index
    Created on : 15/02/2024, 9:03:33 p. m.
    Author     : jonathan
--%>

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
                                <input class="form-control" type="text" placeholder="Nombre" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="text" placeholder="Apellido" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="email" placeholder="Email" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="number" placeholder="Cedula" required >
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="number" placeholder="Celular" pattern="[0-9]{10}" required>
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="text" placeholder="Direccion" required>
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
                        <div class="d-flex justify-content-end mb-3">
                            <div class="form-check form-check-inline has-tooltip" data-toggle="tooltip" title="Muestra los datos completos del contacto seleccionado">
                                <input class="form-check-input" type="radio" name="requerimiento" id="rf2" value="rf2" checked>
                                <label class="form-check-label" for="rf2">Ver datos</label>
                            </div>
                            <div class="form-check form-check-inline has-tooltip" data-toggle="tooltip" title="Resalta en la lista el contacto buscado">
                                <input class="form-check-input" type="radio" name="requerimiento" id="rf3" value="rf3">
                                <label class="form-check-label" for="rf3">Buscar contacto</label>
                            </div>
                        </div>

                        <div class="input-group">
                            <input id="buscar" class="form-control rounded-0" type="text" placeholder="Buscar contacto..." >
                            <button id="btnBuscar" class="btn btn-primary rounded-0 search-btn">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </div>

                    <!-- cumplimineto de RF4 y mostrar informacion -->   
                    <div id="contactos" class="row">

                        <div class="col-md-6 animate__animated animate__fadeInLeft">
                            <div class="card contact-card">

                                <div class="card-body">
                                    <h5 class="card-title">
                                        Maria Gomez <span class="badge bg-primary">Editar</span>
                                    </h5>
                                    <p class="card-text">mariag@email.com</p>
                                    <a href="#" class="btn btn-danger btn-sm">
                                        <i class="fas fa-trash"></i> Eliminar
                                    </a>
                                </div>

                            </div>
                        </div>

                        <div class="col-md-6 animate__animated animate__fadeInRight">
                            <div class="card contact-card">

                                <div class="card-body">
                                    <h5 class="card-title">
                                        Pedro Torres <span class="badge bg-primary">Editar</span>
                                    </h5>
                                    <p class="card-text">pedro.torres@email.com</p>
                                    <a href="#" class="btn btn-danger btn-sm">
                                        <i class="fas fa-trash"></i> Eliminar 
                                    </a>
                                </div>

                            </div>
                        </div>

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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script src="./static/js/scripts.js"></script>
    </body>
</html>