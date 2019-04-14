/**
 * Nombre: Tres en raya
 * Descripción: Programe el juego de gato (TIC-TAC-TOE o tres en línea) en forma completa. Debe indicar quien ganó.
 *      Debe especificar quien inicia de primero si jugador X o jugador Y (ésto se hace de forma aleatoria).
 * Fecha 08-04-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 12-04-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package tarea9;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TresEnRaya {

    static Scanner in;
    static String[] tablero;
    static String turno;

    public static void main(String[] args) {
        Random rand = new Random();
        int quienEmpieza;
        in = new Scanner(System.in);
        tablero = new String[9];
        turno = "X";
        String ganador = null;
        imprimirTableroVario();

        System.out.println("Quieren jugar Tres En Línea? Comencemos!");
        System.out.println("Primero tenemos que ver quien jugará primero. El primer jugador comenzará con X");
        quienEmpieza = rand.nextInt(2);
        if (quienEmpieza == 0 ) {
            quienEmpieza = 1;
        } else {
            quienEmpieza = 2;
        }
        System.out.println("Comienza el jugador " +quienEmpieza);

        System.out.println("Este es el tablero: ");
        System.out.println();
        imprimirTablero();
        System.out.println();
        System.out.println("Se comienza con X. Indique el número de la casilla donde quiere jugar:");

        while (ganador == null) {
            int tiro;
            tiro = in.nextInt();

            if (!(tiro > 0 && tiro <= 9)) {
                System.out.println("La opción es inválida. Pr favor, ingrese el número de la casilla donde quiere jugar: ");
                continue;
            }

            if (tablero[tiro-1].equals(String.valueOf(tiro))) {
                tablero[tiro-1] = turno;
                if (turno.equals("X")) {
                    turno = "O";
                } else {
                    turno = "X";
                }
                imprimirTablero();
                ganador = revisarSiGano();
            } else {
                System.out.println("Esa casilla ya ha sido tomada. Ingrese otro número: ");
                continue;
            }
        }
        if (ganador.equalsIgnoreCase("empate")) {
            System.out.println("Es un empate! Gracias por jugar Tres En Raya");
        } else {
            System.out.println("Felicidades! El jugador "+ quienEmpieza + " es el ganador! Gracias por jugar Tres En Raya");
        }
    }

    static String revisarSiGano() {
        for (int i = 0; i < tablero.length-1; i++) {
            String raya = null;
            switch (i) {
                case 0:
                    raya = tablero[0] + tablero[1] + tablero[2];
                    break;
                case 1:
                    raya = tablero[3] + tablero[4] + tablero[5];
                    break;
                case 2:
                    raya = tablero[6] + tablero[7] + tablero[8];
                    break;
                case 3:
                    raya = tablero[0] + tablero[3] + tablero[6];
                    break;
                case 4:
                    raya = tablero[1] + tablero[4] + tablero[7];
                    break;
                case 5:
                    raya = tablero[2] + tablero[5] + tablero[8];
                    break;
                case 6:
                    raya = tablero[0] + tablero[4] + tablero[8];
                    break;
                case 7:
                    raya = tablero[2] + tablero[4] + tablero[6];
                    break;
            }
            if (raya.equals("XXX")) {
                return "X";
            } else {
                if (raya.equals("OOO")) {
                    return "O";
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(tablero).contains(String.valueOf(i+1))) {
                break;
            }
            else {
                if (i == 8) {
                    return "empate";
                }
            }
        }

        System.out.println("'" + turno + "'" + " es quien continua. Ingrese el número de casilla donde quiere colocar " + turno + ".");
        return null;
    }

    static void imprimirTablero() {
        System.out.println("-------------");
        System.out.println("| " + tablero[0] + " | " + tablero[1] + " | " + tablero[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tablero[3] + " | " + tablero[4] + " | " + tablero[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tablero[6] + " | " + tablero[7] + " | " + tablero[8] + " |");
        System.out.println("-------------");
    }

    static void imprimirTableroVario() {
        for (int a = 0; a < 9; a++) {
            tablero[a] = String.valueOf(a+1);
        }
    }
}

