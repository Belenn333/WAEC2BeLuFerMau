$(document).on("click", "#btnagregar", function(){
    $("#txttitulo").val("");
    $("#txtresumen").val("");
    $("#txtfechapublicacion").val("");
    $("#hddpublicacionid").val("0");
    listarCboAutor(0,0);
    $("#modalpublicacion").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txttitulo").val($(this).attr("data-publtitulo"));
    $("#txtresumen").val($(this).attr("data-publresumen"));
    $("#txtfechapublicacion").val($(this).attr("data-publfechapub"));
    $("#hddpublicacionid").val($(this).attr("data-publid"));
    $("#cboautor").empty();
    listarCboAutor($(this).attr("data-publautor"));
    $("#modalpublicacion").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/publicacion/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idpublicacion: $("#hddpublicacionid").val(),
            titulo: $("#txttitulo").val(),
            resumen: $("#txtresumen").val(),
            fechpublicacion: $("#txtfechapublicacion").val(),
            autor: $("#cboautor").val(),
        }),
        success: function(resultado){
            alert(resultado.mensaje)
            location.reload();
        }
    });
    $("#modalpelicula").modal("hide");
});



function listarCboAutor(idautor){
    $.ajax({
        type: "GET",
        url: "/autor/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboautor").append(
                    `<option value="${value.idautor}">${value.nomautor}</option>`
                )
            });
            if(idgenero > 0){
                $("#cboautor").val(idautor);
            }
        }
    })
}

$(document).on("click", ".btneliminar", function() {
    var idpublicacion = $(this).data("publid");
    if (confirm("¿Estás seguro de que quieres eliminar esta película?")) {
        $.ajax({
            type: "DELETE",
            url: "/publicacion/eliminar/" + idpublicacion,
            success: function() {
                // Recargar la página o actualizar la tabla después de eliminar
                // Por ejemplo:
                location.reload();
            },
            error: function(xhr, status, error) {
                console.error("Error al eliminar la película:", error);
            }
        });
    }
});