/**
 * Nombre: Calcular el valor total de la llamada de cada uno de los clientes de una empresa de teléfonos.
 * Descripción: : Una empresa de teléfonos quiere calcular el valor total de la llamada de cada uno de sus N clientes,  de la siguiente forma:
 *  •	Toda llamada que dure hasta 3 minutos y sea de clase A, cuesta ¢300.
 *  •	Cada minuto adicional de llamadas de clase A, a partir de los primeros 3 cuesta ¢150.
 *  •	Si la llamada es de clase B, cuesta ¢400 por minuto, no importa su duración.
 * Fecha 10-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 10-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7 {
    //    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    //    Main
    public static void main(String[] args) throws IOException {

//        Variables de entrada
        int minClaseA = 3, valClaseA = 300, minAdicClaseA = 150, minClaseB = 400, minuto, extra, totAdic;
        String claseLlamada;

//        Variables de salida
        int total = 0;

//        Lectura de informacion
        System.out.println("Digite la clase del cliente (A o B): ");
        claseLlamada = leer.readLine();

        System.out.println("Digite los minutos hablados por el cliente: ");
        minuto = Integer.parseInt(leer.readLine());

//        Proceso
        if (claseLlamada.toLowerCase().equals("a")) {
            if (minuto <= 3) {
                total = valClaseA;
            } else{
                extra = minuto - minClaseA;
                totAdic = extra*minAdicClaseA;
                total = valClaseA + totAdic;
            }
        } else if ( claseLlamada.toLowerCase().equals("b")) {
            total = minuto*minClaseB;
        }
        //        Salida
        System.out.println("El total a pagar es: " + total);
    }
//    Fin del main
}
// Fin del programa