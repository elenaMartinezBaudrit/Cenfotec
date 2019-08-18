'use strict';

const modelo_libro = require('./registroLibros.model');

module.exports.registrar = function(req, res){
    let nuevo_libro = new modelo_libro(
        {
            Titulo : req.body.Titulo,
            Autor : req.body.Autor,
            Editorial : req.body.Editorial,
            Genero : req.body.Genero,
            Categoria : req.bodyCategoria,
            Precio : req.body.Precio,
            Cantidad : req.body.Cantidad,
            Resenna : req.body.Resenna,
            estado : 'Activo'
        }
    );
    nuevo_libro.save(
        function (error){
            if(error){
                res.json({success : false , msg : 'No se pudo registrar el libro'});
            }else{
                res.json({success: true , msg : 'El libro se registró con éxito'});
            }
        }
    );
};

module.exports.listar = function (req, res){
    modelo_libro.find().then(
        function(libros){
            if(libros.length > 0){
                res.json({success: true, lista_libros : libros});
            }else{
                res.json({success: false, lista_libros : libros});
            }
        }

    );
};

module.exports.buscar_por_id = function (req, res){
    modelo_libro.find({_id : req.body.id_libro}).then(
        function(libro){
            if(libro.length > 0){
                res.json({success: true, lista_libros : libro});
            }else{
                res.json({success: false, lista_libros : libro});
            }
        }

    );

};

module.exports.actualizar = function(req, res){
   
    modelo_libro.findByIdAndUpdate(req.body.id, { $set: req.body },
        function (error){
            if(error){
                res.json({success : true, 
                     msg : 'No se pudo actualizar el libro'});
            }else{
                res.json({success: true , msg : 'El libro se actualizó con éxito'});
            }
        }
    
    );
}