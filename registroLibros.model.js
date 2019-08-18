'use strict';

const mongoose = require('mongoose');

let schema_libros = mongoose.Schema({
    Titulo : {type : String, required : true},
    Autor : {type : String, required : true},
    Editorial : {type: String, required : true},
    Genero : {type: String, require: true},
    Categoria : {type: String, require: true},
    Precio : {type : Number, required : false},
    Cantidad : {type : Number, required : true},
    Resenna : {type : String,},
    estado : { type : String, require: true} 
    
});

module.exports = mongoose.model('Libros' , schema_libros);

