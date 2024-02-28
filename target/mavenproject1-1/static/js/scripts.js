$(document).ready(function () {

    // Cuando se hace clic en el botón de búsqueda
    $('.search-btn').click(function () {

        // Obtener término de búsqueda
        var searchTerm = $('#search-input').val().trim().toLocaleLowerCase();
        console.log("Buscar término: " + searchTerm);

        // Variable para rastrear si se encontró alguna coincidencia
        var coincidenciaEncontrada = false;

        // Recorrer tarjetas
        $('.contact-card').each(function () {

            // Obtener nombre
            var name = $(this).find('.card-title').text().trim().toLocaleLowerCase();
            console.log("Nombre: " + name);

            // Verificar coincidencia
            if (name.includes(searchTerm)) {
                // Resaltar tarjeta
                console.log("Coincidencia encontrada");
                $(this).addClass('highlight');
                // Variable para rastrear si se encontró alguna coincidencia
                coincidenciaEncontrada = true;
            } else {

                console.log("No hay coincidencia");
                $(this).removeClass('highlight');

            }

        });

        // Mostrar alerta si no se encontró ninguna coincidencia
        if (!coincidenciaEncontrada) {
            alert('No se encontraron resultados para la búsqueda.');
        }

    });



    //Funcion para tenectar el el evento eliminar
    $(".btnEliminar").click(function () {
        console.log("oli");
        var eliminar = $(this);
        var eliminarNombre = eliminar.data("eliminar");
        console.log("oliii jeje", eliminarNombre);
        $.ajax({
            url: "SvEliminar?nombreContacto=" + eliminarNombre,
            method: "POST",
            success: function (response) {
                // Manejar la respuesta exitosa si es necesario
            },
            error: function (error) {
                console.error("Error al eliminar el contacto:", error);
            }
        });
    });

    //FUncion creada para detectar el lemento ver
    $(".btn-ojo").click(function () {
        var botonOjo = $(this);
        var nombreContacto = botonOjo.data("nombre");
        console.log(nombreContacto);
        $.ajax({
            url: 'SvBuscar?nombreContacto=' + nombreContacto,
            method: 'POST',
            success: function (response) {
                // Mostrar los detalles del contacto en el modal
                $("#modal #nombre").val(response.nombre);
                $("#modal #apellido").val(response.apellido);
                $("#modal #email").val(response.email);
                $("#modal #celular").val(response.celular);
                $("#modal #cedula").val(response.cedula);
                $("#modal #direccion").val(response.direccion);
                // Otros campos del modal
                $("#modal").modal("show");
            },
            error: function (xhr, status, error) {
                console.error("Error al obtener los detalles del contacto:", error);
            }
        });

        // Llamar a la función para mostrar el modal
        mostrarModal();
    });

    // Función para mostrar el modal
    function mostrarModal() {
        $("#modal").modal("show");
    }

    $('.close').on('click', function () {
        $('#modal').modal('hide');
    });

    // La función eliminar ahora está dentro de $(document).ready()
    function Eliminar(Nombre) {
        $("#Eliminar").modal("show");
    }
    
});
