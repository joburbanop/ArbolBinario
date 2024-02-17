/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// RF2 - Mostrar modal con datos de contacto
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


// RF3 - resaltar en la lista 
$("#contactos .contact-card").click(function() { 

 

});

function mostrarModal(info) {

  $("#modal").find(".nombre").text(info.nombre); 
  $("#modal").find(".email").text(info.email);

  $("#modal").css("display", "block");

}