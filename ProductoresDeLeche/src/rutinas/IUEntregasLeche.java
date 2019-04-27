/**
 * Nombre: Segundo Parcial.
 * Descripción:  A. Haga una función que reciba recibe el id del productor y retorne la cantidad total de botellas entregadas por ese productor
 *      (NOTA: LA CANTIDAD TOTAL SE REFIERE A LA SUMATORIA DE TODAS LAS BOTELLAS DE TODAS LAS ENTREGAS REALIZADAS POR DICHO PRODUCTOR).
 * B. Haga una función que, recibiendo el id del productor, retorne el promedio de botellas entregadas por el productor
 *      (ESTO ES LA CANTIDAD TOTAL DE BOTELLAS ENTRE LA CANTIDAD DE ENTREGAS)
 * C. Haga una función que calcule la cantidad total de botellas recibidas por la compañía
 *      (ESTO ES LA SUMATORIA TOTAL DE LA CANTIDAD TOTAL DE BOTELLAS DE CADA PRODUCTOR)
 * D. Haga una función que calcule el promedio de botellas recibidas por la compañía
 *      (ESTO ES LA SUMATORIA TOTAL DE LA CANTIDAD TOTAL DE BOTELLAS DE CADA PRODUCTOR ENTRE LA SUMATORIA TOTAL
 *      DE ENTREGAS DE TODOS LOS PRODUCTORES)
 * E. Haga una rutina que le asigne una cantidad de estrellas al productor basada en los siguientes criterios:
 *      1 estrella si el promedio de botellas entregadas del productor es menor o igual al promedio de la compañía,
*       2 estrellas si el promedio de botellas entregadas por el productor es superior en un 20 % o menos al promedio de la compañía,
 *      3 estrellas si el promedio de botellas entregadas por el productor es superior entre un 21% y un 50 %  al promedio de la compañía,
 *      4 estrellas si el promedio de botellas entregadas por el productor es superior entre un 51% y un 70 % al promedio de la compañía y
 *      5 estrellas si el promedio de botellas entregadas por el productor es superior en un 70 % o más al promedio de la compañía.
 * F. Haga una función que retorne una lista con el id del productor y la cantidad de estrellas que se le adjudicaron.
 * Fecha 27-04-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 27-04-2019.
 * Modificado por: Elena Martínez Baudrit.
 */


package rutinas;

import java.io.*;
import java.util.HashMap;


public class IUEntregasLeche{

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;	// variables objetos in y out para


    /******************************************************************
     * Modulo Principal que permite ejecutar la aplicación
     *
     *******************************************************************/

    public static void main(String[] args)throws java.io.IOException{

        int opc;
        boolean noSalir = true;

        do{
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);
        }while (noSalir);
    }

    /*****************************************************************
     * Rutina: mostrarMenu
     * Propósito: Presentar el menú de opciones
     * Parámetros:
     *
     * Retorna:
     *****************************************************************/

    static void mostrarMenu(){

        out.println();
        out.println("1.  Agregar productor");
        out.println("2.  Cantidad total de botellas entregadas por un productor específico (Pregunta A)");
        out.println("3.  Promedio de botellas por productor específico (Pregunta B)");
        out.println("4.  Cantidad total de botellas recibidas por la Compañía (Pregunta C)");
        out.println("5.  Promedio de botellas recibidas por la Compañía (Pregunta D)");
        out.println("6.  Asignación de estrellas por productor (Pregunta E)");
        out.println("7.  Asignación de estrellas para cada uno de los productores (Pregunta F)");
        out.println("8.  Salir");
        out.println();
    }

    /*****************************************************************
     * Rutina: leerOpcion
     * Propósito: Obtener del usuario la opcíón escogida
     * Parámetros: int opcion
     *              Permite desarrollar la funcion que escogió el usuario
     * Retorna: opción escogida por usuario.
     *****************************************************************/

    static int leerOpcion()throws java.io.IOException{

        int opcion;

        out.print("Seleccione su opción: ");
        opcion = Integer.parseInt(in.readLine());
        out.println();

        return opcion;
    }

    /*****************************************************************
     * Rutina: ejecutarAccion
     * Propósito: Ejecutar la acción que corresponde a la opcíón escogida
     * Parámetro: pOpcion
     *
     * Retorna: boolean
     *			Un valor que indica si se desea continuar o salir del menú
     *****************************************************************/

    static boolean ejecutarAccion(int pOpcion)throws java.io.IOException {


        boolean noSalir = true;
        int numProd = 0;


        if (pOpcion >= 2 && pOpcion <= 8 && Rutinas.obtenerTotalProductores() == 0) {
            out.println("No hay registrados productores");
            return noSalir;
        }

        switch (pOpcion) {


            case 1: //Opcion Agregar Productor

                agregarProductor();
                break;

            case 2: //Cantidad total de botellas por productor específico - Pregunta A

                int totalLeche;
                numProd = solicitarProductor();
                totalLeche = Rutinas.obtenerLecheProductor(numProd);

                if (totalLeche != 0) {

                    out.println("El productor " + numProd + " ha entregado " + totalLeche + " botellas");
                } else {

                    out.println("Productor no registrado");
                }
                break;

            case 3: //Promedio de botellas por productor - Pregunta B

                int entregas;
                float promBotellasPorProd;

                numProd = solicitarProductor();
                totalLeche = Rutinas.obtenerLecheProductor(numProd);
                entregas = Rutinas.obtenerEntregasProductor(numProd);

                if (totalLeche != 0) {
                    promBotellasPorProd = (float) totalLeche / (float) entregas;
                    out.println("El productor " + numProd + " ha entregado un promedio de " + promBotellasPorProd + " botellas");
                } else {

                    out.println("Productor no registrado");
                }
                break;

            case 4: //Imprimir total de botellas de leche recibidas - Pregunta C

                out.println();
                out.println("Se han recibido " + Rutinas.calcularTotalLeche() + " botella(s) en total");
                break;

            case 5: //Promedio de botellas recibidas por la compañía - Pregunta D

                Rutinas.promedioProdLeche();
                break;

            case 6: //Asignacion de estrellas (por productor) - Pregunta E

                float promLechePorProductor = 0;
                numProd = solicitarProductor();
                totalLeche = Rutinas.obtenerLecheProductor(numProd);
                entregas = Rutinas.obtenerEntregasProductor(numProd);
                float promedioProdLecheEmpresa = (float) Rutinas.promedioProdLeche();
                int estrellas = 0;

                if (totalLeche != 0 && entregas != 0) {
                    promLechePorProductor = (float) totalLeche / (float) entregas;
                    out.println("El productor " + numProd + " ha entregado un promedio de " + promLechePorProductor + " botellas");
                    if (promLechePorProductor <= promedioProdLecheEmpresa) {
                        estrellas = 1;
                    } else if (promLechePorProductor > (promedioProdLecheEmpresa) && promLechePorProductor <= (promedioProdLecheEmpresa * 1.2)) {
                        estrellas = 2;
                    } else if (promLechePorProductor > (promedioProdLecheEmpresa * 1.2) && promLechePorProductor <= (promedioProdLecheEmpresa * 1.5)) {
                        estrellas = 3;
                    } else if (promLechePorProductor > (promedioProdLecheEmpresa * 1.5) && promLechePorProductor < (promedioProdLecheEmpresa * 1.7)) {
                        estrellas = 4;
                    } else {
                        estrellas = 5;
                    }
                    System.out.println("Estrellas asignadas al productor " + numProd + ": " + estrellas);
                } else {

                    out.println("Productor no registrado");
                }

                break;

            case 7: //Imprimir las estrellas asignadas a cada uno de los productores (Pregunta F)

//                TODO: "to HashMap or not to HashMap?"... Consider find an alternative evaluated in class for this. So far, this works!

                HashMap<Integer, Integer> mapaEstre = new HashMap<>();

                for (int i = 0; i < Rutinas.obtenerTotalProductores(); i++) {
                    totalLeche = Rutinas.obtenerLecheProductor(i + 1);
                    entregas = Rutinas.obtenerEntregasProductor(i + 1);
                    promLechePorProductor = (float) totalLeche / (float) entregas;
                    promedioProdLecheEmpresa = (float) Rutinas.promedioProdLeche();

                    if (promLechePorProductor <= promedioProdLecheEmpresa) {
                        estrellas = 1;
                        mapaEstre.put((i + 1), estrellas);
                    } else if (promLechePorProductor > (promedioProdLecheEmpresa) && promLechePorProductor <= (promedioProdLecheEmpresa * 1.2)) {
                        estrellas = 2;
                        mapaEstre.put((i + 1), estrellas);
                    } else if (promLechePorProductor > (promedioProdLecheEmpresa * 1.2) && promLechePorProductor <= (promedioProdLecheEmpresa * 1.5)) {
                        estrellas = 3;
                        mapaEstre.put((i + 1), estrellas);
                    } else if (promLechePorProductor > (promedioProdLecheEmpresa * 1.5) && promLechePorProductor < (promedioProdLecheEmpresa * 1.7)) {
                        estrellas = 4;
                        mapaEstre.put((i + 1), estrellas);
                    } else {
                        estrellas = 5;
                        mapaEstre.put((i + 1), estrellas);
                    }
                }

                for (Integer info: mapaEstre.keySet()){
                    String key = info.toString();
                    String value = mapaEstre.get(info).toString();
                    System.out.println("Las estrellas para el productor " +key + " son " + value);
                }

                break;

            case 8: //Salir de la aplicacion

                noSalir = false;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                out.println("Opcion inválida");
                out.println();
                break;

        }
        return noSalir;
    }

    /*****************************************************************
     * Rutina: agregarProductor
     * Propósito: Obtener del usuario los datos del productor y registrarlos en
     *			  el sistema.
     * Parámetro:
     *
     * Retorna:
     *****************************************************************/

    static void agregarProductor()throws java.io.IOException{

        int entregas, numProd;
        int i, indice;


        numProd = solicitarProductor();
        out.println();

        indice = Rutinas.buscarProductor(numProd);

        if(indice == -1){     //Verificamos que no exista el productor

            int[] listaEntregas;

            out.print("Deme el número de entregas: ");
            entregas = Integer.parseInt(in.readLine());
            out.println();

            listaEntregas= new int[entregas];

            for(i = 0; i< listaEntregas.length ;i++){

                out.print("Deme el número de botellas de la entrega " + (i+1) + ": ");
                listaEntregas[i] = Integer.parseInt(in.readLine());
                out.println();
            }

            Rutinas.registrarProductor(numProd, entregas,listaEntregas);
            out.println("Productor registrado satisfactoriamente");

        }else{
            out.println("Este productor ya realizó sus entregas");
        }
    }


    /*****************************************************************
     * Rutina: solicitarProductor
     * Propósito: Obtener del usuario el número del  productor
     * Parámetro:
     *
     * Retorna: int
     *			El número del productor
     *****************************************************************/

    static int solicitarProductor()throws java.io.IOException{

        int numProd;

        out.print("Deme el número del productor: ");
        numProd = Integer.parseInt(in.readLine());
        out.println();

        return numProd;
    }

    /*****************************************************************
     * Rutina: mostrarLista
     * Propósito: Mostrar en la pantalla los elementos del arreglo que se
     *			  recibe como parámetro
     * Parámetro: pLista
     *			  El arreglo cuya información se desea mostrar en la pantalla
     * Parámetro: pLim
     *			  Cantidad de elementos que existe en el arreglo
     * Retorna:
     *****************************************************************/
    static void mostrarLista(int[] pLista, int pLim){

        int i, limite;


        if (pLim == 1){

            limite = Rutinas.obtenerTotalProductores();
        }else{

            limite = Rutinas.obtenerNuevoIndice();
        }
        out.print("{");

        for(i = 0; i< limite;i++){

            out.print(pLista[i]+ " ");
        }

        out.print("}");
        out.println();
    }

    /*****************************************************************
     * Rutina: cantidadDeBotellasPorProductor
     * Propósito: Mostrar en la pantalla la cantidad total de botellas por productor
     * Parámetro: pLista
     *			  El arreglo cuya información se desea mostrar en la pantalla
     * Parámetro: pLim
     *			  Cantidad de elementos que existe en el arreglo
     * Retorna:
     *****************************************************************/
    static void cantidadDeBotellasPorProductor(int[] pLista, int pLim){

        int i, limite;


        if (pLim == 1){

            limite = Rutinas.obtenerTotalProductores();
        }else{

            limite = Rutinas.obtenerNuevoIndice();
        }
        out.print("{");

        for(i = 0; i< limite;i++){

            out.print(pLista[i]+ " ");
        }

        out.print("}");
        out.println();
    }

}

