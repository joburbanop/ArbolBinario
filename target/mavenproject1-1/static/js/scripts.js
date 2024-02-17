/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// RF3 - Resaltar contacto buscado
$(document).ready(function() {
    console.log("hola")
  $("#btnBuscar").click(function() {
    // Código para mostrar el modal
    mostrarModal();
  });

  function mostrarModal() {
    $("#modal").modal("show");
  }
});


// RF2 - Mostrar modal con datos de contacto
$("#contactos .contact-card").click(function() { 

  var infoContacto = obtenerInfoContacto($(this)); //trae los datos

  mostrarModal(infoContacto); //muestra modal

});

function mostrarModal(info) {

  $("#modal").find(".nombre").text(info.nombre); 
  $("#modal").find(".email").text(info.email);

  $("#modal").css("display", "block");

}