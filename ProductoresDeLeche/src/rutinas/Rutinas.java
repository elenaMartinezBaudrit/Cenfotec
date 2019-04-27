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

public class Rutinas {

    static int nuevoIndice = 0;
    static int cantProductores = 0;

    private static int[] listaProductores = new int[10];
    private static int[] listaEntregas = new int[10];
    private static int[] listaIndices = new int[10];
    private static int[] listaProduccion = new int[50];

    /*****************************************************************
     * Rutina: registrarProductor
     * Propósito: Registrar los datos del productor en el sistema
     * Parámetro: pNumProd
     *			   Número del productor
     * Parámetro: pEntregas
     *			  Número de entregas realizadas por el productor
     * Parámetro: pListaProd
     *			  Lista de botellas en cada una de las entregas
     * Retorna:
     *****************************************************************/

    public static void registrarProductor(int pNumProd, int pEntregas, int[] pListaProd) {

        int j = 0;
        int indiceInicio = nuevoIndice;
        int indiceFin = nuevoIndice + pEntregas;


        listaProductores[cantProductores] = pNumProd;
        listaEntregas[cantProductores] = pEntregas;
        listaIndices[cantProductores] = nuevoIndice;

        for (int i = indiceInicio; i < indiceFin; i++) {

            listaProduccion[i] = pListaProd[j];
            j++;
        }

        cantProductores++;
        nuevoIndice = indiceFin;
    }

    /*****************************************************************
     * Rutina: buscarProductor
     * Propósito: Buscar si el productor esta registrado en el sistema.
     * Parámetro: boolean encontrado
     *              Para verificar si se encuentra registrado o no.
     * Parámetro: int indice
     *              Indica el índice que le corresponde al productor a buscar.
     * Retorna: indice
     *****************************************************************/

    public static int buscarProductor(int pnum) {

        boolean encontrado = false;
        int indice = -1;
        int i = 0;


        while (i < cantProductores && !encontrado) {

            if (listaProductores[i] == pnum) {

                encontrado = true;
                indice = i;
            }
            i += 1;
        }

        return indice;
    }

    /*****************************************************************
     * Rutina: calcularLecheProductor
     * Propósito: Calcular la cantidad de botellas de leche entregadas por productor
     * Parámetro:   int numEntregas -> Numera la cantidad de entregas del productor
     *                  int indiceInicial -> índice del arreglo donde comenzará el análisis
     *                  int indiceFinal ->índice del arreglo donde terminará el análisis.
     *              int totalLeche -> cantidad total de botellas de leche entregadas por el productor
     * Retorna: totalLeche
     *****************************************************************/

    public static int calcularLecheProductor(int pindice) {

        int numEntregas;
        int indiceInicial, indiceFinal, i;
        int totalLeche = 0;


        numEntregas = listaEntregas[pindice];
        indiceInicial = listaIndices[pindice];
        indiceFinal = indiceInicial + numEntregas;

        for (i = indiceInicial; i < indiceFinal; i++) {

            totalLeche += listaProduccion[i];
        }

        return totalLeche;
    }

    /*****************************************************************
     * Rutina: obtenerEntregasProductor
     * Propósito:Calcular la cantidad de entregas del productor
     * Parámetro:   int entregas -> númmero de entregas del productor
     *                  int indice -> índice donde comienza el análisis de
     *                      las entregas de un productor específico
     * Retorna: entregas
     *****************************************************************/

    public static int obtenerEntregasProductor(int pnum) {
        int entregas = 0;
        int indice = buscarProductor(pnum);
        if (indice != -1) {

            entregas = listaEntregas[indice];
        }

        return entregas;
    }

    /*****************************************************************
     * Rutina: obtenerPromedioBotellasPorProductor
     * Propósito: obtener el promedio de las botellas entregadas por producvot
     * Parámetro:
     *
     * Retorna: obtenerPromedioBotellasPorProductor
     * NOTA: La inteligencia de negocio está en el main. Sé que debería haberla hecho aquí,
     *         pero no funcionó como esperaba... Bueno, no funcionó en lo absoluto.
     *****************************************************************/

    public static int obtenerPromedioBotellasPorProductor() {

        return obtenerPromedioBotellasPorProductor();
    }

    /*****************************************************************
     * Rutina: calcularTotalLeche
     * Propósito: Calcular la cantidad total de botellas de leche entregadas
     * Parámetro:   int totalLeche -> contabilizar la cantidad de botellas de leche entregadas.
     *              int i = indicador del índice del elemento en el arreglo
     * Retorna: totalLeche
     *****************************************************************/

    public static int calcularTotalLeche() {

        int totalLeche = 0;
        int i;

        for (i = 0; i < nuevoIndice; i++) {

            totalLeche += listaProduccion[i];
        }

        return totalLeche;
    }

    /*****************************************************************
     * Rutina: obtenerLecheProductor
     * Propósito: Calcular la cantidad total de botellas de leche entregadas por un productor
     * Parámetro:   int totalLeche -> contabilizar la cantidad de botellas de leche entregadas.
     *              int indice -> índice donde comienza el análisis de
     *                  las entregas de botellas de leche de un productor específico
     * Retorna: totalLeche
     *****************************************************************/

    public static int obtenerLecheProductor(int pnum) {

        int totalLeche = 0;
        int indice = buscarProductor(pnum);

        if (indice != -1) {

            totalLeche = calcularLecheProductor(indice);
        }

        return totalLeche;
    }

    /*****************************************************************
     *
     * Rutina: obtenerTotalProductores
     * Propósito: obtener el número total de productores y dar lugar a analizar los elementos que
     *              componen ese arreglo.
     * Parámetro:
     *
     * Retorna: cantProductores
     *****************************************************************/

    public static int obtenerTotalProductores() {

        return cantProductores;
    }

    /*****************************************************************
     * Rutina: obtenerNuevoIndice
     * Propósito: Proveer al IUEntrregasLeche los elementos del arreglo que se
     *  		  recibe como parámetro
     * Parámetro:
     *
     * Retorna: nuevoIndice
     *****************************************************************/

    public static int obtenerNuevoIndice() {

        return nuevoIndice;
    }

    /*****************************************************************
     * Rutina: asignarEstrellas
     * Propósito: Asignar las estrellas correspondientes a los productores de acuerdo a la cantidad
     *              de botellas de leche entregadas y su relación con el promedio de la compañía
     * Parámetro:
     *
     * Retorna: asignarEstrellas
     * NOTA: La inteligencia de negocio está en el main. Sé que debería haberla hecho aquí,
     *      pero no funcionó como esperaba... Bueno, no funcionó en lo absoluto.
     *****************************************************************/

    public static int[] asignarEstrellas() {

        return (asignarEstrellas());
    }

    /*****************************************************************
     * Rutina: obtenerPromedioLeche
     * Propósito: Obtener el promedio de botellas de leche entregadas a la Compañía
     * Parámetro:   int produccionTotalLeche -> variable a la que se agregará la cantidad de botellas de leche
     *                  entregadas en cada elemento del arreglo listaProduccion[]
     *              int cantEntregas -> variable a la que se agregará la cantidad de entregas por cada
     *                  productor del arreglo cantEntrega[]
     *              float promedioLeche -> produccionTotalLeche / cantEntregas
     *
     * Retorna: promedioLeche
     *****************************************************************/

    public static double promedioProdLeche() {

        int produccionTotalLeche = 0;
        float promedioLeche = 0;
        int cantEntregas = 0;

        for (int i = 0; i < listaProduccion.length; i++) {
            produccionTotalLeche = produccionTotalLeche + listaProduccion[i];
        }
        for (int i = 0; i < listaEntregas.length; i++) {
            cantEntregas = cantEntregas + listaEntregas[i];
        }

        promedioLeche = (float) produccionTotalLeche / (float) cantEntregas;

        System.out.println("El promedio de botellas recibidas por la compañía es: " + promedioLeche);

        return promedioLeche;
    }
}
