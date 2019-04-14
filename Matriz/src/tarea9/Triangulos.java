/**
 * Nombre: CTriangulo Superior, Triangulo Inferior, Matriz Diagonal.
 * Descripción:  Haga una función que reciba una matriz de enteros y retorne true si la matriz es triangular superior, o false si no.
 *      Una matriz es triangular superior si todos los elementos por debajo de la diagonal principal son iguales a cero.
 *      Haga una función que reciba una matriz de enteros y retorne true si la matriz es triangular inferior, o false si no.
 *      Una matriz es triangular inferior si todos los elementos por encima de la diagonal principal son iguales a cero.
 *      Haga una función que reciba una matriz de enteros y retorne true si la matriz es diagonal, o false si no.
 *      Una matriz es diagonal si todos los elementos que están en la diagonal principal son diferentes de cero
 *      y la matriz es triangular inferior y superior.
 *  Fecha 08-04-2019.
 * Autor: Elena Martínez Baudrit.
 * Fecha de modificación: 12-04-2019.
 * Modificado por: Elena Martínez Baudrit.
 */

package tarea9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Triangulos {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException {

        Scanner entrada = new Scanner((System.in));
        int matriz[][], nFilas, nCol;
        int contFila = 0;
        int contTriangInf = 0;
        int cont2TriangInf = 0;
        int contTriangSup = 0;
        int cont2TriangSup = 0;
        boolean triangSup;
        boolean triangInf;
        boolean matrizDiagonal;

        System.out.println("Ingresa el número de filas de la matriz");
        nFilas = Integer.parseInt(leer.readLine());
        System.out.println("Ingresa el número de columnas");
        nCol = Integer.parseInt(leer.readLine());
        while (nFilas>=1 && nCol>=1)
            if (nFilas>5 && nCol>5) {
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
                    }
                    System.out.println("");
                }

//              Triángulo inferior
                for(int i = 0; i < nCol; i++) {
                    for( int j = 0; j < i; j++) {
                        cont2TriangInf = matriz[i][j];
                    }
                    contTriangInf++;
                }
                System.out.println();

                if (cont2TriangInf == 0) {
                    triangInf = true;
                    System.out.println("Es un triángulo inferior? " + triangInf);
                } else {
                    triangInf = false;
                    System.out.println("Es un triángulo inferior? False" + triangInf);
                }

//              Ttriangulo superior
                for(int i = 0; i < nCol; i++) {
                    for(int j = i; j <matriz[i].length-1; j++) {
                        cont2TriangSup = matriz[i][j];
                    }
                    contTriangSup++;
                }

                if (cont2TriangSup == 0) {
                    triangSup = true;
                    System.out.println("Es un triángulo superior? " +triangSup);
                } else {
                    triangSup = false;
                    System.out.println("Es un triángulo superior? " +triangSup);
                }

//                Imprimir diagonal principal
                System.out.print("La diagonal principal es: ");
                int sumaDiag = 0;
                for (int i = 0; i<matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (i == j) {
                            sumaDiag = +matriz[i][j];
                            System.out.print(matriz[i][j] + " ");
                        }
                    }
                }
                System.out.println();

                if (contTriangInf == 0 && contTriangSup == 0 && sumaDiag !=0) {
                    matrizDiagonal = true;
                } else {
                    matrizDiagonal = false;
                }
                System.out.println("Es la matriz diagonal? " + matrizDiagonal);

            nFilas = -1;
        }
        System.out.println("Gracias por usar este programa!");
    }
}



