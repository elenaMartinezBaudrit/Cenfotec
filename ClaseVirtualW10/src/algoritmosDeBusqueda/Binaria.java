/**
 * Nombre: Buscar un elemento en un arreglo, mediante el método binario.
 * Descripción:  Se realizará una pequeña investigación para poner en funcionamiento las capacidades de administración de los arreglos.
 * Desarrolle una aplicación que permita mostrar los diferentes tipos de ordenamiento vistos en clase.
 * Fecha 06-04-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 12-04-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package algoritmosDeBusqueda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Binaria {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        Scanner entrada = new Scanner(System.in);

        int array[];
        int tamArr;
        int elemABuscar;
        int posicion;
        boolean ordenCreciente = true;

        System.out.println("Digite el tamaño del arreglo");
        tamArr= Integer.parseInt(leer.readLine());
        array = new int[tamArr];

        System.out.println();

        do {
            for (int i = 0; i < array.length; i++) {
                System.out.println("Ingrese el elemento " + (i + 1) + " del arreglo.");
                array[i] = Integer.parseInt(leer.readLine());
            }

            for (int i = 0; i < array.length-1; i++) {
                if(array[i] < array[i+1]) {
                    ordenCreciente = true;
                }
                if(array[i] > array[i+1]) {
                    ordenCreciente = false;
                    break;
                }
            }

            if(ordenCreciente == false) {
                System.out.println("Los elementos del arreglo deben estar ordenados de manera creciente. " +
                        "Ingrese el valor nuevamente.");
            }

        } while(ordenCreciente == false);

        System.out.println("Indique el elemento a buscar en el arreglo");
        elemABuscar = Integer.parseInt(leer.readLine());

        int i = 0;
        while(i<array.length && array[i]<elemABuscar) {
            i++;
        }

        if(i==array.length) {
            System.out.println("El número " +elemABuscar+ " no se encuentra en el arreglo.");
        } else {
            if(array[i] == elemABuscar) {
                System.out.println("El número " +elemABuscar+ " se encuentra en la posición " +(i+1));
            } else {
                System.out.println("El número no fue encontrado");
            }
        }
    }
}
