// a continuación se muestran las funciones para eliminar en el servidor
function eliminar(id) {
    swal({
            title: " ¿Está seguro que desea eliminar el área?  ",

            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/EliminarArea/" + id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("El área  ha sido eliminada", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/gestionarArea";
                    }
                });
            } else {
                swal("El área no se eliminó");
            }
        });
}