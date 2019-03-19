/**
 * Nombre: Calcular la hipotenusa de un triángulo.
 * Descripción: Haga una rutina que dado dos lados de un triángulo, calcule la hipotenusa.
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

public class Ejercicio3 {

//    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

//    Main
    public static void main(String[] args) throws IOException {

//    Variables de entrada
        float cat1;
        float cat2;

//    Variables intermedias

//    Variables de salida
        float hipot;

//    Leer info
        System.out.println("Ingrese el valor de los catetos");
        cat1 = Float.parseFloat(leer.readLine());
        cat2 = Float.parseFloat(leer.readLine());

//    Proceso
        if (cat1>0 && cat2>0) {
            hipot = (float) Math.sqrt((Math.pow(cat1, 2)) + (Math.pow(cat2, 2)));
            System.out.println("La hipotenusa es " +hipot+ ".");
        } else {
            System.out.println("El valor de los catetos debe ser mayor a 0.");
        }

//    Salida: prints en los procesos
    }
}
