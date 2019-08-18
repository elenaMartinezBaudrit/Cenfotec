// 'use strict';




// const boton_registrar = document.querySelector('#btnRegistrarLibro');

// const input_Titulo = document.querySelector('#txtTitulo');
// const slt_Autor = document.querySelector('#slt_Autor');
// const input_Editorial = document.querySelector('#txtEditorial');
// const slt_Categoria = document.querySelector('#slt_Categoria');
// const slt_Genero = document.querySelector('#slt_Genero');
// const input_Precio = document.querySelector('#numPrecio');
// const input_Cantidad_Libro = document.querySelector('#cantLibro');
// const input_Resenna = document.querySelector('#txtResenna');

// function obtener_datos(){

//     if(validar_datos() == true){
//     let Titulo = input_Titulo.value;
//     let Autor = slt_Categoria.selectedOptions[0].value;
//     let Editorial = input_Editorial.value;
//     let Categoria = slt_Categoria.selectedOptions[0].value;
//     let Genero = slt_Genero.selectedOptions[0].value;
//     let Precio = Number(input_Precio.value);
//     let Cantidad_Libro = Number(input_Cantidad_Libro.value);
//     let Resenna=(input_Resenna.value)

//     registrar_libro(Titulo, Autor, Editorial, Categoria, Genero, Precio, Cantidad_Libro, Resenna);
   

//     } else{
//         swal.fire({
//             type: 'warning',
//             title: 'No se pudo hacer el registro',
//             text: 'Por favor revise los campos resaltados'
//         })
//     }
// };    

// boton_registrar.addEventListener('click', obtener_datos);

// function validar_datos(){
//     let error = true;
//     let regExpNumeros = /^[0-9]+$/;
    

//     if(input_Titulo.value == ''){
//         error = false;
//         input_Titulo.classList.add('input_Error');
//     }else{
//         input_Titulo.classList.remove('input_Error');
//     }
  
//     if(slt_Autor.selectedOptions[0].value == ''){
//         error = false;
//         slt_Autor.classList.add('input_Error');
//     }else{
//         slt_Autor.classList.remove('input_Error');
//     }


//     if(input_Editorial.value == ''){
//         error = false;
//         input_Editorial.classList.add('input_Error');
//     }else{
//         input_Editorial.classList.remove('input_Error');
//     }

//     if(slt_Categoria.selectedOptions[0].value == ''){
//         error = false;
//         slt_Categoria.classList.add('input_Error');
//     }else{
//         slt_Categoria.classList.remove('input_Error');
//     }


//     if(slt_Genero.selectedOptions[0].value == ''){
//         error = false;
//         slt_Genero.classList.add('input_Error');
//     }else{
//         slt_Genero.classList.remove('input_Error');
//     }
  

//     if(input_Precio.value == '' || regExpNumeros.test(input_Precio.value) == false){
//         error = false;
//         input_Precio.classList.add('input_Error');
//     }else{
//         input_Precio.classList.remove('input_Error');
//     }
   
    
//     if(input_Cantidad_Libro.value == '' || regExpNumeros.test(input_Cantidad_Libro.value) == false){
//         error = false;
//         input_Cantidad_Libro.classList.add('input_Error');
//     }else{
//         input_Cantidad_Libro.classList.remove('input_Error');
//     }


//     if(input_Resenna.value == ''){
//         error = false;
//         input_Resenna.classList.add('input_Error');
//     }else{
//         input_Resenna.classList.remove('input_Error');
//     }

//     return error;
    

// };

// function getSelectValue(){
//     var selectValue = document.getElementById("slt_Categoria").value;
//     console.log (selectValue);
// };

// getSelectValue();



