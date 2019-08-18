'use strict';
const mongoose = require('mongoose');

let clienteSchema = new mongoose.Schema({
    primerNombre : {type : String, required : true},
    segundoNombre : {type : String, required : false},
    primerApellido : {type : String, required : true},
    segundoApellido : {type : String, required : false},
    genero : {type : String, required : true},
    tipoId : {type : String, required : true},
    numId : {type : Number, unique : true, required : true},
    email : {type : String, unique : true, required : true},
    fechaNac : {type : String, required : true},
    edad : {type : Number, required : true},
    provincia : {type : String, required : true},
    canton : {type : String, required : true},
    distrito : {type : String, required : true},
    direccionExacta : {type : String, required : true},
    tipoTarjeta : {type : String, required : true},
    nombreTarjeta : {type : String, required : true},
    numTarj : {type : Number, required : true},
    mesVencTarj : {type : Number, required : true},
    yearVencTarj : {type : Number, required : true},
    cvv : {type : Number, required : true},
    genFavorito : {type : String, required : false},
    libroFavorito : {type : String, required : false},
    autorFavorito : {type : String, required : false},
    partIntercambio : {type : String, required : true}
});

module.exports = mongoose.model('Cliente', clienteSchema);