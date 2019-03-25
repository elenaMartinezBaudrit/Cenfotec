/**
 * Nombre: Imprimir arreglo de enteros.
 * Descripción:  Haga un procedimiento que imprima un arreglo de enteros y pruébelo en el programa del ejercicio 1.
 * Fecha 19-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 22-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ImprimirArregloDeEnteros {

    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {

//    Variables
        int[] printArray = new int[6];
        int cont;
        int totalCont = 0;

//    Proceso
        for (cont = 0; cont < 6; cont++) {
            System.out.println("Ingrese el número que ocupará el lugar " + (cont + 1) + " de este arreglo.");
            printArray[cont] = Integer.parseInt(leer.readLine());
            totalCont += printArray[cont];
        }
//    Salida
        System.out.println("El arreglo de los valores ingresados es: " +Arrays.toString(printArray));
    }
}