/**
 * Nombre: Rutina para retornar el mayor y el menor de dos números
 * Descripción: Haga una rutina que retorne el máximo entre dos números y otra que retorne el mínimo entre dos números.
 *      Pruébelas en un main.
 * Fecha 16-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 16-03-2019.
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
        int n1;
        int n2;

//    Variables intermedias

//    Variables de salida
        int nMayor;
        int nMenor;

//    Leer info
        System.out.println("Ingrese los dos números que quiere comparar");
        n1 = Integer.parseInt(leer.readLine());
        n2 = Integer.parseInt(leer.readLine());

//    Proceso
        if (n1 != n2) {
            if (n1>n2) {
                nMayor = n1;
                nMenor = n2;
            } else {
                nMayor = n2;
                nMenor = n1;
            }
            System.out.println("El número menor es " + nMenor + ", y el mayor es " + nMayor + ".");
        } else {
            System.out.println("Los números ingresados tienen el mismo valor");
        }
//    Salida: los prints dentro del proceso
    }
}
