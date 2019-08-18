'use strict';

const express = require('express');
const router = express.Router();
const api_registroLibros = require('./registroLibros.api');

router.param('id_registrar_libro', function(req, res, next, id_libro){
    req.body.id_libro = id_libro;
    next();
});

router.route('/registrar_libro')
    .post(
        function(req , res){
            api_registroLibros.registrar(req, res);
        }
    );

    router.route('/actualizar_libro')
    .post(
        function(req , res){
            api_registroLibros.actualizar(req, res);
        }
    );

router.route('/listar_libro')
    .get(
        function(req , res){
            api_registroLibros.listar(req, res);
        }
    );

router.route('/buscar_libro/:id_libro')
.get(
    function(req , res){
        api_registroLibros.buscar_por_id(req, res);
    }
);

module.exports = router;