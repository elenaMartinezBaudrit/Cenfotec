'use strict';

const input_nombre = document.querySelector('#txt_nombre');
const input_generoAutor = document.querySelector('#txt_generoAutor');
const input_biografia = document.querySelector('#txt_biografia');
const input_libros = document.querySelector('#txt_libros');

let get_param = (param) => {
    var url_string =  window.location.href;
    var url = new URL(url_string);
    var id = url.searchParams.get(param);//Toma el parámetro id_autor del url y retorna el valor
    return id;
};

let _id = get_param('id_autor');

let autor = buscar_autor(_id);
let mostrar_datos = () =>{
    input_nombre.value = autor[0]['nombre'];
    input_generoAutor.value = autor[0]['generoAutor'];
    input_biografia.value = autor[0]['biografia'];
    input_libros.value = autor[0]['libros'];
 
};

if(autor){
    mostrar_datos();
}

let obtener_datos = () =>{
    let nombre = input_nombre.value;
    let generoAutor = input_generoAutor.value;
    let biografia = input_biografia.value;
    let libros = input_libros.value;

    actualizar_autor(nombre, generoAutor, biografia, libros, _id); 
    window.location.href = 'listar_autores.html';
    
};

btn_actualizar.addEventListener('click', obtener_datos);