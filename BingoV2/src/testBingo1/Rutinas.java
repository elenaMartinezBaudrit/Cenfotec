package testBingo1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rutinas{

    static int BOARD_SIZE = 5;
    static int[][] card = new int[BOARD_SIZE][BOARD_SIZE];

    /*****************************************************************
     * Rutina: cartonLleno
     * Prop?sito: Hacer juego BINGO donde el ganador sea el que tiene todos los numeros del carton en "x"
     * Par?metro:
     *
     * Retorna:
     *****************************************************************/

    static Random rand = new Random();

    public static void cartonLleno() {
        // TODO code application logic here
        int ctDeCartones = 2;
        int segundos = 1;
        Dealer dler;

        // Creando un Dealer
        dler = new SubDealer(ctDeCartones);
        dler.start();

        // Creando una variable para almacenar las referencias a los cartones
        Carton car;
        // Creando tantos cartones como indic� el usuario
        for (int i = 0; i < ctDeCartones; i++) {
            // Creando cartones. Parametros: nombre del jugador, dealer, segundos m�ximos que esperara para pedir bolos
            car = new Carton("Carton Del Jugador " + (i+1) , dler, segundos);
            car.start();
        }
    }

    public static void cuatroEsquinas() {
        // TODO code application logic here
        int ctDeCartones = 2, segundos;
        Dealer dler;

        Scanner sc = new Scanner(System.in);


//        TODO: make the "segundos a fixed value, not asking the user for this input
        System.out.println("Introduzca la cantidad máxima de segundos que esperará cada jugador:");
        segundos = sc.nextInt();

        // Creando un Dealer
        dler = new SubDealer(ctDeCartones);
        dler.start();

        // Creando una variable para almacenar las referencias a los cartones
        Carton car;
        // Creando tantos cartones como indic� el usuario
        for (int i = 0; i < ctDeCartones; i++) {
            // Creando cartones. Parametros: nombre del jugador, dealer, segundos m�ximos que esperara para pedir bolos
            car = new Carton("Carton Del Jugador " + (i+1) , dler, segundos);
            car.start();
        }
    }
}

class Dealer extends Thread {

    int ctDeCartones, boloGenerado, solicitudesDelBolo;

    boolean hayGanador = false;

    boolean[] bolosGenerados = new boolean[75];

    Dealer(int ctDeCartones) {
        this.ctDeCartones = ctDeCartones;
    }

    public void run() {

        while (!hayGanador) {

            do {
                boloGenerado = Rutinas.rand.nextInt(75) + 1;
            } while ((bolosGenerados[boloGenerado - 1]) && !hayGanador);
            bolosGenerados[boloGenerado - 1] = true;

            try {
                while ((solicitudesDelBolo < ctDeCartones) && !hayGanador) {
                    Thread.sleep(500);
                }
                solicitudesDelBolo = 0;
            } catch (Exception e) {
                System.out.println("DEALER: Ha ocurrido un error");
            }
        }
        System.out.println("DEALER: El Juego ha terminado!");
    }

    int obtenerBoloGenerado(String carton, int ultimoBoloRecibido) {

        String nuevoBoloGenerado;

        if (ultimoBoloRecibido == boloGenerado) {
            // -1 indica que no se ha generado un nuevo bolo
            System.out.println("DEALER: No hay un nuevo bolo para entregar al carton " + carton);
            return -1;
        } else {

            if (boloGenerado>0 && boloGenerado<=15) {
                nuevoBoloGenerado = "B"+boloGenerado;
            } else if (boloGenerado>15 && boloGenerado <=30){
                nuevoBoloGenerado = "I"+boloGenerado;
            } else if (boloGenerado>30 && boloGenerado <=45){
                nuevoBoloGenerado = "N"+boloGenerado;
            } else if (boloGenerado>45 && boloGenerado <=60){
                nuevoBoloGenerado = "G"+boloGenerado;
            } else {
                nuevoBoloGenerado = "O"+boloGenerado;
            }
            System.out.println("DEALER: Se entregó el bolo " +nuevoBoloGenerado+ " al " + carton);

            solicitudesDelBolo++;
            return boloGenerado;
        }
    }

    void cantarBingo(String carton) {
        System.out.println("DEALER: El carton " + carton + " canto BINGO!!!");
        hayGanador = true;
    }

    // Funcion que retorna si hay un ganador
    boolean hayUnGanador() {
        return hayGanador;
    }
}

class SubDealer extends Dealer {

    SubDealer() {
        super(1);
    }

    SubDealer(int a) {
        super(a);
    }
}

class Carton extends Thread {

    Dealer dealer;

    String nombreDelCarton;

    int carton[][] = new int[5][5];

    int ultimoBoloObtenido, segundos;

    Carton(String nombre, Dealer dlr, int segundos) {

        nombreDelCarton = nombre;

        dealer = dlr;

        this.segundos = segundos;

        // Generando carton
        int min, max, numero = 0;
        boolean numeroExistente;

        // Ciclo para generar los numeros de la primera columna
        for (int c = 0; c < 5; c++) {
            min = (c * 15) + 1;
            max = min + 14;
            for (int f = 0; f < 5; f++) {
                numeroExistente = true;
                while (numeroExistente) {
                    numero = Rutinas.rand.nextInt((max - min) + 1) + min;
                    numeroExistente = false;
                    for (int c1 = 0; c1 < 5; c1++) {
                        for (int f1 = 0; f1 < 5; f1++) {
                            if (numero == carton[f1][c1]) {
                                numeroExistente = true;
                            }
                        }
                    }
                }
                carton[f][c] = numero;
            }
        }
    }

    public void run() {
        int bolo;

        while (!dealer.hayUnGanador()) {

            // Esperando "segundos" segundos antes de pedir el bolo --> ESTO LO PUSE AUTOMATICO, hardcoded ;)
            try {
                Thread.sleep((Rutinas.rand.nextInt(segundos) + 1) * 1000);
            } catch (Exception e) {
                System.out.println(nombreDelCarton + ": Ha ocurrido un error!");
            }

            if (!dealer.hayUnGanador()) {
                bolo = dealer.obtenerBoloGenerado(nombreDelCarton, ultimoBoloObtenido);
                if (bolo == -1) {
                    System.out.println(nombreDelCarton + ": Aun no se ha generado un nuevo bolo. Sigo esperando.");
                } else {
                    synchronized (System.out) {

                        ultimoBoloObtenido = bolo;
                        String nuevoBolo;

                        if (bolo>0 && bolo<=15) {
                            nuevoBolo = "B"+bolo;
                        } else if (bolo>15 && bolo <=30){
                            nuevoBolo = "I"+bolo;
                        } else if (bolo>30 && bolo <=45){
                            nuevoBolo = "N"+bolo;
                        } else if (bolo>45 && bolo <=60){
                            nuevoBolo = "G"+bolo;
                        } else {
                            nuevoBolo = "O"+bolo;
                        }

                        if (validarBolo(bolo)) {
                            imprimirCarton();
                            if (validarCarton()) {
                                dealer.cantarBingo(nombreDelCarton);
                            }
                        } else {
                            System.out.println(nombreDelCarton + ": Bolo "+nuevoBolo+" no encontrado.");
                        }
                    }
                }
            }
        }
        System.out.println(nombreDelCarton + ": Saliendo del c�digo del carton");
    }

    boolean validarBolo(int bolo) {
        boolean boloEncontrado = false;
        buscandoBolo:
        {
            for (int f = 0; f < 5; f++) {
                for (int c = 0; c < 5; c++) {
                    if (carton[f][c] == bolo) {
                        carton[f][c] = carton[f][c] * -1;
                        boloEncontrado = true;
                        break buscandoBolo;
                    }
                }
            }
        }
        return boloEncontrado;
    }

    boolean validarCarton() {
        boolean cartonGanador = false;
        int contador_f = 0, contador_c = 0, contador_dp = 0, contador_ds = 0;

        validando:
        {
            for (int c1 = 0; c1 < 5; c1++) {
                contador_f = contador_c = 0;
                for (int c2 = 0; c2 < 5; c2++) {
                    if (carton[c1][c2] < 0) {
                        contador_f++;
                    }
                    if (carton[c2][c1] < 0) {
                        contador_c++;
                    }
                    if (contador_f == 5 && contador_c == 5) {
                        break validando;
                    }
                }
                if (carton[c1][c1] < 0) {
                    contador_dp++;
                }
                if (carton[c1][4 - c1] < 0) {
                    contador_ds++;
                }
            }
        }

        if (contador_f == 5 && contador_c == 5) {
            System.out.println(nombreDelCarton + ": Ganador carton lleno");
            cartonGanador = true;
        }
        return cartonGanador;
    }


//        TODO: Check this out... I guess this could work!
//    boolean validar4Esquinas() {
//        cartonGanador = false;
//
//        validando:
//        {
//            for (int c1 = 0; c1 < 5; c1++) {
//                for (int c2 = 0; c2 < 5; c2++) {
//                    if (carton[0][0] < 0 && carton[0][4] < 0 && carton[4][0] < 0 && carton[4][4] < 0) {
//                        cartonGanador = true;
//                    }
//                }
//            }
//        }
//        return cartonGanador;
//    }



    void imprimirCarton() {
        System.out.println();
        System.out.println(nombreDelCarton);
        System.out.println("  B    I    N    G    O");

        for (int f = 0; f < 5; f++) {
            System.out.println("--------------------------");
            for (int c = 0; c < 5; c++) {
                if (c == 0) {
                    System.out.print("|");
                }

                if (c == 2 && f == 2) {
                    System.out.print("FREE");
                } else if (carton[f][c] > 0) {
                    System.out.printf(" %2d ", carton[f][c]);
                } else {
                    System.out.printf(" X ", carton[f][c] * -1);
                }

                if (c == 4) {
                    System.out.println("|");
                } else {
                    System.out.print('|');
                }
            }
        }
        System.out.println("--------------------------");
        System.out.print('\n');
    }
}
