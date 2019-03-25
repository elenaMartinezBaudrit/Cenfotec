/**
 * Nombre: agregar las ventas de 6 dias e imprimir el total
 * Descripción: Suponga que trabaja en un almacén y necesita guardar los valores de las ventas de cada día hábil de la semana.
 *      Para esto usted tiene un arreglo con las ventas de cada día de la semana, suponga que sólo hay 6 días hábiles.
 *      Haga un programa que calcule el total de ventas de la semana.
 * Fecha 19-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 22-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej1VentaTotalSemanal {

    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {

//    Variables
        double[] ventaDiaria = new double[6];
        int cont;
        double ventaTotal = 0;
        double montoVentaDia = 0;

//    Proceso
        for (cont = 0; cont<6; cont++) {
            System.out.println("Ingrese el monto total de ventas del día " + (cont + 1) + ".");
            ventaDiaria[cont] = Double.parseDouble(leer.readLine());
            ventaTotal += ventaDiaria[cont];
        }
//    Salida
        System.out.println(montoVentaDia);
        System.out.println("El monto total de ventas es: " + ventaTotal+ ".");

    }
}
