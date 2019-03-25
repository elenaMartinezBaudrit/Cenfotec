/**
 * Nombre: Crear 2 arreglos y compararlos
 * Descripción:  Haga una función que reciba dos arreglos de enteros y que retorne true
 *      si los arreglos son iguales o false si no. Pruébela en un programa
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

public class LaFuncionDeDosArreglos {
    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {

//    Variables arreglo 1
        int[] arreglo1;
        int n;

//    Variables arreglo 2
        int[] arreglo2;
        int m;

//        Variables generales
        int count = 0;


//        Leer - arreglo1
        System.out.println("Ingrese el tamaño del primer arreglo.");
        n = Integer.parseInt(leer.readLine());
        arreglo1 = new int[n];
        primerArreglo(arreglo1);

//        Leer - arreglo2
        System.out.println("Ingrese el tamaño del segundo arreglo.");
        m = Integer.parseInt(leer.readLine());
        arreglo2 = new int[m];
        segundoArreglo(arreglo2);

        for (int i = 0; i<arreglo1.length; i++){
            if (arreglo1[i] == arreglo2[i]) {
                count+=1;
            }
        }

        if (count == arreglo1.length && count == arreglo2.length) {
            System.out.println("Los arreglos " + Arrays.toString(arreglo1) + " y " + Arrays.toString(arreglo2) + " son iguales");
        } else {
            System.out.println("Los arreglos " + Arrays.toString(arreglo1) + " y " + Arrays.toString(arreglo2)+" no son iguales");
        }
    }

    static void primerArreglo(int[] pa) throws IOException {
        int totalCont1;
        for (totalCont1 = 0; totalCont1 < pa.length; totalCont1++) {
            System.out.println("Ingrese el elemento " + (totalCont1 + 1) + " del arreglo 1: ");
            pa[totalCont1] = Integer.parseInt(leer.readLine());
        }
    }

    static void segundoArreglo(int[] sa) throws IOException {
        int totalCont2;
        for (totalCont2 = 0; totalCont2 < sa.length; totalCont2++) {
            System.out.println("Ingrese el elemento " + (totalCont2+ 1) + " del arreglo 2: ");
            sa[totalCont2] = Integer.parseInt(leer.readLine());
        }
    }
}

