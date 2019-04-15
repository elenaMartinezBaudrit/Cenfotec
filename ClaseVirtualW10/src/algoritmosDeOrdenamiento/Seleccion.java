/**
 * Nombre: Ordenar el arreglo con el método de selección
 * Descripción:  Se realizará una pequeña investigación para poner en funcionamiento las capacidades de administración de los arreglos.
 * Desarrolle una aplicación que permita mostrar los diferentes tipos de ordenamiento vistos en clase.
 * Fecha 06-04-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 12-04-2019.
 * Modificado por: Elena Martínez Baudrit.
 */


package algoritmosDeOrdenamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Seleccion {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public static void main (String args[]) throws IOException {

        int array[];
        int tam;

        System.out.println("Digite el tamaño del arreglo");
        tam = Integer.parseInt(in.readLine());
        array = new int[tam];

        System.out.println();

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el elemento " +(i+1)+ " del arreglo: ");
            array[i] = Integer.parseInt(in.readLine());
        }
        ordenamientoSeleccion(array);
    }

    static void ordenamientoSeleccion (int arrSel[]) {

        int i, k, pos, max, aux;

//        Controla los recorridos
        for (i = arrSel.length-1; i>0; i--) {
//            Localiza el mayor
            for (k=0, max=arrSel[0], pos = 0; k<=i; k++) {
                if (arrSel[k] > max) {
//                    max tiene el valor del mayor
                    max = arrSel[k];
//                    pos tiene la posicion del mayor en a
                    pos = k;
                }
            }
//            Intercambio del mayor con el elemento que esta en la posicion i
            aux = arrSel[pos];
            arrSel[pos] = arrSel[i];
            arrSel[i] = aux;
        }
        System.out.println(Arrays.toString(arrSel));
    }

}
