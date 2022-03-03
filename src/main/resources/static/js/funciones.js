// a continuación se muestran las funciones para eliminar en el servidor

function eliminar(id) {

    swal({
            title: "¿Está seguro que desea eliminar la denuncia? ",

            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/EliminarDenuncia/" + id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("La denuncia  ha sido eliminada", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/GestDenuncia";
                    }
                });
            } else {
                swal("La denuncia no ha sido eliminada");
            }
        });
}





function eliminarUsuario(id) {

    swal({
            title: "¿Está seguro que desea eliminar el usuario?",

            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/EliminarUsuario/" + id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("El usuario ha sido eliminado", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/GestUsuarios";
                    }
                });
            } else {
                swal("El usuario no ha sido eliminado");
            }
        });
}





function eliminarReporte(id) {

    swal({
            title: "¿Está seguro que desea eliminar el reporte?",

            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/EliminarReporte/" + id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("El reporte ha sido eliminado", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/Reportes";
                    }
                });
            } else {
                swal("El reporte no ha sido eliminado");
            }
        });
}


function GuardarNotificacion(id) {

    swal({
            title: "¿Quieres enviar una notificacion al usuario que realizó la denuncia?",

            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/GuardarNotificacion/" + id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("Notificacion enviada", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/Reportes";
                    }
                });
            } else {
                swal("Ha cancelado el envío");
            }
        });
}

function reporte(id) {

    swal({
            title: "¿Quieres crear un reporte?",

            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/GenerarReporte" + id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("Reporte creado", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/GestDenuncia";
                    }
                });
            } else {
                swal("Ha cancelado el reporte");
            }
        });
}