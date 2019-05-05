package testBingo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;


public class IUBingo {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;	// variables objetos in y out para
    static int BOARD_SIZE = 5;
    static int[][] card = new int[BOARD_SIZE][BOARD_SIZE];


    /******************************************************************
     * Modulo Principal que permite ejecutar la aplicaci?n
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
     * Prop?sito: Presentar el men? de opciones
     * Par?metros:
     *
     * Retorna:
     *****************************************************************/

    static void mostrarMenu(){

        out.println();
        out.println("1.  Generar cartones");
        out.println("2.  Jugar a carton lleno");
        out.println("3.  Jugar 4 esquinas");
        out.println("4.  Salir");
        out.println();
    }

    /*****************************************************************
     * Rutina: leerOpcion
     * Prop?sito: Obtener del usuario la opc??n escogida
     * Par?metros:
     *
     * Retorna:
     *****************************************************************/

    static int leerOpcion()throws java.io.IOException{

        int opcion;

        out.print("Seleccione su opci\u00a2n: ");
        opcion = Integer.parseInt(in.readLine());
        out.println();

        return opcion;
    }

    /*****************************************************************
     * Rutina: ejecutarAccion
     * Prop?sito: Ejecutar la acci?n que corresponde a la opc??n escogida
     * Par?metro: popcion
     *
     * Retorna: boolean
     *			Un valor que indica si se desea continuar o salir del men?
     *****************************************************************/

    static boolean ejecutarAccion(int popcion)throws java.io.IOException{


        boolean noSalir = true;
        int numProd=0;


//            if (popcion >= 2 && popcion <= 8 && Rutinas.obtenerTotalProductores() == 0){
//                out.println("No hay registrados productores");
//                return noSalir;
//            }

        switch(popcion){


            case 1: //Imprimir los cartones
//                TODO: imprimir un par de cartones. En las instrucciones decía que hay que imprimirlos. No indica que se deben usar para jugar, así que todo bien.
                System.out.println("IMPRIMIR AQUI UN PAR DE CARTONES SE VERIA SUPER LINDO");
                break;

            case 2: //Jugar Bingo carton lleno, numeros de bolos generados aleatoriamente
                Rutinas.cartonLleno();
                break;

            case 3:// 'Opcion Jugar 4 esquinas

                out.println();
                Rutinas.cuatroEsquinas();
                out.println("Se a elegido el juego 4 esquinas");
                break;

            case 4: //Salir de la aplicacion
                noSalir = false;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inv?lido

                out.println("Opcion inv\u00a0lida");
                out.println();
                break;
        }
        return noSalir;
    }
}
