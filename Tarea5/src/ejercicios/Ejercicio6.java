/**
 * Nombre: Determinar si el número ingresado es un número de Amstrong
 * Descripción: Escriba un programa que dado un número entero diga si el número es un número de Amstrong.
 *      Se dice que un número es de Amstrong si la suma de sus dígitos elevados al número de dígitos es igual al número.
 *      Por ejemplo:  153 = 13 + 53 +33 =1 + 125 + 27 = 153
 * Fecha 10-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 10-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio6 {
    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {

//    Variables de entrada
        int num;

//    Variables intermedias
        int count=0, digit;

//    Variables de salida
        int temp;
//    Leer info
        System.out.println("Ingrese un número para comprobar si es un número de Armstrong");
        num = Integer.parseInt(leer.readLine());

        temp = num;

//    Proceso
        while (num>0) {
           digit=num%10;
            num = num/10;
            count = count+(digit*digit*digit);
        }

//    Salida
        if(temp==count) {
            System.out.println("Sí es número de Armstrong.");
        } else {
            System.out.println("No es un número de Armstrong");
        }
    }
}