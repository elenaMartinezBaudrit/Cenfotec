// 'use strict';


// function registrar_libro(pTitulo, pAutor, pEditorial, pCategoria, pGenero, pPrecio, pCantidad_Libro, pResenna){
//     let request = $.ajax({
//         url : 'http://localhost:4000/api/registrar_libro',
//         method : "POST",
//         data : {
//             Titulo : pTitulo,
//             Autor : pAutor,
//             Editorial : pEditorial,
//             Categoria : pCategoria,
//             Genero : pGenero,
//             Precio: pPrecio,
//             Cantidad: pCantidad_Libro,
//             Resenna : pResenna
//         },
//         dataType : "json",
//         contentType : 'application/x-www-form-urlencoded; charset=UTF-8' 
//     });

//     request.done(function(res){
//         swal.fire({
//             type : 'error',
//             title : 'Proceso no realizado',
//             text : res.msg
//         });

//     });

//     request.fail(function(res){
//         swal.fire({
//             type : 'success',
//             title : 'Proceso realizado con éxito',
//             text : res.msg
//         });

//     });        
    
// };


// let listar_libro = () => {
//     let libro = [];
//     let request = $.ajax({
//         url: 'http://localhost:4000/api/listar_libro',
//         method : 'get',
//         contentType: 'application/x-www-form-urlencoded; charset=utf-8',
//         dataType : 'json',
//         async:false,
//         data:{
//         }
//       });
    
//       request.done(function(res){
//       libro = res.lista_libros;
//       });
    
//       request.fail(function(){
        
//       });
//       return libro;
// };



// let buscar_libro = (id_libro) => {
//     let libro = [];
//     let request = $.ajax({
//         url: "http://localhost:4000/api/buscar_libro/" + id_libro,
//         method: "GET",
//         data: {
//         },
//         dataType: "json",
//         contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
//         async : false
//       });
    
//       request.done(function (res) {
//           libro = res.libro;
//       });
    
//       request.fail(function (jqXHR, textStatus) {    
//       });
//       return libro;
// };


// let actualizar_libro = (pTitulo, pAutor, pEditorial, pCategoria, pGenero, pPrecio, pCantidad_Libro, pResenna) =>{
//     let request = $.ajax({
//         url : 'http://localhost:4000/api/actualizar_libro',
//         method : "POST",
//         data : {
//             Titulo : pTitulo,
//             Autor : pAutor,
//             Editorial : pEditorial,
//             Categoria : pCategoria,
//             Genero : pGenero,
//             Precio: pPrecio,
//             Cantidad: pCantidad_Libro,
//             Resenna : pResenna
//         },
//         dataType : "json",
//         contentType : 'application/x-www-form-urlencoded; charset=UTF-8' 
//     });

//     request.done(function(res){
//         swal.fire({
//             type : 'success',
//             title : 'Búsqueda realizado con éxito',
//             text : res.msg
//         });

//     });

//     request.fail(function(res){
//         swal.fire({
//             type : 'error',
//             title : 'Busqueda no realizado',
//             text : res.msg
//         });

//     });

// };
