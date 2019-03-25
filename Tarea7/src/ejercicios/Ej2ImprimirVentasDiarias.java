/**
 * Nombre: Imprimir las ventas diarias.
 * Descripción: Modifique el programa del punto 1, para que ahora también imprima todas las ventas de la semana.
 * Fecha 19-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 22-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2ImprimirVentasDiarias {

    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        double[] ventaDiaria = new double[6];
        int cont = 0;
        double ventaTotal = 0;

        for (cont=0; cont< ventaDiaria.length; cont++){
            System.out.println("Ingrese el monto total de ventas del día " + (cont + 1) + ".");
            ventaDiaria[cont] = Double.parseDouble(leer.readLine());
            ventaTotal += ventaDiaria[cont];
        }

        for (cont=0; cont< ventaDiaria.length; cont++){
            System.out.println("El monto de ventas del día " +(cont+1)+ " es " +ventaDiaria[cont]+ ".");
        }
        System.out.println();
        System.out.println("El monto total de ventas es: " + ventaTotal+ ".");

    }

}
