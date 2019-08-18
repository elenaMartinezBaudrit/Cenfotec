'use strict';

// Informacion personal 
const inputPrimerNombre = document.querySelector('#txtPrimerNombre');
const inputSegundoNombre = document.querySelector('#txtSegundoNombre');
const inputPrimerApellido = document.querySelector('#txtPrimerApellido');
const inputSegundoApellido = document.querySelector('#txtSegundoApellido');
const inputGenero = document.querySelector('#sltGenero');
const inputTipoId = document.querySelector('#radTipoId');
const inputNumId = document.querySelector('#txtNumId');
const inputEmail = document.querySelector('#txtEmail');
const inputFechaNac = document.querySelector('#sltFechaNac');
const inputEdad = document.querySelector('#txtEdad');

// Direccion 
const inputProvincia = document.querySelector('#txtProvincia');
const inputCanton = document.querySelector('#txtCanton');
const inputDistrito = document.querySelector('#txtDistrito');
const inputDireccionExacta = document.querySelector('#txtDireccionExacta');

// Metodo de pago objects
const inputTipoTarjeta = document.querySelector('#radTipoTarjeta');
const inputNombreTarjeta = document.querySelector('#txtNombreTarj');
const inputNumTarj = document.querySelector('#txtNumTarj');
const inputMesVencTarj = document.querySelector('#txtMesVencTarj');
const inputYearVencTarj = document.querySelector('#txtYearVencTarj');
const inputCVV = document.querySelector('#txtCVV');

// Preferencia de lectura objects
const inputGenFavorito = document.querySelector('#txtGenFavorito');
const inputLibroFavorito = document.querySelector('#txtLibroFavorito');
const inputAutorFavorito = document.querySelector('#txtAutorFavorito');
const inputPartIntercambio = document.querySelector('#radPartIntercambio');

let get_param = (param) => {
    var url_string =  window.location.href;
    var url = new URL(url_string);
    var id = url.searchParams.get(param);//Toma el parámetro id_cliente del url y retorna el valor
    return id;
};

let _id = get_param('id_cliente');

let cliente = buscar_cliente(_id);
let mostrar_datos = () =>{
// Informacion personal 
inputPrimerNombre.value = cliente[0]['primerNombre'];
inputSegundoNombre.value = cliente[0]['segundoNombre'];
inputPrimerApellido.value = cliente[0]['primerApellido'];
inputSegundoApellido.value = cliente[0]['segundoApellido'];
inputGenero.value = cliente[0]['genero'];
inputTipoId.value = cliente[0]['tipoID'];
inputNumId.value = cliente[0]['numId'];
inputEmail.value = cliente[0]['email'];
inputFechaNac.value = cliente[0]['fechaNac'];
inputEdad.value = cliente[0]['edad'];

// Direccion 
inputProvincia.value = cliente[0]['provincia'];
inputCanton.value = cliente[0]['canton'];
inputDistrito.value = cliente[0]['distrito'];
inputDireccionExacta.value = cliente[0]['direccionExacta'];

// Metodo de pago objects
inputTipoTarjeta.value = cliente[0]['tipoTarjeta'];
inputNombreTarjeta.value = cliente[0]['nombreTarjeta'];
inputNumTarj.value = cliente[0]['numTarj'];
inputMesVencTarj.value = cliente[0]['mesVencTarj'];
inputYearVencTarj.value = cliente[0]['yearVencTarj'];
inputCVV.value = cliente[0]['vcc'];

// Preferencia de lectura objects
inputGenFavorito.value = cliente[0]['genFavorito'];
inputLibroFavorito.value = cliente[0]['libroFavorito'];
inputAutorFavorito.value = cliente[0]['autorFavorito'];
inputPartIntercambio.value = cliente[0]['partIntercambio'];
};

if(cliente){
    mostrar_datos();
}

let obtenerDatosCliente = () =>{
    let sPrimerNombre = inputPrimerNombre.value;
    let sSegundoNombre = inputSegundoNombre.value;
    let sPrimerApellido = inputPrimerApellido.value;
    let sSegundoApellido = inputSegundoApellido.value;

    let sNombre = sPrimerNombre +' '+ sSegundoNombre +' '+sPrimerApellido + 
        ' ' + sSegundoApellido; 

    let sltGenero = inputGenero.value;
    let radTipoId = inputTipoId.value;
    let nNumId = Number(inputNumId.value);
    let eEmail = inputEmail.value;
    let dFechaNac = inputFechaNac.value;
    let nEdad = Number(inputEdad.value);

    let sProvincia = inputProvincia.value;
    let sCanton = inputCanton.value;
    let sDistrito = inputDistrito.value;
    let sDireccionExacta = inputDireccionExacta.value;

    let sltTipoTarjeta = inputTipoTarjeta.value;
    let sNombreTarjeta = inputNombreTarjeta.value;
    let nNumTarj = Number(inputNumTarj.value);
    let nMesVencTarj = Number(inputMesVencTarj.value);
    let nYearVencTarj = Number(inputYearVencTarj.value);
    let nCVV = Number(inputCVV.value);

    let sGenFavorito = inputGenFavorito.value;
    let sLibroFavorito = inputLibroFavorito.value;
    let sAutorFavorito = inputAutorFavorito.value;
    let sltPartIntercambio = inputPartIntercambio.value;

// TODO: Ask about the validation
    actualizar_cliente(sNombre, sltGenero, radTipoId, nNumId, eEmail, dFechaNac, nEdad, 
        sProvincia, sCanton, sDistrito, sDireccionExacta, sltTipoTarjeta, sNombreTarjeta,
        nNumTarj, nMesVencTarj, nYearVencTarj, nCVV, sGenFavorito, sLibroFavorito, 
        sAutorFavorito, sltPartIntercambio, _id);

        window.location.href = 'listar_clientes.html'
    };

    btnActCliente.addEventListener('click', obtenerDatosCliente);