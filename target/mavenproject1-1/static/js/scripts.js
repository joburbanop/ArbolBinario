$(document).ready(function () {
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
    $(document).ready(function () {
    $(".btnEliminar").click(function () {
        $("#Eliminar").modal("show");
        
        //console.log("oli");
        //var eliminar = $(this);
        //var eliminarNombre = eliminar.data("eliminar");
        //console.log("oliii jeje", eliminarNombre);
        $("#confirmarEliminar").click(function(){
            
        });
        $.ajax({
            url: "SvEliminar?nombreContacto=" + eliminarNombre,
            method: "POST",
            success: function (response) {
                // Manejar la respuesta exitosa si es necesario
                // Llamar a la función para mostrar la modal de eliminar
                Eliminar(eliminarNombre);
            },
            error: function (error) {
                console.error("Error al eliminar el contacto:", error);
            }
        });
    });

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

    $('.close').on('click', function () {
        $('#modal').modal('hide');
    });

    // Función para mostrar el modal
    function mostrarModal() {
        $("#modal").modal("show");
    }

    // La función eliminar ahora está dentro de $(document).ready()
    function Eliminar(Nombre) {
        $("#Eliminar").modal("show");
    }
});
});
