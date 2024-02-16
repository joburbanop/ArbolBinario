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

            <section class="row col-md-4">
                <div class="col-md-12">

                    <div class="card contact-form p-2">

                        <form>

                            <div class="mb-3">
                                <input class="form-control" type="text" placeholder="Nombre">
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="text" placeholder="Apellido">
                            </div>

                            <div class="mb-3">
                                <input class="form-control" type="email" placeholder="Email">
                            </div>

                            <button class="btn btn-primary">
                                <i class="fas fa-plus"></i> Añadir Contacto
                            </button>

                        </form>
                    </div>
                </div>
            </section>

            <!-- Contact List -->
            <section class="row col-md-7">
                <div class="col-md-12">

                    <div class="input-group mb-3 animate__animated animate__fadeInUp">
                        <input class="form-control" type="text" placeholder="Buscar contacto..." >
                        <button class="btn btn-primary search-btn">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>

                    <!-- Contact Cards-->   
                    <div class="row">

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

        </main>

    </body>
</html>
