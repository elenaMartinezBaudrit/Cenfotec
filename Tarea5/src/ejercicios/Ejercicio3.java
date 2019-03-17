/**
 * Nombre: Leer, mientras se desee continuar, las notas de un estudiante. Imprimir el número de cursos ganados, el número de cursos perdidos y el promedio general
 * Descripción: Leer, mientras se desee continuar, las notas de un estudiante y al final imprimir el número de cursos ganados,
 *      el número de cursos perdidos y el promedio general. Cursos ganados son aquellos >= 70 y perdidos son aquellos < 70.
 * Fecha 10-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 10-03-2019.
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
        int nota = 0;
        int apr = 70;
        char agrNota;

//    Variables intermedias
        int sum = 0;
        int cantNotas = 0;

//    Variables de salida
        float prom;
        int cantRepr = 0;
        int cantApr = 0;

//    Lectura info --> Dentro del do-while

//    Proceso
        do {
            System.out.println("Agregue una nota");
            nota = Integer.parseInt(leer.readLine());
            cantNotas = cantNotas + 1;
            sum = sum + nota;
            if (nota>=apr) {
                cantApr = cantApr + 1;
            } else {
                cantRepr = cantRepr + 1;
            }
            System.out.println("¿Desea agregar otra nota? S/N");
            agrNota = leer.readLine().charAt(0);
        } while (agrNota == 'S' || agrNota== 's');
        prom = sum/cantNotas;

//    Salida
        System.out.println("El promedio final es: " +prom+ ". Se aprobaron " +cantApr+
                " cursos, y se reprobaron " + cantRepr + ".");
    }
}
