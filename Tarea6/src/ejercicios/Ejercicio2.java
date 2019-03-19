/**
 * Nombre: Calcular el cubo de un número
 * Descripción: Haga una rutina que calcule el cubo de un número. Pruébela en un main.
 * Fecha 16-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 16-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

//    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

//    Main
    public static void main(String[] args) throws IOException {

//    Variables de entrada
        int num;

//    Variables intermedias

//    Variables de salida
        int cubo;

//    Leer info
        System.out.println("Ingrese en número al que quiere calcular el cubo");
        num = Integer.parseInt(leer.readLine());

//    Proceso
        cubo =(int) Math.pow(num, 3);

//    Salida
        System.out.println("El cubo de " +num+ " es " +cubo+ ".");
    }
}