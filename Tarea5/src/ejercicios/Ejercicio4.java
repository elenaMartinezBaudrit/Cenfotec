/**
 * Nombre: Hallar el número de dígitos de un número entero positivo.
 * Descripción: Hallar el número de dígitos de un número entero positivo.
 * Fecha 10-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 10-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {
    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {

//    Variables de entrada
        int num;

//    Variables intermedias

//    Variables de salida
        int totDig = 0;

//    Leer info
        System.out.println("Ingrese el número del que quiere saber la cantidad de dígitos que contiene.");
        num = Integer.parseInt(leer.readLine());

//    Proceso
        while(num>0) {
            totDig += 1;
            num = num/10;
        }

//    Salida
        System.out.println("La cantidad de dígitos es " + totDig + ".");
    }
}
