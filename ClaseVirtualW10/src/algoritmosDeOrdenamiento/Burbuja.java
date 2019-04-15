/**
 * Nombre: Ordenar el arreglo con el método burbuja
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

public class Burbuja {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public static void main (String args[]) throws IOException {

        int array[];
        int tam;

        System.out.println("Digite el tamaño del arreglo");
        tam = Integer.parseInt(in.readLine());
        array = new int[tam];

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el elemento " +(i+1)+ " del arreglo: ");
            array[i] = Integer.parseInt(in.readLine());
        }
        ordenamientoBurbuja(array);
    }

    static void ordenamientoBurbuja (int[] arregloBurb) {

//        Control de recorridos
        for (int i= arregloBurb.length-1; i>0; i--) {
//            Va comparando
            for (int k=0; k<i; k++) {
                if (arregloBurb[k]>arregloBurb[k+1]) {
//                    Intercambia
                    int temp = arregloBurb[k+1];
                    arregloBurb[k+1] = arregloBurb[k];
                    arregloBurb[k] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arregloBurb));
        }
    }

