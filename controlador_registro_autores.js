'use strict';

const boton_registrar = document.querySelector('#btn_registrar');

const input_nombre = document.querySelector('#txt_nombre');
const input_generoAutor = document.querySelector('#txt_generoAutor');
const input_biografia = document.querySelector('#txt_biografia');
const input_libros = document.querySelector('#txt_libros');

boton_registrar.addEventListener('click', obtener_datos);

function obtener_datos(){

    let nombre = input_nombre.value;
    let generoAutor = input_generoAutor.value;
    let biografia = input_biografia.value;
    let libros = input_libros.value;

    let bError = validar();

    if(bError == false){
    registrar_autor(nombre, generoAutor, biografia, libros);
        Swal.fire({
            type : 'success',
            title : 'El autor se registró exitosamente',
            confirmButtonText : 'Excelente!',
        });
    }else{
        Swal.fire({
            type : 'warning',
            title : 'No se pudo registrar al autor',
            text : 'Por favor, revise los campos resaltados',
            confirmButtonText : 'Entendido',
        })
    }
};

function validar(){
    let bError = false;

    if(input_nombre.value == ''){
        bError = true;
        input_nombre.classList.add('input_error');
    }else{
        input_nombre.classList.remove('input_error');
    }

    if(input_generoAutor.value == ''){
        bError = true;
        input_generoAutor.classList.add('input_error');
    }else{
        input_generoAutor.classList.remove('input_error');
    }

    if(input_biografia.value == ''){
        bError = true;
        input_biografia.classList.add('input_error');
    }else{
        input_biografia.classList.remove('input_error');
    }

    if(input_libros.value == ''){
        bError = true;
        input_libros.classList.add('input_error');
    }else{
        input_libros.classList.remove('input_error');
    }
    return bError;
}

