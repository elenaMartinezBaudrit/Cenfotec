'use strict';
// const es para exportar lo que se quiera usar
const clienteModel = require ('./clientes.model');

module.exports.registrar_cliente = function(req, res){
    let nuevoCliente = new clienteModel({
        primerNombre : req.body.primerNombre,
        segundoNombre : req.body.segundoNombre,
        primerApellido : req.body.primerApellido,
        segundoApellido : req.body.segundoApellido,
        genero : req.body.genero,
        tipoId : req.body.tipoId,
        numId : req.body.numId,
        email : req.body.email,
        fechaNac : req.body.fechaNac,
        edad : req.body.edad,
        provincia : req.body.provincia,
        canton : req.body.canton,
        distrito : req.body.distrito,
        direccionExacta : req.body.direccionExacta,
        tipoTarjeta : req.body.tipoTarjeta,
        nombreTarjeta : req.body.nombreTarjeta,
        numTarj : req.body.numTarj,
        mesVencTarj : req.body.mesVencTarj,
        yearVencTarj : req.body.yearVencTarj,
        cvv : req.body.cvv,
        genFavorito : req.body.genFavorito,
        libroFavorito : req.body.libroFavorito,
        autorFavorito : req.body.autorFavorito,
        partIntercambio : req.body.partIntercambio,
        estado : 'Activo'
    });

    nuevoCliente.save(function(error){
        if(error){
            res.json({
                success : false,
                msg : 'El cliente no pudo ser registrado : ' + error
            });
        }else{
            res.json({
                success : true,
                msg : 'El cliente se registró exitosamente'
            });
        }
    });
};

// module.exports.listar_clientes = function(req, res){
//     // El .sort es opcional. Puede ser orden ascendente o descendente.
//     clienteModel.find().sort({primerNombre : 'asc'}).then(
//         function(clientes){
//             if(clientes.length > 0){
//                 res.json({
//                     success : true,
//                     lista_clientes : clientes
//                 });
//             }else{
//                 res.json({
//                     success : false,
//                     lista_clientes : clientes
//                 });
//             }
//         }
//     );
// };

// module.exports.buscar_por_id = function (req, res){
//     clienteModel.find({_id : req.body.id_cliente}).then(
//        function(cliente){
//            if(cliente.length > 0){
//                res.json({success: true, cliente : cliente});
//            }else{
//                res.json({success: false, cliente : cliente});
//            }
//        }
//    );
// };

// module.exports.actualizar_cliente = function(req, res){
//     clienteModel.findByIdAndUpdate(req.body.id, { $set: req.body },
//         function (error){
//             if(error){
//                 res.json({success : false , msg : 'No se pudo actualizar la información del cliente'});
//             }else{
//                 res.json({success: true , msg : 'La información del cliente se actualizó con éxito'});
//             }
//         }
//     );
//  }