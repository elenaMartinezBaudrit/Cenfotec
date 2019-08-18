'use strict';
const express = require('express');
const router = express.Router();
const clientesApi = require('./clientes.api');

// router.param('id_cliente', function(req, res, next, id_cliente){
//     req.body.id_cliente = id_cliente;
//     next();
//   });

router.route('/registrar_cliente')
    .post(function(req, res){
        clientesApi.registrar_cliente(req, res);
    });

// router.route('/listar_clientes')
//     .get(function(req, res){
//         clientesApi.listar_clientes(req, res);
//     });

// router.route('/actualizar_cliente')
// .post(
//     function(req , res){
//         clientesApi.actualizar_cliente(req, res);
//     }
// );

// router.route('/buscar_cliente/:id_cliente')
// .get(
//   function(req , res){
//     clientesApi.buscar_por_id(req, res);
//   }
// );

module.exports = router;