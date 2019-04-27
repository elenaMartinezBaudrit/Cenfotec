package rutinas;

/*
 * Es importante someter a reflexión el uso de variables globales contra las variables locales.
 *
 * 1. Por qué, por ejemplo, para la opción 3, donde se busca la cantidad de entregas de un productor
 * no hacemos "numProd" una variable global de tal forma que cuando llamamos la función
 * Rutinas.obtenerEntregasPorProductor() no se tenga que pasar como parámetro sino que ya se conozca
 * su valor en el módulo Rutinas y la función la pueda utilizar con el valor que aquí se asignó
 *
 * 2. En la función agregarProductor, se declara un arreglo local listaEntregas y no se utiliza el
 * arreglo que en sí almacena las entregas (el que se encuentra declarado en Rutinas). Por qué no
 * utilizamos directamente ese arreglo y no que hacemos uso del arreglo local.
 *
 * 3. Por qué no declaramos cantProductores con ámbito global y no tendríamos que llamar a la
 * función Rutinas.obtenerTotalProductores() donde aquí la necesitemos. Como sucede en la
 * funcióm imprimirPagoProductores() ó en la función mostrarLista()
 *
 */

import java.io.*;


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
        out.println("2.  Leche entregada a la Cía.");
        out.println("3.  Número de entregas por productor");
        out.println("4.  Leche por productor");
//        out.println("5.  Menor número de entregas y número del productor");
//        out.println("6.  Mayor número de entregas de productor");
        out.println("7.  Asignacion de estrellas. Pregunta E del examen");
        out.println("8.  Total de botellas de leche recibidas. Pregunta C del examen");
        out.println("9.  Promedio de Leche. Pregunta D del examen");
//        out.println("10. Modificar el precio de la botella de leche");
        out.println("11. Salir");
//        out.println("12. Cantidad de botellas por entrega por productor");
        out.println();
    }

    /*****************************************************************
     * Rutina: leerOpcion
     * Propósito: Obtener del usuario la opcíón escogida
     * Parámetros:
     *
     * Retorna:
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

    static boolean ejecutarAccion(int pOpcion)throws java.io.IOException{


        boolean noSalir = true;
        int numProd=0;


        if (pOpcion >= 2 && pOpcion <= 8 && Rutinas.obtenerTotalProductores() == 0){
            out.println("No hay registrados productores");
            return noSalir;
        }

        switch(pOpcion){


            case 1: //Opcion Agregar Productor

                agregarProductor();
                break;

            case 2:// 'Opcion Total de leche entregada a la Cia

                out.println();
                out.println("Se han recibido " + Rutinas.calcularTotalLeche() + " botella(s)");
                break;

            case 3: //Opcion Numero de entregas por productor

                int entregas;
                numProd = solicitarProductor();
                entregas = Rutinas.obtenerEntregasProductor(numProd);

                if (entregas != 0){

                    out.println("El productor " + numProd + " ha realizado " + entregas + " entregas");
                }else{
                    out.println("Productor no registrado");
                }
                break;


            case 4: //Opcion Leche entregada por productor


                int totalLeche;
                numProd = solicitarProductor();
                totalLeche = Rutinas.obtenerLecheProductor(numProd);

                if (totalLeche != 0){

                    out.println("El productor " + numProd + " ha entregado "+ totalLeche + " botellas");
                }else{

                    out.println("Productor no registrado");
                }
                break;

            case 5: //Opcion determinar datos del menor: número del productor y entregas

                int [] elMenor;
                elMenor = Rutinas.obtenerMenorEntregas();
                out.println("El Productor número " + elMenor[0] + " ha realizado "+ elMenor[1] + " entrega(s) ");
                break;

            case 6:

                break;

            case 7: //Asignacion de estrellas

                double promLechePorProductor = 0;
                numProd = solicitarProductor();
                totalLeche = Rutinas.obtenerLecheProductor(numProd);
                entregas = Rutinas.obtenerEntregasProductor(numProd);
                double promedioProdLecheEmpresa = Rutinas.promedioProdLeche();

                if (totalLeche != 0 && entregas != 0){
                    promLechePorProductor = (double)totalLeche/(double)entregas;
                    out.println("El productor " + numProd + " ha entregado un promedio de " + promLechePorProductor + " botellas");
                }else{

                    out.println("Productor no registrado");
                }

                if (promLechePorProductor <= promedioProdLecheEmpresa) {
                    out.println("Estrellas asignadas al productor " +numProd+ ": 1.");
                } else if (promLechePorProductor > (promedioProdLecheEmpresa) && promLechePorProductor <= (promedioProdLecheEmpresa*1.2)) {
                    out.println("Estrellas asignadas al productor " + numProd + ": 2.");
                } else if (promLechePorProductor > (promedioProdLecheEmpresa*1.2) && promLechePorProductor <= (promedioProdLecheEmpresa*1.5)) {
                    out.println("Estrellas asignadas al productor " + numProd + ": 3.");
                } else if (promLechePorProductor > (promedioProdLecheEmpresa*1.5) && promLechePorProductor < (promedioProdLecheEmpresa*1.7)) {
                    out.println("Estrellas asignadas al productor " + numProd + ": 4.");
                } else {
                    out.println("Estrellas asignadas al productor " + numProd + ": 5.");
                }

                break;

            case 8: //Imprimir el pago de cada productor

                Rutinas.totalBotellasRecibidas();
                break;

            case 9: //'Opcion Mostrar promedio Leche

                Rutinas.promedioProdLeche();
                break;

            case 10: //Modificar el precio de la leche

                double precio;
                out.println("Deme el nuevo precio: ");
                precio = Double.parseDouble(in.readLine());

                Rutinas.modificarPrecioLeche(precio);
                out.println();
                break;

            case 11: //Salir de la aplicacion

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
     * Rutina: imprimirPagoProductores
     * Propósito: Mostrar al usuario el pago de cada productor
     * Parámetro:
     *
     * Retorna:
     *****************************************************************/

    static void imprimirPagoProductores(){

        String[] pagos;

        pagos = Rutinas.calcularPagoProductores();

        out.println("=================Pagos a los productores ================");

        for(int i = 0; i< pagos.length-1 ; i++){ //El último string trae el total a pagar

            out.println(pagos[i]);
        }

        out.println("===============================================================");
        out.println("El total a pagar es de: "+ pagos[pagos.length-1] + " colones");
        out.println();
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

