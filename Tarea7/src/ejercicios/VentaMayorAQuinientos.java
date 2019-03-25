/**
 * Nombre: Imprimir el día en que se vendió máa de $500
 * Descripción: Modifique el programa del punto 1, para que ahora también averigüe si hay alguna venta de la semana
 *      que fue mayor o igual a $500, e imprima el día correspondiente a esa venta.or venta de la semana.
 * Fecha 19-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 22-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VentaMayorAQuinientos {


    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        double[] ventaDiaria = new double[6];
        int cont = 0;
        double ventaTotal = 0;
        double ventaMayor = 0;
        double ventaMayor500 = 0;
        int contVentaMayor500 = 0;

//        Venta total de la semana
        for (cont=0; cont< ventaDiaria.length; cont++){
            System.out.println("Ingrese el monto total de ventas del día " + (cont + 1) + ".");
            ventaDiaria[cont] = Double.parseDouble(leer.readLine());
            ventaTotal += ventaDiaria[cont];
        }
        System.out.println();
        System.out.println("El monto total de ventas es: $" + ventaTotal+ ".");
        System.out.println();

//        Imprimir venta diaria
        for (cont=0; cont< ventaDiaria.length; cont++){
            System.out.println("El monto de ventas del día " +(cont+1)+ " es $" +ventaDiaria[cont]+ ".");
            if (ventaDiaria[cont]> ventaMayor) {
                ventaMayor = ventaDiaria[cont];
            }
        }
        System.out.println();
        System.out.println("El monto de la venta mayor es: $" +ventaMayor);

//        Venta mayor a 500
        for (cont=0; cont< ventaDiaria.length; cont++){
            if (ventaDiaria[cont]>=500){
                ventaMayor500 = ventaDiaria[cont];
                contVentaMayor500 +=1;
                System.out.println("El día " +(cont+1)+ " hubo una venta igual o mayor a $500, por un monto de: $" +ventaMayor500+ ".");
            }
        }
        if (contVentaMayor500==0) {
            System.out.println("Esta semana no se registraron ventas diarias mayores a %500");
        }
    }
}
