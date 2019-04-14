/**
 * Nombre: Crear una matriz, determinar promedios y salir
 * Descripción:  Crear una matriz (se debe validar que máximo debe ser de 5x5). El tamaño se le solicita al usuario.
 * 	Llenar la matriz creada.
 * 	Mostrar la matriz.
 * 	Obtener el promedio de una fila determinada.
 * 	Obtener el promedio de una columna determinada.
 * 	Mostrar el promedio general.
 * 	Salir.
 * Fecha 08-04-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 12-04-2019.
 * Modificado por: Elena Martínez Baudrit.
 */


package tarea9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Matrices {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner((System.in));
        int matriz[][], nFilas, nCol;
        int sumaFila = 0;
        int contFila = 0;
        int sumaCol = 0;
        int sumaMatriz = 0;
        int countMatriz = 0;
        int opcionMenu = 0;

        System.out.println("Ingresa el número de filas de la matriz");
        nFilas = Integer.parseInt(leer.readLine());
        System.out.println("Ingresa el número de columnas");
        nCol = Integer.parseInt(leer.readLine());
        while (nFilas >= 1 && nCol >= 1) {
            if (nFilas > 5 && nCol > 5) {
                System.out.println("La matriz debe tener un valor máximo de 5 filas y 5 columnas. Inténtalo nuevamente");
                nFilas = -1;
            } else {
                matriz = new int[nFilas][nCol];

                //        For para pedir los valores de la matriz
                System.out.println("Digita los valores de la matriz");
                for (int i = 0; i < nFilas; i++) {
                    for (int j = 0; j < nCol; j++) {
                        System.out.print("Matriz [" + i + "] [" + j + "]: ");
                        matriz[i][j] = entrada.nextInt();
                    }
                }

                //        For para imprimir la matriz
                System.out.println("\nLa matriz es: ");
                for (int i = 0; i < matriz.length; i++) {
                    contFila = contFila + 1;
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.print(matriz[i][j] + " ");
                        sumaMatriz = sumaMatriz + matriz[i][j];
                        countMatriz = countMatriz + 1;
                    }
                    System.out.println("");
                }

                while (nFilas != -1) {
                    //                Menu para ver las opciones
                    System.out.println("Escoge la opción del siguiente menú: 1) Calcular el promedio de una fila. " +
                            "2) Calcular el promedio de una columna. 3) Calcular el promedio de la matriz. 4) Salir del programa.");
                    opcionMenu = Integer.parseInt(leer.readLine());

                    switch (opcionMenu) {
                        case 1:
                            //                        Promedio de fila
                            System.out.println("Indique el número de fila del que quiere calcular el promedio");
                            int numFilaSelec = Integer.parseInt(leer.readLine());
                            int indexFila = numFilaSelec - 1;
                            int hastaDondeLlegaElFor = nFilas - 1;
                            int countParaFila = 0;
                            System.out.println("Los valores correspondientes a la columna " + numFilaSelec + " son: ");
                            for (int j = 0; j <= hastaDondeLlegaElFor; j++) {
                                countParaFila = countParaFila + 1;
                                System.out.print(matriz[indexFila][j] + " ");
                                sumaFila = sumaFila + matriz[indexFila][j];
                            }
                            System.out.println();
                            float promFila = (float) sumaFila / (float) countParaFila;
                            System.out.println("Suma de la fila " + numFilaSelec + " es:" + sumaFila);
                            System.out.println("El promedio de los valores de la fila " + numFilaSelec + " es: " + promFila);
                            break;

                        case 2:
//                        Promedio columna
                            System.out.println("Indique el número de columna del que quiere calcular el promedio");
                            int numColSelec = Integer.parseInt(leer.readLine());
                            int indexCol = numColSelec - 1;
                            int hastaDondeLlegaElForCol = nCol - 1;
                            int countParaCol = 0;
                            System.out.println("Los valores correspondientes a la columna " + numColSelec + " son: ");
                            for (int i = 0; i <= hastaDondeLlegaElForCol; i++) {
                                countParaCol = countParaCol + 1;
                                sumaCol = sumaCol + matriz[i][indexCol];
                            }
                            float promCol = (float) sumaCol / (float) countParaCol;
                            System.out.println("Suma de la columna " + numColSelec + " es:" + sumaCol);
                            System.out.println("El promedio de los valores de la columna " + numColSelec + " es: " + promCol);
                            break;

                        case 3:
//                            Promedio de la matriz
                            float promMatriz = (float) sumaMatriz / (float) countMatriz;
                            System.out.println("Suma matriz: " + sumaMatriz);
                            System.out.println("El promedio de los valores de la matriz es " + promMatriz);
                            break;

                        case 4:
//                            Salir
                            nFilas = -1;
                    }
                    System.out.println("Desea ver nuevamente el menú? 1) Sí. 2) No");
                    opcionMenu = Integer.parseInt(leer.readLine());
                    if (opcionMenu == 2) {
                        nFilas = -1;
                    }
                }

                System.out.println("Gracias por usar este programa!");
            }
        }
    }
}
