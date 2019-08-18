// 'use strict';

// let libros = listar_libro();
// const tabla = document.querySelector('#tbregistroLibro tbody');

// let mostrar_libros = () =>{
//     for(let i = 0; i < libros.length; i++){
//         let fila = tabla.insertRow();

//         fila.insertCell().innerHTML = libros[i]['Titulo'];
//         fila.insertCell().innerHTML = libros[i]['Autor'];
//         fila.insertCell().innerHTML = libros[i]['Editorial'];
//         fila.insertCell().innerHTML = libros[i]['Categoria'];
//         fila.insertCell().innerHTML = libros[i]['Genero'];
//         fila.insertCell().innerHTML = libros[i]['Precio'];
//         fila.insertCell().innerHTML = libros[i]['Cantidad'];
//         fila.insertCell().innerHTML = libros[i]['Resenna'];

//         let celda_configuracion = fila.insertCell();

//         // Creación del botón de editar
//         let boton_editar = document.createElement('a');
//         boton_editar.textContent = 'Editar';
//         boton_editar.href = `actualizar_Libros.html?id_libros=${libros[i]['_id']}`;

//         celda_configuracion.appendChild(boton_editar);
//     } 

// };

// mostrar_libros();