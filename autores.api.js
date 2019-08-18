'use strict';

const autorModel = require ('./autores.model');

module.exports.registrar_autor = function(req, res){
    let nuevoAutor = new autorModel({
        nombre : req.body.nombre,
        generoAutor : req.body.generoAutor,
        biografia : req.body.biografia,
        libros : req.body.libros,
        estado : 'Activo'
    });

    nuevoAutor.save(function(error){
        if(error){
            res.json({
                success : false,
                msg : 'El autor no pudo ser registrado : ' + error
            });
        }else{
            res.json({
                success : true,
                msg : 'El autor se registró exitosamente'
            });
        }
    });
};

// module.exports.buscar_por_id = function (req, res){
//     autorModel.find({_id : req.body.id_autor}).then(
//        function(autor){
//            if(autor.length > 0){
//                res.json({success: true, autor : autor});
//            }else{
//                res.json({success: false, autor : autor});
//            }
//        }
//    );
// };

// module.exports.actualizar_autor = function(req, res){
//     autorModel.findByIdAndUpdate(req.body.id, { $set: req.body },
//         function (error){
//             if(error){
//                 res.json({success : false , msg : 'No se pudo actualizar la información del autor'});
//             }else{
//                 res.json({success: true , msg : 'La información del autor se actualizó con éxito'});
//             }
//         }
//     );
//  }