'use strict';

let lista_clientes = listar_clientes();
// function imprimir_lista_clientes_info_personal(){
let tbody = document.querySelector('#tblInfoPersCliente tbody');
    // let lista_clientes = obtener_lista_clientes();
    // let lista_clientes = listar_clientes();
    console.log(lista_clientes);

    let mostrar_clientes = () => {
    
        for(let i = 0; i < lista_clientes.length; i++){
            let fila = tbody.insertRow();

            fila.insertCell().innerHTML = lista_clientes[i]['nombreCompleto'];
            fila.insertCell().innerHTML = lista_clientes[i]['email'];
            fila.insertCell().innerHTML = lista_clientes[i]['provincia'];
            fila.insertCell().innerHTML = lista_clientes[i]['canton'];
            fila.insertCell().innerHTML = lista_clientes[i]['distrito'];
            fila.insertCell().innerHTML = lista_clientes[i]['direccionExacta'];
            fila.insertCell().innerHTML = lista_clientes[i]['genFavorito'];
            fila.insertCell().innerHTML = lista_clientes[i]['libroFavorito'];
            fila.insertCell().innerHTML = lista_clientes[i]['autorFavorito'];
            fila.insertCell().innerHTML = lista_clientes[i]['partIntercambio'];
    
            let celda_configuracion = fila.insertCell();

            // Creación del botón de editar
            let boton_editar = document.createElement('a');
            boton_editar.textContent = 'Editar';
            boton_editar.href = `actualizar_clientes.html?id_cliente=${lista_clientes[i]['_id']}`;
    
            celda_configuracion.appendChild(boton_editar);
        
        }
    };
    mostrar_clientes();
