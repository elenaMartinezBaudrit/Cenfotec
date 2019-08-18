'use strict'

// let lista_clientes = [];

function registrar_cliente(psPrimerNombre, psSegundoNombre, psPrimerApellido, psSegundoApellido,
    psltGenero, pRadTipoId, pnNumId, peEmail, pdFechaNac, pnEdad, psProvincia, 
    psCanton, psDistrito, psDireccionExacta, psltTipoTarjeta, psNombreTarjeta, pnNumTarj, 
    pnMesVencTarj, pnYearVencTarj, pnCVV, psGenFavorito, psLibroFavorito, psAutorFavorito, 
    psltPartIntercambio){
    let request = $.ajax({
        url : 'http://localhost:4000/api/registrar_cliente',
        method : "POST",
        data : {
            primerNombre: psPrimerNombre,
            segundoNombre : psSegundoNombre,
            primerApellido : psPrimerApellido,
            segundoApellido : psSegundoApellido,
            genero : psltGenero,
            tipoId : pRadTipoId,
            numId : pnNumId,
            email : peEmail,
            fechaNac : pdFechaNac,
            edad : pnEdad,
            provincia : psProvincia,
            canton : psCanton,
            distrito : psDistrito,
            direccionExacta : psDireccionExacta,
            tipoTarjeta : psltTipoTarjeta,
            nombreTarjeta : psNombreTarjeta,
            numTarj : pnNumTarj,
            mesVentTarj : pnMesVencTarj,
            yearVencTarj : pnYearVencTarj,
            cvv : pnCVV,
            genFavorito : psGenFavorito,
            libroFavorito : psLibroFavorito,
            autorFavorito : psAutorFavorito,
            partIntercambio : psltPartIntercambio
        },
        dataType : "json",
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8' 
    });

    request.fail(function(res){
        swal.fire({
            type : 'error',
            title : 'Proceso no realizado',
            text : res.msg
        });
    });
    // Linea 51: parentesis nuevo
    };
    
    let listar_clientes = () => {

        let clientes = [];
      
        let request = $.ajax({
          url: "http://localhost:4000/api/listar_clientes",
          method: "GET",
          data: {
          },
          dataType: "json",
          contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
          async : false
        });

        request.done(function (res) {
            clientes = res.lista_clientes;
        });

        request.fail(function (jqXHR, textStatus) {
      
        });
        return clientes;
      };

let buscar_cliente = (id_cliente) => {
    let cliente = [];

    let request = $.ajax({
        url: "http://localhost:4000/buscar_cliente/"+ id_cliente,
        method: "GET",
        data: {
        },
        dataType: "json",
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        async : false
    });

    request.done(function (res) {
        cliente = res.cliente;
    });

    request.fail(function (jqXHR, textStatus) { 
    });
    return cliente;
  };


  function actualizar_cliente(psPrimerNombre, psSegundoNombre, psPrimerApellido, psSegundoApellido,
    psltGenero, pRadTipoId, pnNumId, peEmail, pdFechaNac, pnEdad, psProvincia, 
    psCanton, psDistrito, psDireccionExacta, psltTipoTarjeta, psNombreTarjeta, pnNumTarj, 
    pnMesVencTarj, pnYearVencTarj, pnCVV, psGenFavorito, psLibroFavorito, psAutorFavorito, 
    psltPartIntercambio) {
    let request = $.ajax({
        url : 'http://localhost:4000/api/actualizar_cliente',

        // url : 'http://localhost:27017/api/registrar_autor',
        method : "POST",
        data : {
            primerNombre: psPrimerNombre,
            segundoNombre : psSegundoNombre,
            primerApellido : psPrimerApellido,
            segundoApellido : psSegundoApellido,
            genero : psltGenero,
            tipoId : pRadTipoId,
            numId : pnNumId,
            email : peEmail,
            fechaNac : pdFechaNac,
            edad : pnEdad,
            provincia : psProvincia,
            canton : psCanton,
            distrito : psDistrito,
            direccionExacta : psDireccionExacta,
            tipoTarjeta : psltTipoTarjeta,
            nombreTarjeta : psNombreTarjeta,
            numTarj : pnNumTarj,
            mesVentTarj : pnMesVencTarj,
            yearVencTarj : pnYearVencTarj,
            cvv : pnCVV,
            genFavorito : psGenFavorito,
            libroFavorito : psLibroFavorito,
            autorFavorito : psAutorFavorito,
            partIntercambio : psltPartIntercambio
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

//     let nuevoCliente = [];
//     nuevoCliente.push(psPrimerNombre, psSegundoNombre, psPrimerApellido, psSegundoApellido,
//         psltGenero, pRadTipoId, pnNumId, peEmail, pdFechaNac, pnEdad, pdFechaNac, pnEdad, 
//         psProvincia, psCanton, psDistrito, psDireccionExacta, psltTipoTarjeta, psNombreTarjeta, 
//         pnNumTarj, pnMesVencTarj, pnYearVencTarj, pnCVV, psGenFavorito, psLibroFavorito, 
//         psAutorFavorito, psltPartIntercambio);

//     lista_clientes.push(nuevoCliente);
// };

// function obtener_lista_clientes(){
//     return lista_clientes;
// }
