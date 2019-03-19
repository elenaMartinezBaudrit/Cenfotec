/**
 * Nombre: Calcular el menor de 3 números reales
 * Descripción: Haga una rutina que calcule el mínimo de 3 números reales.
 *      Pruébela en un main.
 * Fecha 16-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 16-03-2019.
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
        int n1;
        int n2;
        int n3;

//    Variables intermedias

//    Variables de salida
        int nMenor;

//    Leer info
        System.out.println("Ingrese los 3 números que quiere comparar para encontrar el de menor valor");
        n1 =  Integer.parseInt(leer.readLine());
        n2 = Integer.parseInt(leer.readLine());
        n3 = Integer.parseInt(leer.readLine());

//    Proceso

        if (n1!=n2 && n1!=n3 && n2!=n3) {
            if (n1 < n2) {
                if (n1 < n3) {
                    nMenor = n1;
                } else {
                    nMenor = n3;
                }
            } else {
                if (n2 < n3) {
                    nMenor = n2;
                } else {
                    nMenor = n3;
                }
            }
            System.out.println("El número menor es: " +nMenor+ ".");
        } else {
            System.out.println("Por favor, ingrese 3 números diferentes");
        }
//    Salida

    }
}
