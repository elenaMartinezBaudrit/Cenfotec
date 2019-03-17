/**
 * Nombre: : Calcular el factorial de un número entero positivo.
 * Descripción: Calcular el factorial de un número entero positivo. n! Se lee “n factorial” y
 *       n! = 1*2*3*..*n-1*n. Ejemplo: 5! = 1*2*3*4*5 = 120
 * Fecha 10-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 10-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {


//    Variables de entrada
        int num;

//    Variables intermedias
        int i = 1;

//    Variables de salida
        int nFact =1;

//    Leer info
        System.out.println("Ingrese el número del que quiere calcular el factorial");
        num = Integer.parseInt(leer.readLine());

//    Proceso
        for (i=1; i<=num; i++) {
            nFact = nFact*i;
        }

//    Salida
        System.out.println("El factorial de " + num + " es: " + nFact + ".");
    }
}
