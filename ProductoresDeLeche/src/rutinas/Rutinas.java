package rutinas;

public class Rutinas {

        static int nuevoIndice = 0;
        static int cantProductores = 0;

        private static int[] listaProductores = new int[10];
        private static int[] listaEntregas = new int[10];
        private static int[] listaIndices = new int[10];
        private static int[] listaProduccion = new int[50];

        static double precioLeche = 100;

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



        public static void registrarProductor(int pNumProd, int pEntregas, int[] pListaProd){

            int j=0;
            int indiceInicio= nuevoIndice;
            int indiceFin= nuevoIndice + pEntregas;


            listaProductores[cantProductores]= pNumProd;
            listaEntregas[cantProductores]= pEntregas;
            listaIndices[cantProductores] = nuevoIndice;

            for(int i=indiceInicio; i< indiceFin;i++){

                listaProduccion[i]= pListaProd[j];
                j++;
            }

            cantProductores++;
            nuevoIndice = indiceFin;
        }

        /*****************************************************************
         * Rutina: buscarProductor
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/


        public static int buscarProductor(int pnum){

            boolean encontrado = false;
            int indice = -1;
            int i = 0;


            while(i < cantProductores && !encontrado){

                if(listaProductores[i] == pnum){

                    encontrado = true;
                    indice = i;
                }
                i += 1;
            }

            return indice;
        }

        /*****************************************************************
         * Rutina: obtenerProductorMasLeche
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int obtenerProductorMasLeche(){

            int i, indice=0;
            int mayorCantidadLeche=0;
            int lecheProductor;


            for(i = 0 ;i< cantProductores;i++){

                lecheProductor = calcularLecheProductor(i);

                if( lecheProductor > mayorCantidadLeche){

                    mayorCantidadLeche = lecheProductor;
                    indice = i;
                }
            }

            return listaProductores[indice];
        }

        /*****************************************************************
         * Rutina: calcularPagoProductores
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static String[] calcularPagoProductores(){

            String[] pagos=new String[cantProductores+1];
            int i;
            int totalLeche;
            double pagoProd, pagoTotal=0;



            for( i = 0;i< cantProductores ;i++)
            {
                totalLeche = calcularLecheProductor(i);
                pagoProd = totalLeche * precioLeche;
                pagos[i] = "Productor " + listaProductores[i] + ": ... " + pagoProd + " colones";
                pagoTotal += pagoProd;
            }

            pagos[pagos.length-1]= pagoTotal +"";

            return pagos;
        }

        /*****************************************************************
         * Rutina: calcularLecheProductor
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int calcularLecheProductor(int pindice){

            int numEntregas;
            int indiceInicial, indiceFinal, i;
            int totalLeche = 0;


            numEntregas = listaEntregas[pindice];
            indiceInicial = listaIndices[pindice];
            indiceFinal = indiceInicial + numEntregas;

            for(i = indiceInicial; i< indiceFinal;i++){

                totalLeche += listaProduccion[i];
            }

            return totalLeche;
        }

        /*****************************************************************
         * Rutina: calcularTotalLeche
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int calcularTotalLeche(){

            int totalLeche = 0;
            int i;

            for( i = 0; i< nuevoIndice;i++){

                totalLeche += listaProduccion[i];
            }

            return totalLeche;
        }

        /*****************************************************************
         * Rutina: obtenerMenorEntregas
         * Propósito: Determinar quién y de cuánto fue el menor número de entregas
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int[] obtenerMenorEntregas(){

            int[] datosMenor= new int[2];
            int i;
            int posicion;

            posicion = 0;

            for(i = 0; i< cantProductores;i++){

                if( listaEntregas[i] < listaEntregas[posicion]){

                    posicion = i;
                }
            }

            datosMenor[0] = listaProductores[posicion];
            datosMenor[1] = listaEntregas[posicion];

            return datosMenor;
        }

        /*****************************************************************
         * Rutina: obtenerEntregasProductor
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int obtenerEntregasProductor(int pnum){
            int entregas=0;
            int indice= buscarProductor(pnum);
            if(indice!=-1){

                entregas= listaEntregas[indice];
            }

            return entregas;
        }

        /*****************************************************************
         * Rutina: obtenerLecheProductor
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int obtenerLecheProductor(int pnum){

            int totalLeche=0;
            int indice= buscarProductor(pnum);

            if(indice!=-1){

                totalLeche = calcularLecheProductor(indice);
            }

            return totalLeche;
        }

        /*****************************************************************
         *
         * Rutina: obtenerTotalProductores
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int obtenerTotalProductores(){

            return cantProductores;

        }

        /*****************************************************************
         * Rutina: obtenerNuevoIndice
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int obtenerNuevoIndice(){

            return nuevoIndice;

        }

        /*****************************************************************
         * Rutina: obtenerListaProductores
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int[] obtenerListaProductores(){

            return listaProductores;
        }


    /*****************************************************************
     * Rutina: asignarEstrellas
     * Propósito:
     * Parámetro:
     *
     * Retorna:
     *****************************************************************/

    public static int[] asignarEstrellas(){

        return (asignarEstrellas());
    }

    /*****************************************************************
     * Rutina: totalBotellasRecibidas
     * Propósito:
     * Parámetro:
     *
     * Retorna:
     *****************************************************************/

    public static double totalBotellasRecibidas(){

        int totalBotellasRecibidas = 0;

        for (int i=0; i<listaProduccion.length; i++) {
            totalBotellasRecibidas = totalBotellasRecibidas + listaProduccion[i];
        }

        System.out.println("La cantidad total de botellas recibidas es: " +totalBotellasRecibidas);

        return totalBotellasRecibidas;

    }


        /*****************************************************************
         * Rutina: obtenerPromerioLeche
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static double promedioProdLeche(){

            int produccionTotalLeche = 0;
            int cont = 0;
            double promedioLeche=0;
            int cantEntregas=0;

            for (int i=0; i<listaProduccion.length; i++) {
                produccionTotalLeche = produccionTotalLeche + listaProduccion[i];
            }
            for (int i=0; i<listaEntregas.length; i++) {
                 cantEntregas = cantEntregas +listaEntregas[i];
            }

            promedioLeche = (double) produccionTotalLeche/ (double)cantEntregas;

            System.out.println("El promedio de botellas recibidas por la compañía es: " +promedioLeche);

            return promedioLeche;

    }


//    /*****************************************************************
//     * Rutina: asignacionDeEstrellas
//     * Propósito:
//     * Parámetro:
//     *
//     * Retorna:
//     *****************************************************************/
//
//    public static double asignacionDeEstrellas(){
//        int i;
//        int totalLechePorProductor;
//
//        for( i = 0;i< cantProductores ;i++) {
//            totalLechePorProductor = obtenerLecheProductor(i);
//        }
//
//        System.out.println("Total leche productor: " +totalLeche);
//
//
//        return asignacionDeEstrellas();
//    }




    /*****************************************************************
         * Rutina: obtenerListaEntregas
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int[] obtenerListaEntregas(){

            return listaEntregas;
        }

        /*****************************************************************
         * Rutina: obtenerListaIndices
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/

        public static int[] obtenerListaIndices(){

            return listaIndices;
        }

        /*****************************************************************
         * Rutina: modificarPrecioLeche
         * Propósito:
         * Parámetro:
         *
         * Retorna:
         *****************************************************************/


        public static void modificarPrecioLeche(double pPrecio)
        {

            precioLeche = pPrecio;

        }

    /*****************************************************************
     * Rutina: cantBotellasPorEntrega
     * Propósito: Dado el número de un productor, devolver la cantidad de botellas por cada entrega
     * Parámetro:
     *
     * Retorna:
     *****************************************************************/


    public static int cantBotellasPorEntrega(int pnum){

        boolean encontrado = false;
        int indice = -1;
        int i = 0;


        while(i < cantProductores && !encontrado){

            if(listaProductores[i] == pnum){

                encontrado = true;
                indice = i;
            }
            i += 1;
        }

        return indice;
    }


}
