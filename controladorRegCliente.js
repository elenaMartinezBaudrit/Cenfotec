'use strict';

// Variables globales
const botonRegistrarCliente = document.querySelector('#btnRegCliente');
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

botonRegistrarCliente.addEventListener('click', obtenerDatosCliente);

function obtenerDatosCliente(){

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

    let bError = validar();
    
    if(bError == false){
    registrar_cliente(sNombre, sltGenero, radTipoId, nNumId, eEmail, dFechaNac, nEdad, 
        sProvincia, sCanton, sDistrito, sDireccionExacta, sltTipoTarjeta, sNombreTarjeta,
        nNumTarj, nMesVencTarj, nYearVencTarj, nCVV, sGenFavorito, sLibroFavorito, 
        sAutorFavorito, sltPartIntercambio);

        Swal.fire({
            type : 'success',
            title : 'El usuario se registró exitosamente',
            text : 'Ahora puedes acceder a toda nuestra plataforma. Feliz lectura!',
            confirmButtonText : 'Excelente!',
        });
    }else{
        Swal.fire({
            type : 'warning',
            title : 'No se pudo registrar al usuario',
            text : 'Por favor, revise los campos resaltados',
            confirmButtonText : 'Entendido',
        })
    }
};

function validar(){
    let bError = false;
    let regExpNumeros = /^[0-9]+$/;

    // Validacion de informacion personal
    if(inputPrimerNombre.value == ''){
        bError = true;
        inputPrimerNombre.classList.add('input_error');
    }else{
        inputPrimerNombre.classList.remove('input_error');
    }

    if(inputPrimerApellido.value == ''){
        bError = true;
        inputPrimerApellido.classList.add('input_error');
    }else{
        inputPrimerApellido.classList.remove('input_error');
    }

    if(inputGenero.value == ''){
        bError = true;
        inputGenero.classList.add('input_error');
    }else{
        inputGenero.classList.remove('input_error');
    }

    if(inputTipoId.value == ''){
        bError = true;
        inputTipoId.classList.add('input_error');
    }else{
        inputTipoId.classList.remove('input_error');
    }

    if(inputNumId.value == '' || regExpNumeros.test(inputNumId.value) == false){
        bError = true;
        inputNumId.classList.add('input_error');
    }else{
        inputNumId.classList.remove('input_error');
    }

//     // TODO regex para validar esto
    if(inputEmail.value == ''){
        bError = true;
        inputEmail.classList.add('input_error');
    }else{
        inputEmail.classList.remove('input_error');
    }

    if(inputFechaNac.value == ''){
        bError = true;
        inputFechaNac.classList.add('input_error');
    }else{
        inputFechaNac.classList.remove('input_error');
    }

    if(inputEdad.value == '' || regExpNumeros.test(inputEdad.value) == false){
        bError = true;
        inputEdad.classList.add('input_error');
    }else{
        inputEdad.classList.remove('input_error');
    }

    if(inputProvincia.value == ''){
        bError = true;
        inputProvincia.classList.add('input_error');
    }else{
        inputProvincia.classList.remove('input_error');
    }

    if(inputCanton.value == ''){
        bError = true;
        inputCanton.classList.add('input_error');
    }else{
        inputCanton.classList.remove('input_error');
    }

    if(inputDistrito.value == ''){
        bError = true;
        inputDistrito.classList.add('input_error');
    }else{
        inputDistrito.classList.remove('input_error');
    }

    if(inputDireccionExacta.value == ''){
        bError = true;
        inputDireccionExacta.classList.add('input_error');
    }else{
        inputDireccionExacta.classList.remove('input_error');
    }

    // Validación metodo de pago
    if(inputTipoTarjeta.value == ''){
        bError = true;
        inputTipoTarjeta.classList.add('input_error');
    }else{
        inputTipoTarjeta.classList.remove('input_error');
    }

    if(inputNombreTarjeta.value == ''){
        bError = true;
        inputNombreTarjeta.classList.add('input_error');
    }else{
        inputNombreTarjeta.classList.remove('input_error');
    }

    if(inputNumTarj.value == '' || regExpNumeros.test(inputNumTarj.value) == false){
        bError = true;
        inputNumTarj.classList.add('input_error');
    }else{
        inputNumTarj.classList.remove('input_error');
    }

    if(inputMesVencTarj.value == '' || regExpNumeros.test(inputMesVencTarj.value) == false){
        bError = true;
        inputMesVencTarj.classList.add('input_error');
    }else{
        inputMesVencTarj.classList.remove('input_error');
    }

    if(inputYearVencTarj.value == '' || regExpNumeros.test(inputYearVencTarj.value) == false){
        bError = true;
        inputYearVencTarj.classList.add('input_error');
    }else{
        inputYearVencTarj.classList.remove('input_error');
    }

    if(inputCVV.value == '' || regExpNumeros.test(inputCVV.value) == false){
        bError = true;
        inputCVV.classList.add('input_error');
    }else{
        inputCVV.classList.remove('input_error');
    }

    if(inputPartIntercambio.value == ''){
        bError = true;
        inputPartIntercambio.classList.add('input_error');
    }else{
        inputPartIntercambio.classList.remove('input_error');
    }

return bError;
};
