/**
 * Nombre: Haga un algoritmo que dado un número binario N (entero y positivo), calcule a qué valor corresponde N en base 10.
 * Descripción: Haga un algoritmo que dado un número binario N (entero y positivo), calcule a qué valor corresponde N en base 10.
 *      Ej: 11011 en binario, es 27 en base 10.
 * Fecha 10-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 10-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5 {
    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {


//    Variables de entrada
        int num;

//    Variables intermedias

//    Variables de salida
        int decimal = 0;
        int p = 0;

//    Lectura info
        System.out.println("Ingrese el número binario que desea convertir en base 10.");
        num = Integer.parseInt(leer.readLine());

//    Proceso
        while (num!=0) {
            decimal += (num%10) * Math.pow(2, p);
            num= num/10;
            p++;
        }

//    Salida
        System.out.println("El quivalente decimal del número " + num + " es: " + decimal + ".");
    }
}
