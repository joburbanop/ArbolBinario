/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// RF2 - Mostrar modal con datos de contacto
$(document).ready(function () {

// Agregar evento de clic al botón del ojo
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
});
// RF3 - resaltar en la lista 
$("#contactos .contact-card").click(function () {



});
