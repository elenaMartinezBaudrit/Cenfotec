/**
 * Nombre: Buscar un elemento en un arreglo, mediante el método lineal
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

public class Lineal {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String args[]) throws IOException {

        int array[];
        int tam;
        int elem;
        int posicion;

        System.out.println("Digite el tamaño del arreglo");
        tam = Integer.parseInt(leer.readLine());
        array = new int[tam];

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el elemento " + (i + 1) + " del arreglo: ");
            array[i] = Integer.parseInt(leer.readLine());
        }

        System.out.println("Indique el elemento a buscar en el arreglo");
        elem = Integer.parseInt(leer.readLine());

        posicion = busquedaLineal(array, elem);
        System.out.println("El elemento a buscar, " +elem+ " se encuentra en la posicion " +(posicion+1));

    }

        static int busquedaLineal ( int[] arrLineal, int elem) throws IOException{
            int posicion = -1;
            int i;
            for (i = 0; i < arrLineal.length; i++) {
                if (arrLineal[i] == elem) {
                    posicion = i;
                    return posicion;
                }
            }
            return -1;
        }
    }

