'use strict';

let autores = listar_autores();
const tabla = document.querySelector('#tbl_autores tbody');
// console.log(autores);

let mostrar_autores = () =>{
    for(let i = 0; i < autores.length; i++){
        let fila = tabla.insertRow();

        fila.insertCell().innerHTML = autores[i]['nombre'];
        fila.insertCell().innerHTML = autores[i]['biografia'];
        fila.insertCell().innerHTML = autores[i]['genero'];
        fila.insertCell().innerHTML = autores[i]['libros'];

        let celda_configuracion = fila.insertCell();

        // Creación del botón de editar
        let boton_editar = document.createElement('a');
        boton_editar.textContent = 'Editar';
        boton_editar.href = `actualizar_autores.html?id_autor=${autores[i]['_id']}`;

        celda_configuracion.appendChild(boton_editar);
    }

};
mostrar_autores();
