//11 numeros seguidos

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("fuyipsu").addEventListener('submit', validarFormulario);
});

function validarFormulario(evento) {
    evento.preventDefault();
    var ci = document.getElementById('ci').value;
    if (!(/^\d{11}$/.test(ci))) {
        alert('Ingrese 11 dígitos en el carnet de identidad');
        return;
    }
    this.submit();
}