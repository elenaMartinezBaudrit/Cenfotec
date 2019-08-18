'use strict';
const mongoose = require('mongoose');

let autorSchema = new mongoose.Schema({
    nombre : {type : String, required : true},
    generoAutor : {type : String, required : true},
    biografia : {type : String, required : true},
    libros : {type : String, required : true},
});

module.exports = mongoose.model('Autor', autorSchema);