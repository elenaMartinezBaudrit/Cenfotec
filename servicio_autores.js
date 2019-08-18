'use strict';

function registrar_autor(pnombre, pgeneroAutor, pbiografia, plibros){
    let request = $.ajax({
        url : 'http://localhost:4000/api/registrar_autor',
        method : "POST",
        data : {
            nombre : pnombre,
            genero : pgeneroAutor,
            biografia : pbiografia,
            libros: plibros,
        },
        dataType : "json",
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8' 
    });

    request.done(function(res){
        swal.fire({
            type : 'success',
            title : 'Proceso realizado con éxito',
            text : res.msg
        });

    });

    request.fail(function(res){
        swal.fire({
            type : 'error',
            title : 'Proceso no realizado',
            text : res.msg
        });

    });
};

let listar_autores = () => {

    let autores = [];
  
    let request = $.ajax({
      url: "http://localhost:4000/api/listar_autores",
      method: "GET",
      data: {
      },
      dataType: "json",
      contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
      async : false
    });
  
    request.done(function (res) {
        autores = res.lista_autores;
    });
  
    request.fail(function (jqXHR, textStatus) {
      
    });
    return autores;
  };

let buscar_autor = (id_autor) => {
    let autor = [];
  
    let request = $.ajax({
      url: "http://localhost:4000/buscar_autor/"+ id_autor,
      method: "GET",
      data: {
      },
      dataType: "json",
      contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
      async : false
    });
  
    request.done(function (res) {
        autor = res.autor;
      
    });
  
    request.fail(function (jqXHR, textStatus) {
      
    });
    return autor;
   
  };

let actualizar_autor = (pnombre, pgeneroAutor, pbiografia, plibros) =>{
    let request = $.ajax({
        url : 'http://localhost:4000/api/actualizar_autor',
        method : "POST",
        data : {
            nombre : pnombre,
            genero : pgeneroAutor,
            biografia : pbiografia,
            libros: plibros,
        },
        dataType : "json",
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8' 
    });

    request.done(function(res){
        swal.fire({
            type : 'success',
            title : 'Proceso realizado con éxito',
            text : res.msg
        });

    });

    request.fail(function(res){
        swal.fire({
            type : 'error',
            title : 'Proceso no realizado',
            text : res.msg
        });

    });

};