'use strict';
const express = require('express');
const router = express.Router();
const autoresApi = require('./autores.api');

// router.param('id_autor', function(req, res, next, id_autor){
//     req.body.id_autor = id_autor;
//     next();
//   });

router.route('/registrar_autor')
    .post(function(req, res){
        autoresApi.registrar_autor(req, res);
    });

// router.route('/listar_autores')
//     .get(function(req, res){
//         autoresApi.listar_autores(req, res);
//     });

// router.route('/actualizar_autor')
// .post(
//     function(req , res){
//         autoresApi.actualizar_autor(req, res);
//     }
// );

// router.route('/buscar_autor/:id_autor')
// .get(
//   function(req , res){
//     autoresApi.buscar_por_id(req, res);
//   }
// );

module.exports = router;