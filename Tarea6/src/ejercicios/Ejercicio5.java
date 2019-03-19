/**
 * Nombre: El juego de "Picas y Fijas"
 * Descripción: Suponga que usted va a implementar en el computador el juego  “Picas y Fijas”.
 *      Este juego consiste en adivinar un número de 4 dígitos diferentes en 10 intentos máximo.
 *      Para esto usted debe decirle al computador un número de 4 dígitos y el computador le contesta
 *          el número de picas y el número de fijas, hasta que usted adivine el número.
 *      Usted tiene una pica si el número que usted dijo tiene un dígito que coincide con un dígito del
 *          número a adivinar, pero está en diferente posición. Ej: si el número a adivinar es 4879 y usted tecleó 8453,
 *          tiene 2 picas (por el 8 y el 4).
 *      Usted tiene una fija si el número que usted dijo tiene un dígito que coincide con un dígito del número a
 *          adivinar, en la misma posición. Ej: si el número a adivinar es 4879 y usted tecleó 6859, tiene 2 fijas
*           (por el 8 y el 9).
 *      Realice:
 *          (30%) Haga una función numeroPicas que reciba el número a adivinar y el número tecleado por el usuario,
 *              y retorne el número de picas que tiene. (15% algoritmo, 15% en Java).
 *          (30%) Haga una función numeroFijas que reciba el número a adivinar y el número tecleado por el usuario,
 *              y retorne el número de fijas que tiene. (15% algoritmo, 15% en Java).
 *          (20%) Haga una función ganoJuego que reciba el número a adivinar y el número tecleado por el usuario,
 *              y retorne true si ganó el juego (es decir, si tiene 4 fijas) o false si no. (10% algoritmo, 10% en Java).
 *          (20%) Haga un programa PicasYFijas, que dado el número a adivinar (inicializado por usted),
 *              lea los números dados por el usuario hasta que el usuario gane o hasta que se cumplan los 10 intentos.
*               (3% modelaje, 7% algoritmo y 10% en Java).
 * Fecha 16-03-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 16-03-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math.*;
import java.text.Collator;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio5 {
//    Variables generales I/O
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

//    Main
    public static void main(String[] args) throws IOException {

//    Variables de entrada
        Random rand = new Random();
        String secretNumber = String.format("%04d", rand.nextInt(10000));
        System.out.println(secretNumber);
        int intentos = 0;
        String userGuess;

//    Variables intermedias
        int i = 0;
        int picas = 0;
        int j = 0;
        int temp = 0;

//    Variables de salida
        boolean ganoJuego = false;

//    Leer info
        Scanner scan = new Scanner(System.in);
        System.out.println("¿Quieres adivinar el número secreto? Ingresa el número que crees correcto");
        userGuess = scan.nextLine();
        System.out.println("el numero ingresado es " + userGuess);

//    Proceso
            while (intentos <9 && userGuess!=secretNumber && ganoJuego!=true) {
                intentos = intentos+1;
                int intentosRestantes = 10- intentos;
                int fijas = 0;
                temp = 0;
                if(userGuess.length()!=secretNumber.length()){
                    System.out.println("El número que debes adivinar es de 4 dígitos. Inténtalo nuevamente");
                } else {
                    if (userGuess.equals(secretNumber)) {
                        ganoJuego = true;
                        System.out.println("Has adivinado el número secreto!");
                    } else {
                        for (i = 0; i != userGuess.length(); i++) {
                            char c = userGuess.charAt(i);
                            char d = secretNumber.charAt(i);
                            if (c == d) {
                                fijas += 1;
                            } else {
                                for (j = 0; j != secretNumber.length(); j++) {
                                    if (c == secretNumber.charAt(j)) {
                                        temp = temp + 1;
                                    }
                                }
                            }
                        }
                        System.out.println("Fijas: " + fijas);
                        picas = 4 - fijas;
                    }

                    System.out.println("posible picas " + temp);
                    System.out.println("Tu intento tiene " + fijas + " fijas y " +picas+" picas. Te queddan " + intentosRestantes + ". Intenta nuevamente agregando otro número");
                    userGuess = scan.nextLine();
                }
            }
        System.out.println("Gracias por jugar Picas y Fijas! Hasta luego!");
    }
}
